package com.fgc.service.saleout.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutBodySaveRule implements IRule<SaleOutHVO, SaleOutBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public void process(SaleOutHVO hvo, SaleOutBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(bvos);
			String cwarehouseid = hvo.getCwarehouseid();
			for(SaleOutBVO bvo :bvos){
				bvo.setVbdef1(cwarehouseid);
			}
		}
	}

	/**
	 * @param bvos
	 */
	private void setDefaultInfo(SaleOutBVO[] bvos) {
		for (SaleOutBVO bvo : bvos) {
			bvo.setPkGroup(pubInfoService.getPk_group());
			bvo.setPkOrg(pubInfoService.getPk_org());
		}
	}
}
