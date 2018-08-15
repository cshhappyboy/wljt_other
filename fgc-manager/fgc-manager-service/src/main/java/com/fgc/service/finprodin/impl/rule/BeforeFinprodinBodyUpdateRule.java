package com.fgc.service.finprodin.impl.rule;

import org.springframework.stereotype.Component;

import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMValueUtils;

/**
 * 产成品入库单业务保存前规则类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月1日
 *
 *     未来离线需求
 */
@Component
public class BeforeFinprodinBodyUpdateRule implements IRule<FinprodinHVO, FinprodinBVO> {

	@Override
	public void process(FinprodinHVO hvo, FinprodinBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			String cwarehouseid = hvo.getCwarehouseid();
			for(FinprodinBVO bvo : bvos){
				bvo.setVbdef3(cwarehouseid);
			}
		}
	}
}
