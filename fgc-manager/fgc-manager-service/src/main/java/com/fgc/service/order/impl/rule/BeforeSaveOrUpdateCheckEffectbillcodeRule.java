package com.fgc.service.order.impl.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 销售订单保存/修改校验表体的物料是否有有效订单号
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaveOrUpdateCheckEffectbillcodeRule {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private EffcetBillCodeRule rule;

	public void process(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		List<String> listMsg = new ArrayList<>();
		if (MMStringUtil.isEqual(hvo.getCbilltype(), pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"))) {
			for (OrderBVO bvo : bvos) {
				String cmaterial = bvo.getCmaterial();
				String sizecode = bvo.getSizecode();
				String materialcode = bvo.getMaterialcode();
				if (rule.isCan(cmaterial) && MMStringUtil.isEmpty(sizecode)) {
					this.contractMsg(listMsg, materialcode);
				} else if (!rule.isCan(cmaterial) && MMStringUtil.isNotEmpty(sizecode)) {
					bvo.setSizecode(null);
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}

	}

	private void contractMsg(List<String> listMsg, String materialcode) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("物料编码【" + materialcode + "】尺寸单号不能为空");
		listMsg.add(sBuilder.toString());
	}

}
