package com.fgc.service.finprodin.impl.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 产成品入库保存/修改校验表体的物料是否有有效订单号
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaveOrUpdateFinCheckEffectbillcodeRule {

	@Autowired
	private EffcetBillCodeRule rule;

	public void process(FinprodinHVO hvo, FinprodinBVO[] bvos) throws Exception {
		List<String> listMsg = new ArrayList<>();
		for (FinprodinBVO bvo : bvos) {
			String cmaterial = bvo.getCmaterial();
			String vbatchcode = bvo.getVbatchcode();
			String materialcode = bvo.getMaterialcode();
			if (rule.isCan(cmaterial) && MMStringUtil.isEmpty(vbatchcode)) {
				this.contractMsg(listMsg, materialcode);
			} else if (!rule.isCan(cmaterial) && MMStringUtil.isNotEmpty(vbatchcode)) {
				bvo.setVbatchcode(null);
			}
		}
		if (MMCollectionUtil.isNotEmpty(listMsg)) {
			throw new RuntimeException(listMsg.toString());
		}

	}

	private void contractMsg(List<String> listMsg, String materialcode) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("物料编码【" + materialcode + "】批次号不能为空");
		listMsg.add(sBuilder.toString());
	}
}
