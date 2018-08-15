package com.fgc.service.finprodin.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.service.pub.IPubInfoService;
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
public class BeforeFinprodinBodySaveRule implements IRule<FinprodinHVO, FinprodinBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public void process(FinprodinHVO hvo, FinprodinBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(bvos);
			String cwarehouseid = hvo.getCwarehouseid();
			for (FinprodinBVO bvo : bvos) {
				bvo.setVbdef3(cwarehouseid);
			}
		}

	}

	/**
	 * @param bvos
	 */
	private void setDefaultInfo(FinprodinBVO[] bvos) {
		for (FinprodinBVO bvo : bvos) {
			bvo.setPkGroup(pubInfoService.getPk_group());
			bvo.setPkOrg(pubInfoService.getPk_org());
		}
	}
}
