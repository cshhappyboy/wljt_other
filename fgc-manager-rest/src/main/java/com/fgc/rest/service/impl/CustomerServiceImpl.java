package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.CustomerVOMapper;
import com.fgc.pojo.CustomerVO;
import com.fgc.pojo.CustomerVOExample;
import com.fgc.pojo.CustomerVOExample.Criteria;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.ICustomerService;
import com.fgc.rest.service.IPubInfoService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 客户档案服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private CustomerVOMapper customerVOMapper;

	@Override
	public EUDataGridResult queryData(String filterData) throws Exception {
		CustomerVOExample example = new CustomerVOExample();
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
		List<CustomerVO> listCustomers = customerVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listCustomers)) {
			BaseDataVO bd = null;
			for (CustomerVO customerVO : listCustomers) {
				bd = new BaseDataVO();
				bd.setId(customerVO.getPkcustomer());
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
	public WebAppResult queryNameById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			CustomerVO customerVO = customerVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(customerVO)) {
				String name = customerVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
