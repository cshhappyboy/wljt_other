package com.fgc.service.receipt.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.ReceiptHVO;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.ISRule;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 保存前规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
@Component
public class BeforeReceiptSaveRule implements ISRule<ReceiptHVO> {

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public void process(ReceiptHVO hvo) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo)) {
			// 设置集团组织
			this.setDefaultValue(hvo);
			// 生成有效订单号
			this.generateEffectBillCode(hvo);
		}
	}

	/**
	 * @param hvo
	 * @throws Exception
	 */
	private void generateEffectBillCode(ReceiptHVO hvo) throws Exception {
		String effectbillcode = hvo.getEffectbillcode();
		if (MMStringUtil.isEmpty(effectbillcode)) {
			String generateEffectBillCode = billCodeService.generateEffectBillCode(hvo.getCdept());
			hvo.setEffectbillcode(generateEffectBillCode);
		}
	}

	/**
	 * @param hvo
	 * 			@throws
	 */
	private void setDefaultValue(ReceiptHVO hvo) {
		hvo.setPkGroup(pubInfoService.getPk_group());
		hvo.setPkOrg(pubInfoService.getPk_org());

	}
}
