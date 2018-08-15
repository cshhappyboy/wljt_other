package com.fgc.service.whstrans.impl.rule;

import org.springframework.stereotype.Component;

import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
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
public class BeforeWhstransBodyUpdateRule implements IRule<WhstransHVO, WhstransBVO> {

	@Override
	public void process(WhstransHVO hvo, WhstransBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
		}
	}

}
