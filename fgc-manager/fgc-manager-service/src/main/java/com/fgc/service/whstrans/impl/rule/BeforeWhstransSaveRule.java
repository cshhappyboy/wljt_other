package com.fgc.service.whstrans.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMStringUtil;
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
public class BeforeWhstransSaveRule implements IRule<WhstransHVO, WhstransBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Override
	public void process(WhstransHVO hvo, WhstransBVO[] bvos) {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(hvo, bvos);
			this.setDefaultData(hvo);
		}
	}

	/**
	 * @param hvo
	 */
	private void setDefaultData(WhstransHVO hvo) {
		String cbilltype = hvo.getCbilltype();
		if (MMStringUtil.isNotEmpty(cbilltype)) {
			BilltypeVO billtypeVO = billtypeVOMapper.selectByPrimaryKey(cbilltype);
			hvo.setVbilltype(billtypeVO.getPkbilltypecode());
		}
	}

	/**
	 * @param hvo
	 * @param bvos
	 */
	private void setDefaultInfo(WhstransHVO hvo, WhstransBVO[] bvos) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		hvo.setPkGroup(pk_group);
		hvo.setPkOrg(pk_org);
		for (WhstransBVO bvo : bvos) {
			bvo.setPkGroup(pk_group);
			bvo.setPkOrg(pk_org);
		}
	}
}
