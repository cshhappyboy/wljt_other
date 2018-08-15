package com.fgc.service.order.impl.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderHVO;
import com.fgc.service.order.IOrderService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.model.SessionInfo;
import com.pub.utils.JsonTS;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 如果是退货，保存之后自动审核
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月25日
 *
 *     未来离线需求
 */
@Component
public class AfterSaveApproveRule {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private IOrderService orderService;

	public void process(OrderHVO hvo, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo)) {
			String cbilltype = hvo.getCbilltype();
			if (MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"))) {
				JsonTS jsonTS= new JsonTS();
				List<OrderHVO> listHVOs = new ArrayList<>();
				jsonTS.setData(JsonUtils.objectToJson(listHVOs.add(hvo)));
				orderService.approveOrderVOs(jsonTS, sessionInfo, true);
			}
		}
	}
}
