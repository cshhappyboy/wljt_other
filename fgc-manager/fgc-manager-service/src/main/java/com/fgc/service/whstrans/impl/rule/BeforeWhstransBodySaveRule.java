package com.fgc.service.whstrans.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMValueUtils;

/**
 * 转库单保存前业务规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月5日
 *
 *     未来离线需求
 */
@Component
public class BeforeWhstransBodySaveRule implements IRule<WhstransHVO, WhstransBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public void process(WhstransHVO hvo, WhstransBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(bvos);
		}
	}

	/**
	 * @param bvos
	 */
	private void setDefaultInfo(WhstransBVO[] bvos) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		for (WhstransBVO bvo : bvos) {
			bvo.setPkGroup(pk_group);
			bvo.setPkOrg(pk_org);
		}
	}

}
