package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.invoice.impl.util.InvoiceChangeUtils;
import com.fgc.service.saleout.ISaleOutService;
import com.pub.model.SessionInfo;
import com.pub.utils.AggVO;
import com.pub.utils.JsonBill;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月14日
 *
 *     未来离线需求
 */
@Component
public class AfterInvoiceApproveRule {
	
	@Autowired
	private InvoiceChangeUtils invoiceChangeUtils;
	
	@Autowired
	private ISaleOutService saleOutService;
	
	@Autowired
	private OrderHVOMapper orderHVOMapper;

	/**
	 * @param aggVOs
	 * @throws Exception
	 */
	public void process(List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs, SessionInfo sessionInfo) throws Exception {
		if (MMCollectionUtil.isNotEmpty(aggVOs)) {
			this.rewriteOrder(aggVOs);
			List<JsonBill> listJsonBills = invoiceChangeUtils.changeVO2SaleOutVOBatch(aggVOs,sessionInfo.getNowDate());
			saleOutService.saveSaleOutVOBatch(listJsonBills, sessionInfo);
		}
	}

	/**
	 * @param aggVOs
	 */
	private void rewriteOrder(List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs) {
		if(MMCollectionUtil.isNotEmpty(aggVOs)){
			for(AggVO<InvoiceHVO, InvoiceBVO> aggVO : aggVOs){
				InvoiceHVO headVO = aggVO.getHeadVO();
				String vsrcid = headVO.getVsrcid();
				if(MMStringUtil.isNotEmpty(vsrcid)){
					OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
					BigDecimal nreceivedmny = orderHVO.getNreceivedmny();
					BigDecimal retainage = headVO.getRetainage();
					orderHVO.setNreceivedmny(MMNumberUtil.add(nreceivedmny,retainage));
					PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
					orderHVOMapper.updateByPrimaryKey(orderHVO);
				}
			}
		}
	}

}
