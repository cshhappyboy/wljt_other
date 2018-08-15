package com.fgc.service.receipt.impl.rule;

import org.springframework.stereotype.Component;

import com.fgc.pojo.ReceiptHVO;
import com.pub.rule.ISRule;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeReceiptUpdateRule implements ISRule<ReceiptHVO> {

	@Override
	public void process(ReceiptHVO hvo) throws Exception {
		// 补充VO数据
	}
}
