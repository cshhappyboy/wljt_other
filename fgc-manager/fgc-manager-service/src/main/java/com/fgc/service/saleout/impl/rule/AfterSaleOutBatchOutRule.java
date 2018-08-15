package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.InvoiceBVOMapper;
import com.fgc.mapper.InvoiceHVOMapper;
import com.fgc.mapper.OrderBVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.AggVO;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月17日
 *
 *     未来离线需求
 */
@Component
public class AfterSaleOutBatchOutRule {

	@Autowired
	private InvoiceHVOMapper invoiceHVOMapper;

	@Autowired
	private InvoiceBVOMapper invoiceBVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	public void process(List<AggVO<SaleOutHVO, SaleOutBVO>> aggVOs) throws Exception {
		for (AggVO<SaleOutHVO, SaleOutBVO> aggVO : aggVOs) {
			SaleOutHVO hvo = aggVO.getHeadVO();
			SaleOutBVO[] bvos = aggVO.getBodyVOs();
			String vsrcid = hvo.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				// 回写发票表头
				InvoiceHVO invoiceHVO = invoiceHVOMapper.selectByPrimaryKey(vsrcid);
				BigDecimal ntotaloutnum = invoiceHVO.getNtotaloutnum();

				BigDecimal ntotalnum = hvo.getNtotalnum();
				invoiceHVO.setNtotaloutnum(MMNumberUtil.add(ntotaloutnum, ntotalnum));
				invoiceHVO.setAlreadyout(1L);
				PojoTools.beforeUpdate(InvoiceHVO.class, invoiceHVO);
				invoiceHVOMapper.updateByPrimaryKey(invoiceHVO);

				for (SaleOutBVO saleOutBVO : bvos) {
					String vsrcbid = saleOutBVO.getVsrcbid();
					// 回写发票表体
					if (MMStringUtil.isNotEmpty(vsrcbid)) {
						InvoiceBVO invoiceBVO = invoiceBVOMapper.selectByPrimaryKey(vsrcbid);
						BigDecimal noutnum = invoiceBVO.getNoutnum();

						BigDecimal nassistnum = saleOutBVO.getNassistnum();
						invoiceBVO.setNoutnum(MMNumberUtil.add(noutnum, nassistnum));
						PojoTools.beforeUpdate(InvoiceBVO.class, invoiceBVO);
						invoiceBVOMapper.updateByPrimaryKey(invoiceBVO);
					}

					String vorderbid = saleOutBVO.getVorderbid();

					OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vorderbid);
					// 出库主数量
					BigDecimal noutnum = orderBVO.getNoutnum();
					BigDecimal nnum = saleOutBVO.getNnum();
					orderBVO.setNoutnum(MMNumberUtil.add(noutnum, nnum));
					// 出库数量
					BigDecimal noutnastum = orderBVO.getNoutnastum();
					BigDecimal nassistnum = saleOutBVO.getNassistnum();
					orderBVO.setNoutnastum(MMNumberUtil.add(noutnastum, nassistnum));
					PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
					orderBVOMapper.updateByPrimaryKey(orderBVO);
				}
			}
		}
	}
}
