package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.InvoiceBVOMapper;
import com.fgc.mapper.InvoiceHVOMapper;
import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceBVOExample;
import com.fgc.pojo.InvoiceBVOExample.Criteria;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 销售发票删除后业务规则类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月30日
 *
 *     未来离线需求
 */
@Component
public class BeforerInvoiceDeleteRule {

	@Autowired
	private InvoiceHVOMapper invoiceHVOMapper;

	@Autowired
	private InvoiceBVOMapper invoiceBVOMapper;

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	/**
	 * @param newJsonBill
	 * @param oldJsonBill
	 */
	public void process(List<String> listIds)throws Exception {
		for (String id : listIds) {
			InvoiceHVO headVO = invoiceHVOMapper.selectByPrimaryKey(id);
			String vsrcid = headVO.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
				BigDecimal ntotalinvoicenum = orderHVO.getNtotalinvoicenum();
				BigDecimal ntotalinvoicemny = orderHVO.getNtotalinvoicemny();
				orderHVO.setNtotalinvoicenum(MMNumberUtil.subtract(ntotalinvoicenum, headVO.getNtotalnum()));
				orderHVO.setNtotalinvoicemny(MMNumberUtil.subtract(ntotalinvoicemny, headVO.getNtotalmny()));
				if(MMNumberUtil.isEqualZero(orderHVO.getNtotalinvoicenum())){
					orderHVO.setAlreadyinvoice(0L);
				}
				PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
				orderHVOMapper.updateByPrimaryKey(orderHVO);

				// 2、表体数量回写
				InvoiceBVOExample example = new InvoiceBVOExample();
				Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(id);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<InvoiceBVO> listBVOs = invoiceBVOMapper.selectByExample(example);
				for (InvoiceBVO bvo : listBVOs) {
					String vsrcbid = bvo.getVsrcbid();
					if (MMStringUtil.isNotEmpty(vsrcbid)) {
						OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
						BigDecimal salenum = bvo.getSalenum();
						BigDecimal nastnum = bvo.getNastnum();
						BigDecimal nnum = bvo.getNnum();
						BigDecimal nmny = bvo.getNmny();
						
						BigDecimal ninvoicesalenum = orderBVO.getNinvoicesalenum();
						orderBVO.setNinvoicesalenum(MMNumberUtil.subtract(ninvoicesalenum, salenum));
						BigDecimal ninvoicemny = orderBVO.getNinvoicemny();
						orderBVO.setNinvoicemny(MMNumberUtil.subtract(ninvoicemny, nmny));
						BigDecimal ninvoicenastnum = orderBVO.getNinvoicenastnum();
						orderBVO.setNinvoicenastnum(MMNumberUtil.subtract(ninvoicenastnum, nastnum));
						BigDecimal ninvoicenum = orderBVO.getNinvoicenum();
						orderBVO.setNinvoicenum(MMNumberUtil.subtract(ninvoicenum, nnum));
						PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
						orderBVOMapper.updateByPrimaryKey(orderBVO);
					}
				}
			}
		}
	}
}
