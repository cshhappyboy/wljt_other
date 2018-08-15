package com.fgc.service.order.impl.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.invoice.InvoiceService;
import com.fgc.service.order.impl.util.OrderChangeUtils;
import com.fgc.service.pub.IPubInfoService;
import com.pub.model.SessionInfo;
import com.pub.utils.AggVO;
import com.pub.utils.JsonBill;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月13日
 *
 *     未来离线需求
 */
@Component
public class AfterOrderApproveRule {

	@Autowired
	private OrderChangeUtils orderChangeUtils;

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private InvoiceService invoiceService;

	public void process(List<AggVO<OrderHVO, OrderBVO>> listAggVOs, SessionInfo sessionInfo) throws Exception {
		List<AggVO<OrderHVO, OrderBVO>> newListAggVOs = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listAggVOs)) {
			for (AggVO<OrderHVO, OrderBVO> aggVO : listAggVOs) {
				OrderHVO headVO = aggVO.getHeadVO();
				String cbilltype = headVO.getCbilltype();
				if (MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"))
						|| MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"))) {
					newListAggVOs.add(aggVO);
				}
			}
		}
		List<JsonBill> listJsonBills = orderChangeUtils.changeVO2InvoiceVO(newListAggVOs, sessionInfo.getNowDate());
		invoiceService.pushInvoiceVOs(listJsonBills, sessionInfo);
	}

}
