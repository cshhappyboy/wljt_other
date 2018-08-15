package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 销售发票保存后业务规则类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月30日
 *
 *     未来离线需求
 */
@Component
public class AfterInvoiceSaveRule implements IRule<InvoiceHVO, InvoiceBVO> {

	@Autowired
	private OrderHVOMapper orderHVOMapper;
	
	@Autowired
	private OrderBVOMapper orderBVOMapper;

	@Override
	public void process(InvoiceHVO hvo, InvoiceBVO[] bvos) {
		/**
		 * 销售发票需要回写销售订单
		 */
		String vsrcid = hvo.getVsrcid();
		if (MMStringUtil.isNotEmpty(vsrcid)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
			orderHVO.setAlreadyinvoice(1L);
			BigDecimal ntotalinvoicenum = orderHVO.getNtotalinvoicenum();
			BigDecimal ntotalinvoicemny = orderHVO.getNtotalinvoicemny();
			
			orderHVO.setNtotalinvoicenum(MMNumberUtil.add(ntotalinvoicenum, hvo.getNtotalnum()));
			orderHVO.setNtotalinvoicemny(MMNumberUtil.add(ntotalinvoicemny,hvo.getNtotalmny()));
			
			PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
			orderHVOMapper.updateByPrimaryKey(orderHVO);
			for(InvoiceBVO bvo : bvos){
				String vsrcbid = bvo.getVsrcbid();
				if(MMStringUtil.isNotEmpty(vsrcbid)){
					OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
					BigDecimal ninvoicesalenum = orderBVO.getNinvoicesalenum();
					ninvoicesalenum= MMNumberUtil.add(ninvoicesalenum,bvo.getSalenum());
					orderBVO.setNinvoicesalenum(ninvoicesalenum);
					
					//回写主数量
					BigDecimal ninvoicenum = orderBVO.getNinvoicenum();
					orderBVO.setNinvoicenum(MMNumberUtil.add(ninvoicenum,bvo.getNnum()));
					//回写辅数量
					BigDecimal ninvoicenastnum = orderBVO.getNinvoicenastnum();
					orderBVO.setNinvoicenastnum(MMNumberUtil.add(ninvoicenastnum,bvo.getNastnum()));
					//反写金额
					BigDecimal ninvoicemny =orderBVO.getNinvoicemny();
					orderBVO.setNinvoicemny(MMNumberUtil.add(ninvoicemny,bvo.getNmny()));
					
					PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
					orderBVOMapper.updateByPrimaryKey(orderBVO);
				}
			}
		}
	}

}
