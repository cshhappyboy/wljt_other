package com.fgc.service.pub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.DeptVOMapper;
import com.fgc.mapper.PubParamVOMapper;
import com.fgc.pojo.DeptVO;
import com.fgc.pojo.PubParamVO;
import com.fgc.pojo.PubParamVOExample;
import com.fgc.pojo.PubParamVOExample.Criteria;
import com.fgc.pojo.util.PubParam;
import com.fgc.service.pub.IPubInfoService;

/**
 * 公共服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
@Service
public class PubInfoServiceImpl implements IPubInfoService {

	@Autowired
	private PubParamVOMapper pubParamVOMapper;

	@Autowired
	private DeptVOMapper deptVOMapper;

	@Override
	public String getPk_group() {
		return this.getValueByCode(PubParam.PK_GROUP);
	}

	@Override
	public String getPk_org() {
		return this.getValueByCode(PubParam.PK_ORG);
	}

	@Override
	public String getCurrency() {
		return this.getValueByCode(PubParam.CURRTYPE_DEFAULT);
	}

	@Override
	public String getCashaccount(String cdept) {
		DeptVO deptVO = deptVOMapper.selectByPrimaryKey(cdept);
		return deptVO.getVdef2();
	}

	@Override
	public String getValueByCode(String code) {
		PubParamVOExample example = new PubParamVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<PubParamVO> list = pubParamVOMapper.selectByExample(example);
		String value = list.get(0).getValue();
		return value;
	}
}
