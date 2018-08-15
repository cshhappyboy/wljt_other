package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.StordocVOMapper;
import com.fgc.mapper.UserWarehouseVOMapper;
import com.fgc.pojo.StordocVO;
import com.fgc.pojo.StordocVOExample;
import com.fgc.pojo.StordocVOExample.Criteria;
import com.fgc.pojo.UserWarehouseVO;
import com.fgc.pojo.UserWarehouseVOExample;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.IPubInfoService;
import com.fgc.rest.service.IStoredocService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
@Service
public class StoredocServiceImpl implements IStoredocService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private StordocVOMapper stordocVOMapper;
	
	@Autowired
	private UserWarehouseVOMapper userWarehouseVOMapper;

	@Override
	public EUDataGridResult queryData(String filterData,String userId) throws Exception {
		EUDataGridResult result = new EUDataGridResult();
		List<String> listIds = new ArrayList<>();
		if(MMStringUtil.isNotEmpty(userId)){
			UserWarehouseVOExample example = new UserWarehouseVOExample();
			com.fgc.pojo.UserWarehouseVOExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);
			List<UserWarehouseVO> listWarehouseVOs = userWarehouseVOMapper.selectByExample(example);
			if(MMCollectionUtil.isNotEmpty(listWarehouseVOs)){
				for (UserWarehouseVO userWarehouseVO : listWarehouseVOs) {
					listIds.add(userWarehouseVO.getWarehouseId());
				}
			}else{
				return result;
			}
		}
		
		StordocVOExample example = new StordocVOExample();
		example.setOrderByClause("code");
		Criteria criteria = example.createCriteria();

		String pk_org = pubInfoService.getPk_org();
		criteria.andPkorgEqualTo(pk_org);
		criteria.andVdef4EqualTo("2");
		if(MMCollectionUtil.isNotEmpty(listIds)){
			criteria.andPkstordocIn(listIds);
		}
		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andCodeLike("%" + filterData + "%");

			Criteria createCriteria = example.createCriteria();
			example.or(createCriteria);
			if(MMCollectionUtil.isNotEmpty(listIds)){
				createCriteria.andPkstordocIn(listIds);
			}
			createCriteria.andPkorgEqualTo(pk_org);
			createCriteria.andVdef4EqualTo("2");
			createCriteria.andNameLike("%" + filterData + "%");
		}
		List<StordocVO> listCustomers = stordocVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listCustomers)) {
			BaseDataVO bd = null;
			for (StordocVO stordocVO : listCustomers) {
				bd = new BaseDataVO();
				bd.setId(stordocVO.getPkstordoc());
				bd.setCode(stordocVO.getCode());
				bd.setName(stordocVO.getName());
				listBDs.add(bd);
			}
		}
		result.setRows(listBDs);
		result.setTotal(listBDs.size());

		return result;
	}

	@Override
	public WebAppResult transNameById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			StordocVO stordocVO = stordocVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(stordocVO)) {
				String name = stordocVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
