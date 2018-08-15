package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.CashAccountVOMapper;
import com.fgc.pojo.CashAccountVO;
import com.fgc.pojo.CashAccountVOExample;
import com.fgc.pojo.CashAccountVOExample.Criteria;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.ICashaccountService;
import com.fgc.rest.service.IPubInfoService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
@Service
public class CashaccountServiceImpl implements ICashaccountService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private CashAccountVOMapper cashAccountVOMapper;

	@Override
	public EUDataGridResult queryData(String filterData) throws Exception {
		CashAccountVOExample example = new CashAccountVOExample();
		example.setOrderByClause("code");
		Criteria criteria = example.createCriteria();

		String pk_org = pubInfoService.getPk_org();
		criteria.andPkorgEqualTo(pk_org);
		criteria.andVdef4EqualTo("2");
		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andCodeLike("%" + filterData + "%");

			Criteria createCriteria = example.createCriteria();

			example.or(createCriteria);
			createCriteria.andNameLike("%" + filterData + "%");
		}
		List<CashAccountVO> listCashAccountVOs = cashAccountVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listCashAccountVOs)) {
			BaseDataVO bd = null;
			for (CashAccountVO cashAccountVO : listCashAccountVOs) {
				bd = new BaseDataVO();
				bd.setId(cashAccountVO.getPkcashaccount());
				bd.setCode(cashAccountVO.getCode());
				bd.setName(cashAccountVO.getName());
				listBDs.add(bd);
			}
		}
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(listBDs);
		result.setTotal(listBDs.size());

		return result;
	}

	@Override
	public WebAppResult queryNameById(String id, String local) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			CashAccountVO cashAccountVO = cashAccountVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(cashAccountVO)) {
				String name = null;
				name = cashAccountVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
