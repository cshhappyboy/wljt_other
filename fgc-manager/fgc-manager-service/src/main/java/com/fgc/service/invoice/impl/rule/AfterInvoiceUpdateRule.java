package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMCollectionUtil;
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
public class AfterInvoiceUpdateRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	/**
	 * @param newJsonBill
	 * @param oldJsonBill
	 */
	public void process(JsonBill newJsonBill, JsonBill oldJsonBill) {
		/**
		 * 发票修改保存回写销售订单，这里逻辑较为复杂，请看我慢慢敲出来
		 */

		// 1、表头开票数量回写
		String head = newJsonBill.getHead();
		String oldHead = oldJsonBill.getHead();

		InvoiceHVO headVO = JsonUtils.jsonToPojo(head, InvoiceHVO.class);
		InvoiceHVO oldHeadVO = JsonUtils.jsonToPojo(oldHead, InvoiceHVO.class);

		String vsrcid = headVO.getVsrcid();
		if (MMStringUtil.isNotEmpty(vsrcid)) {
			BigDecimal changeNum = MMNumberUtil.subtract(headVO.getNtotalnum(), oldHeadVO.getNtotalnum());
			BigDecimal changMny = MMNumberUtil.subtract(headVO.getNtotalmny(), oldHeadVO.getNtotalmny());
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
			BigDecimal ntotalinvoicenum = orderHVO.getNtotalinvoicenum();
			BigDecimal ntotalinvoicemny = orderHVO.getNtotalinvoicemny();
			
			orderHVO.setNtotalinvoicenum(MMNumberUtil.add(ntotalinvoicenum, changeNum));
			orderHVO.setNtotalinvoicemny(MMNumberUtil.add(ntotalinvoicemny,changMny));
			PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
			orderHVOMapper.updateByPrimaryKey(orderHVO);

			// 2、表体数量回写
			// 2.1、表体是新增的咱就不管，因为没有上下游关系
			// 2.2、表体是修改的跟表体一样，把旧的减掉，再加上老的
			String updateBodys = newJsonBill.getUpdateBodys();
			String oldBodys = oldJsonBill.getRealyBodys();
			List<InvoiceBVO> updateBVOs = JsonUtils.jsonToList(updateBodys, InvoiceBVO.class);
			List<InvoiceBVO> oldBVOs = JsonUtils.jsonToList(oldBodys, InvoiceBVO.class);
			if (MMCollectionUtil.isNotEmpty(updateBVOs)) {
				for (InvoiceBVO bvo : updateBVOs) {
					String id = bvo.getId();
					for (InvoiceBVO oldBVO : oldBVOs) {
						String oldID = oldBVO.getId();
						if (MMStringUtil.isEqual(id, oldID)) {
							String vsrcbid = bvo.getVsrcbid();
							if (MMStringUtil.isNotEmpty(vsrcbid)) {
								OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
								BigDecimal salenum = bvo.getSalenum();
								BigDecimal oldSalenum = oldBVO.getSalenum();
								BigDecimal bUpdateChangeSaleNum = MMNumberUtil.subtract(salenum, oldSalenum);
								BigDecimal ninvoicesalenum = orderBVO.getNinvoicesalenum();
								orderBVO.setNinvoicesalenum(MMNumberUtil.add(ninvoicesalenum, bUpdateChangeSaleNum));
								
								
								//回写主数量
								BigDecimal nnum = bvo.getNnum();
								BigDecimal oldNnum = oldBVO.getNnum();
								BigDecimal bUpdateChangeNnum = MMNumberUtil.subtract(nnum, oldNnum);
								BigDecimal ninvoicenum = orderBVO.getNinvoicenum();
								orderBVO.setNinvoicenum(MMNumberUtil.add(ninvoicenum,bUpdateChangeNnum));
								
								//回写辅数量
								BigDecimal nastnum = bvo.getNastnum();
								BigDecimal oldNastnum = oldBVO.getNastnum();
								BigDecimal bUpdateChangeNastnum = MMNumberUtil.subtract(nastnum, oldNastnum);
								BigDecimal ninvoicenastnum = orderBVO.getNinvoicenastnum();
								orderBVO.setNinvoicenastnum(MMNumberUtil.add(ninvoicenastnum,bUpdateChangeNastnum));
								//反写金额
								BigDecimal nmny = bvo.getNmny();
								BigDecimal oldNmny = oldBVO.getNmny();
								BigDecimal bUpdateChangeNmny = MMNumberUtil.subtract(nmny, oldNmny);
								BigDecimal ninvoicemny =orderBVO.getNinvoicemny();
								orderBVO.setNinvoicemny(MMNumberUtil.add(ninvoicemny,bUpdateChangeNmny));
								
								PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
								orderBVOMapper.updateByPrimaryKey(orderBVO);
							}
						}
					}
				}
			}

			// 2.3、表体是删除的重置对应的销售订单的已开票销售数量和已开票主数量
			String deleteBodys = newJsonBill.getDeleteBodys();
			List<InvoiceBVO> deleteBVOs = JsonUtils.jsonToList(deleteBodys, InvoiceBVO.class);
			if (MMCollectionUtil.isNotEmpty(deleteBVOs)) {
				for (InvoiceBVO bvo : deleteBVOs) {
					String vsrcbid = bvo.getVsrcbid();
					if (MMStringUtil.isNotEmpty(vsrcbid)) {
						OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
						BigDecimal salenum = bvo.getSalenum();
						BigDecimal ninvoicesalenum = orderBVO.getNinvoicesalenum();
						orderBVO.setNinvoicesalenum(MMNumberUtil.subtract(ninvoicesalenum, salenum));
						
						//回写主数量
						BigDecimal nnum = bvo.getNnum();
						BigDecimal ninvoicenum = orderBVO.getNinvoicenum();
						orderBVO.setNinvoicenum(MMNumberUtil.subtract(ninvoicenum,nnum));
						
						//回写辅数量
						BigDecimal nastnum = bvo.getNastnum();
						BigDecimal ninvoicenastnum = orderBVO.getNinvoicenastnum();
						orderBVO.setNinvoicenastnum(MMNumberUtil.subtract(ninvoicenastnum,nastnum));
						//反写金额
						BigDecimal nmny = bvo.getNmny();
						BigDecimal ninvoicemny =orderBVO.getNinvoicemny();
						orderBVO.setNinvoicemny(MMNumberUtil.subtract(ninvoicemny,nmny));
						
						PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
						orderBVOMapper.updateByPrimaryKey(orderBVO);
					}
				}
			}
		}
	}
}
