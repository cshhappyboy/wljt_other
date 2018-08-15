package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.InvoiceBVOMapper;
import com.fgc.mapper.InvoiceHVOMapper;
import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.SaleOutBVOMapper;
import com.fgc.mapper.SaleOutHVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutBVOExample;
import com.fgc.pojo.SaleOutBVOExample.Criteria;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;

/**
 * 销售出库删除回写销售发票和销售订单
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月15日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutUnSignRule {

	@Autowired
	private SaleOutBVOMapper outBVOMapper;

	@Autowired
	private SaleOutHVOMapper outHVOMapper;

	@Autowired
	private InvoiceHVOMapper invoiceHVOMapper;

	@Autowired
	private InvoiceBVOMapper invoiceBVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	public void process(List<String> listIds) {
		for (String id : listIds) {
			SaleOutHVO headVO = outHVOMapper.selectByPrimaryKey(id);
			String vsrcid = headVO.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				InvoiceHVO invoiceHVO = invoiceHVOMapper.selectByPrimaryKey(vsrcid);
				BigDecimal ntotaloutnum = invoiceHVO.getNtotaloutnum();
				invoiceHVO.setNtotaloutnum(MMNumberUtil.subtract(ntotaloutnum, headVO.getNtotalnum()));
				invoiceHVOMapper.updateByPrimaryKey(invoiceHVO);

				// 2、表体数量回写

				SaleOutBVOExample example = new SaleOutBVOExample();
				Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(id);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<SaleOutBVO> listBVOs = outBVOMapper.selectByExample(example);
				for (SaleOutBVO bvo : listBVOs) {
					String vsrcbid = bvo.getVsrcbid();
					if (MMStringUtil.isNotEmpty(vsrcbid)) {
						InvoiceBVO invoiceBVO = invoiceBVOMapper.selectByPrimaryKey(vsrcbid);
						BigDecimal noutnum = invoiceBVO.getNoutnum();
						BigDecimal nassistnum = bvo.getNassistnum();
						invoiceBVO.setNoutnum(MMNumberUtil.subtract(noutnum, nassistnum));
						invoiceBVOMapper.updateByPrimaryKey(invoiceBVO);
					}

					String vorderbid = bvo.getVorderbid();
					if (MMStringUtil.isNotEmpty(vorderbid)) {
						OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vorderbid);
						BigDecimal noutnastum = orderBVO.getNoutnastum();
						BigDecimal nassistnum = bvo.getNassistnum();
						orderBVO.setNoutnastum(MMNumberUtil.subtract(noutnastum, nassistnum));
						BigDecimal noutnum = orderBVO.getNoutnum();
						BigDecimal nnum = bvo.getNnum();
						orderBVO.setNoutnum(MMNumberUtil.subtract(noutnum, nnum));
						orderBVOMapper.updateByPrimaryKey(orderBVO);
					}
				}
			}
		}
	}

}
