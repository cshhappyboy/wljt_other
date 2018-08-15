package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.CurrtypeVOMapper;
import com.fgc.pojo.CurrtypeVO;
import com.fgc.pojo.CurrtypeVOExample;
import com.fgc.pojo.CurrtypeVOExample.Criteria;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.ICurrencyService;
import com.pub.model.Local;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Service
public class CurrencyServiceImpl implements ICurrencyService {

	@Autowired
	private CurrtypeVOMapper currtypeVOMapper;

	@Override
	public EUDataGridResult queryData(String filterData) throws Exception {
		CurrtypeVOExample example = new CurrtypeVOExample();
		Criteria criteria = example.createCriteria();
		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andCodeLike("%" + filterData + "%");

			Criteria createCriteria = example.createCriteria();

			example.or(createCriteria);
			createCriteria.andNameLike("%" + filterData + "%");
		}
		List<CurrtypeVO> listCurrtypeVOs = currtypeVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listCurrtypeVOs)) {
			BaseDataVO bd = null;
			for (CurrtypeVO customerVO : listCurrtypeVOs) {
				bd = new BaseDataVO();
				bd.setId(customerVO.getPkcurrtype());
				bd.setCode(customerVO.getCode());
				bd.setName(customerVO.getName());
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
			CurrtypeVO currtypeVO = currtypeVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(currtypeVO)) {
				String name = null;
				if (MMStringUtil.isEqual(local, Local.CH)) {
					name = currtypeVO.getName();
				} else {
					name = currtypeVO.getCurrtypesign();
				}
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
