package com.fgc.service.role.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.RoleVOMapper;
import com.fgc.pojo.RoleVO;
import com.fgc.pojo.RoleVOExample;
import com.fgc.pojo.RoleVOExample.Criteria;
import com.fgc.pojo.util.Role;
import com.fgc.service.role.IRoleService;
import com.pub.model.Tree;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;
import com.pub.utils.WebAppResult;

/**
 * 服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月17日
 *
 *     未来离线需求
 */
@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleVOMapper roleVOMapper;

	@Override
	public List<Role> queryAllRoles() throws Exception {
		List<RoleVO> roles = this.getAllRoles(null);
		if (MMCollectionUtil.isNotEmpty(roles)) {
			return transRoles(roles);
		}
		return new ArrayList<Role>();
	}

	private List<Role> transRoles(List<RoleVO> roles) {
		List<Role> list = new ArrayList<>();
		Map<String, String> qryIdAName = qryIdAName(roles);
		for (RoleVO roleVO : roles) {
			Role role = new Role();
			BeanUtils.copyProperties(roleVO, role);
			if (MMStringUtil.isNotEmpty(roleVO.getPid())) {
				role.setPname(qryIdAName.get(roleVO.getPid()));
			}
			role.setIconCls("status_online");
			list.add(role);
		}
		return list;
	}

	/**
	 * 
	 * @return id和名称的键值对
	 */
	private Map<String, String> qryIdAName(List<RoleVO> roles) {
		Map<String, String> idAName = new HashMap<String, String>();
		if (MMCollectionUtil.isNotEmpty(roles)) {
			for (RoleVO role : roles) {
				idAName.put(role.getId(), role.getName());
			}
		}
		return idAName;
	}

	public List<RoleVO> getAllRoles(String[] ids) {
		RoleVOExample roleVOExample = new RoleVOExample();
		roleVOExample.setOrderByClause("seq");

		Criteria criteria = roleVOExample.createCriteria();
		if (MMArrayUtil.isNotEmpty(ids)) {
			criteria.andIdIn(MMArrayUtil.toList(String.class, ids));
		}
		List<RoleVO> listDatas = roleVOMapper.selectByExample(roleVOExample);
		return listDatas;
	}

	@Override
	public List<Tree> contTree() throws Exception {
		List<RoleVO> roles = getAllRoles(null);
		List<Tree> trees = new ArrayList<Tree>();
		if (MMCollectionUtil.isNotEmpty(roles)) {
			for (RoleVO role : roles) {
				Tree tree = new Tree();
				BeanUtils.copyProperties(role, tree);
				tree.setIconCls("status_online");
				tree.setText(role.getName());
				trees.add(tree);
			}
		}
		return trees;
	}

	@Override
	public WebAppResult insertRoleVO(Role role) throws Exception {
		if (MMValueUtils.isNotEmpty(role)) {
			RoleVO roleVO = new RoleVO();
			BeanUtils.copyProperties(role, roleVO);
			PojoTools.beforeInsert(RoleVO.class, roleVO);
			roleVOMapper.insert(roleVO);
		}
		return WebAppResult.ok();
	}

	@Override
	public List<Role> queryRoleById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			List<RoleVO> listRoleVOs = this.getAllRoles(MMArrayUtil.toArray(id));
			if (MMCollectionUtil.isNotEmpty(listRoleVOs)) {
				return this.transRoles(listRoleVOs);
			}
		}
		return null;
	}

	@Override
	public WebAppResult updateRoleVO(Role role) throws Exception {
		if (MMValueUtils.isNotEmpty(role)) {
			RoleVO roleVO = new RoleVO();
			BeanUtils.copyProperties(role, roleVO);
			roleVOMapper.updateByPrimaryKey(roleVO);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult deleteRoleVO(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			roleVOMapper.deleteByPrimaryKey(id);
			return WebAppResult.ok();
		}
		return null;
	}

}
