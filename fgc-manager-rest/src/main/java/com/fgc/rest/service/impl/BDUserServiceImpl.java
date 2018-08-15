package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.UserVOMapper;
import com.fgc.pojo.UserVO;
import com.fgc.pojo.UserVOExample;
import com.fgc.pojo.UserVOExample.Criteria;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.IBDUserService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.WebAppResult;

/**
 * 服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Service
public class BDUserServiceImpl implements IBDUserService {

	@Autowired
	private UserVOMapper userVOMapper;

	@Override
	public WebAppResult queryNameById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			UserVO userVO = userVOMapper.selectByPrimaryKey(id);
			String username = userVO.getUsername();
			return WebAppResult.ok(username);
		}
		return null;
	}

	@Override
	public EUDataGridResult queryData(String filterData) throws Exception {
		UserVOExample example = new UserVOExample();
		example.setOrderByClause("usercode");
		Criteria criteria = example.createCriteria();
		criteria.andVdef4EqualTo("2");
		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andUsercodeLike("%" + filterData + "%");

			Criteria createCriteria = example.createCriteria();

			example.or(createCriteria);
			createCriteria.andUsernameLike("%" + filterData + "%");
		}
		List<UserVO> listUserVOs = userVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listUserVOs)) {
			BaseDataVO bd = null;
			for (UserVO customerVO : listUserVOs) {
				bd = new BaseDataVO();
				bd.setId(customerVO.getCuserid());
				bd.setCode(customerVO.getUsercode());
				bd.setName(customerVO.getUsername());
				listBDs.add(bd);
			}
		}
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(listBDs);
		result.setTotal(listBDs.size());

		return result;
	}

}
