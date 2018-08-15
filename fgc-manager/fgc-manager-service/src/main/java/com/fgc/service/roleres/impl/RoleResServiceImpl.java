package com.fgc.service.roleres.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.RoleResVOMapper;
import com.fgc.pojo.RoleResVO;
import com.fgc.pojo.RoleResVOExample;
import com.fgc.pojo.RoleResVOExample.Criteria;
import com.fgc.pojo.RoleVO;
import com.fgc.service.roleres.IRoleResService;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月17日
 *
 *     未来离线需求
 */
@Service
public class RoleResServiceImpl implements IRoleResService {

	@Autowired
	private RoleResVOMapper roleResVOMapper;

	@Override
	public WebAppResult insertRoleResVO(RoleVO roleVO) throws Exception {
		RoleResVOExample example = new RoleResVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleVO.getId());

		roleResVOMapper.deleteByExample(example);

		String roleid = roleVO.getId();
		String resIds = roleVO.getResIds();
		if (MMStringUtil.isNotEmpty(resIds)) {
			String[] resArrayIds = resIds.split(",");
			for (String resid : resArrayIds) {
				RoleResVO roleRes = new RoleResVO();
				roleRes.setRoleId(roleid);
				roleRes.setResId(resid);
				roleResVOMapper.insert(roleRes);
			}
		}
		return WebAppResult.ok();
	}

	@Override
	public Map<String, String> qryRoleRes(String id) throws Exception {
		RoleResVOExample example = new RoleResVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(id);

		List<RoleResVO> roleResList = roleResVOMapper.selectByExample(example);

		Map<String, String> mapRes = new HashMap<>();

		StringBuilder sBuilder = new StringBuilder();
		if (MMCollectionUtil.isNotEmpty(roleResList)) {
			for (RoleResVO roleResVO : roleResList) {
				sBuilder.append(roleResVO.getResId());
				sBuilder.append(",");
			}
			mapRes.put(id, sBuilder.substring(0, sBuilder.length() - 1));
		}
		return mapRes;
	}

}
