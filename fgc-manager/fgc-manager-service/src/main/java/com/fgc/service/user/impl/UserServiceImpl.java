package com.fgc.service.user.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.PsnjobVOMapper;
import com.fgc.mapper.UserDeptVOMapper;
import com.fgc.mapper.UserRoleVOMapper;
import com.fgc.mapper.UserVOMapper;
import com.fgc.mapper.UserWarehouseVOMapper;
import com.fgc.pojo.PsnjobVO;
import com.fgc.pojo.PsnjobVOExample;
import com.fgc.pojo.UserDeptVO;
import com.fgc.pojo.UserDeptVOExample;
import com.fgc.pojo.UserRoleVO;
import com.fgc.pojo.UserRoleVOExample;
import com.fgc.pojo.UserVO;
import com.fgc.pojo.UserVOExample;
import com.fgc.pojo.UserVOExample.Criteria;
import com.fgc.pojo.UserWarehouseVO;
import com.fgc.pojo.UserWarehouseVOExample;
import com.fgc.service.pub.IPubInfoService;
import com.fgc.service.user.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.WebAppResult;

/**
 * 用户接口服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月16日
 *
 *     未来离线需求
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private UserVOMapper userVOMapper;

	@Autowired
	private UserRoleVOMapper userRoleVOMapper;

	public static final String MD5PWD_PREFIX = "U_U++--V";

	@Override
	public EUDataGridResult queryAllUser(UserVO userVO) throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		UserVOExample hExample = new UserVOExample();
		hExample.setOrderByClause("usercode");
		UserVOExample.Criteria hcriteria = hExample.createCriteria();
		hcriteria.andDrEqualTo(Long.valueOf(0));

		this.whereSql(userVO, hcriteria);

		PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

		List<UserVO> listOrderH = userVOMapper.selectByExample(hExample);
		PageInfo<UserVO> info = new PageInfo<>(listOrderH);

		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;

	}

	/**
	 * @param userVO
	 * @param hcriteria
	 */
	private void whereSql(UserVO userVO, Criteria hcriteria) {
		String usercode = userVO.getUsercode();
		if (MMStringUtil.isNotEmpty(usercode)) {
			hcriteria.andUsercodeLike(usercode);
		}
		String username = userVO.getUsername();
		if (MMStringUtil.isNotEmpty(username)) {
			hcriteria.andUsernameLike(username);
		}
	}

	@Override
	public String queryUserRoleVOById(String userId) throws Exception {
		Map<String, Set<String>> mapData = this.queryUserRole(userId);
		Set<String> setStr = mapData.get(userId);
		if (MMCollectionUtil.isNotEmpty(setStr)) {
			StringBuilder sBuilder = new StringBuilder();
			for (String roleid : setStr) {
				sBuilder.append(roleid);
				sBuilder.append(",");
			}
			return sBuilder.substring(0, sBuilder.length() - 1);
		}
		return null;
	}

	/**
	 * @param userId
	 * @return Map<String, Set<String>>
	 */
	private Map<String, Set<String>> queryUserRole(String userId) {
		Map<String, Set<String>> mapUserRole = new HashMap<>();
		if (MMStringUtil.isNotEmpty(userId)) {
			UserRoleVOExample example = new UserRoleVOExample();
			com.fgc.pojo.UserRoleVOExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(userId);

			List<UserRoleVO> listData = userRoleVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listData)) {
				for (UserRoleVO userRoleVO : listData) {
					Set<String> setStrs = mapUserRole.get(userRoleVO.getUserId());
					if (MMCollectionUtil.isEmpty(setStrs)) {
						mapUserRole.put(userId, new HashSet<String>());
					}
					mapUserRole.get(userRoleVO.getUserId()).add(userRoleVO.getRoleId());
				}
			}
		}
		return mapUserRole;
	}

	@Override
	public WebAppResult insertUserRole(UserVO userVO) throws Exception {
		UserRoleVOExample example = new UserRoleVOExample();
		com.fgc.pojo.UserRoleVOExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userVO.getCuserid());

		userRoleVOMapper.deleteByExample(example);

		String id = userVO.getCuserid();
		String roleIds = userVO.getRoleIds();
		String[] roleidArray = null;
		if (MMStringUtil.isNotEmpty(roleIds)) {
			roleidArray = roleIds.split(",");
			for (String roleid : roleidArray) {
				UserRoleVO userRole = new UserRoleVO();
				userRole.setUserId(id);
				userRole.setRoleId(roleid);
				userRoleVOMapper.insert(userRole);
			}
		}
		return WebAppResult.ok();
	}

	@Override
	public WebAppResult login(UserVO userVO) throws Exception {
		String usercode = userVO.getUsercode();
		String userpassword = userVO.getUserpassword();
		/**
		 * root用户直接通过
		 */
		if (usercode.equals(pubInfoService.getValueByCode("ROOT_CODE"))
				&& userpassword.equals(pubInfoService.getValueByCode("ROOT_PWD"))) {
			UserVO rootUser = new UserVO();
			rootUser.setCuserid(pubInfoService.getValueByCode("ROOT_CODE"));
			rootUser.setUsercode(pubInfoService.getValueByCode("ROOT_CODE"));
			rootUser.setUsername(pubInfoService.getValueByCode("ROOT_CODE"));
			rootUser.setUserpassword(pubInfoService.getValueByCode("ROOT_CODE"));

			return WebAppResult.ok(rootUser);
		} else if (usercode.equals(pubInfoService.getValueByCode("ROOT_CODE"))
				&& !userpassword.equals(pubInfoService.getValueByCode("ROOT_PWD"))) {
			throw new RuntimeException("超级管理员密码错误！");
		}

		UserVOExample example = new UserVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsercodeEqualTo(usercode);

		List<UserVO> listUser = userVOMapper.selectByExample(example);
		if (MMCollectionUtil.isEmpty(listUser)) {
			throw new RuntimeException("用户不存在！");
		}
		UserVO dbUserVO = listUser.get(0);
		String dbUserpassword = dbUserVO.getUserpassword();// 数据库密码

		String encodePwd = MD5PWD_PREFIX + DigestUtils.md5Hex(dbUserVO.getCuserid() + userpassword);
		if (!MMStringUtil.isEqual(dbUserpassword, encodePwd)) {
			throw new RuntimeException("用户密码错误！");
		}
		return WebAppResult.ok(dbUserVO);
	}

	@Override
	public List<String> resourceList(String cuserid) throws Exception {
		if (MMStringUtil.isNotEmpty(cuserid)) {
			List<String> rList = null;
			if (cuserid.equals(pubInfoService.getValueByCode("ROOT_CODE"))) {
				// root用户拥有最大权限
				rList = userVOMapper.queryAllResURLByRoot();
			} else {
				rList = userVOMapper.queryResURLByUserId(cuserid);
			}
			return rList;
		}
		return null;
	}

	@Autowired
	private PsnjobVOMapper psnjobVOMapper;
	
	@Override
	public String queryCdeptByPsndoc(String pkpsndoc) throws Exception {
		if (MMStringUtil.isNotEmpty(pkpsndoc)) {
			PsnjobVOExample example = new PsnjobVOExample();
			com.fgc.pojo.PsnjobVOExample.Criteria criteria = example.createCriteria();
			criteria.andPkpsndocEqualTo(pkpsndoc);
			criteria.andVdef1EqualTo(pubInfoService.getPk_org());
			List<PsnjobVO> list = psnjobVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(list)) {
				return list.get(0).getPkdept();
			}
		}
		return null;
	}

	@Autowired
	private UserDeptVOMapper userDeptVOMapper;

	@Override
	public Map<String, String> queryUserDeptVOByUserId(String id) throws Exception {
		Map<String, String> mapStr = new HashMap<>();
		if (MMStringUtil.isNotEmpty(id)) {
			UserDeptVOExample example = new UserDeptVOExample();
			com.fgc.pojo.UserDeptVOExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(id);
			List<UserDeptVO> listUserDeptVOs = userDeptVOMapper.selectByExample(example);

			if (MMCollectionUtil.isNotEmpty(listUserDeptVOs)) {
				StringBuilder sBuilder = new StringBuilder();
				for (UserDeptVO userDeptVO : listUserDeptVOs) {
					sBuilder.append(userDeptVO.getDeptId());
					sBuilder.append(",");
				}
				mapStr.put(id, sBuilder.substring(0, sBuilder.length() - 1));
			}
		}
		return mapStr;
	}

	@Override
	public WebAppResult insertUserDeptVOs(UserDeptVO userDeptVO) throws Exception {
		UserDeptVOExample example = new UserDeptVOExample();
		com.fgc.pojo.UserDeptVOExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userDeptVO.getUserId());
		userDeptVOMapper.deleteByExample(example);

		String userId = userDeptVO.getUserId();
		String deptIds = userDeptVO.getDeptIds();

		if (MMStringUtil.isNotEmpty(deptIds)) {
			String[] arrayDeptids = deptIds.split(",");
			UserDeptVO newUserDeptVO = null;
			for (String deptId : arrayDeptids) {
				newUserDeptVO = new UserDeptVO();
				newUserDeptVO.setUserId(userId);
				newUserDeptVO.setDeptId(deptId);
				userDeptVOMapper.insert(newUserDeptVO);
			}
		}
		return WebAppResult.ok();
	}

	@Autowired
	private UserWarehouseVOMapper userWarehouseVOMapper;

	@Override
	public Map<String, String> queryUserWarehouseVOByUserId(String id) throws Exception {
		Map<String, String> mapStr = new HashMap<>();
		if (MMStringUtil.isNotEmpty(id)) {
			UserWarehouseVOExample example = new UserWarehouseVOExample();
			com.fgc.pojo.UserWarehouseVOExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdEqualTo(id);
			List<UserWarehouseVO> listUserWarehouseVOs = userWarehouseVOMapper.selectByExample(example);

			if (MMCollectionUtil.isNotEmpty(listUserWarehouseVOs)) {
				StringBuilder sBuilder = new StringBuilder();
				for (UserWarehouseVO userWarehouseVO : listUserWarehouseVOs) {
					sBuilder.append(userWarehouseVO.getWarehouseId());
					sBuilder.append(",");
				}
				mapStr.put(id, sBuilder.substring(0, sBuilder.length() - 1));
			}
		}
		return mapStr;
	}

	@Override
	public WebAppResult insertUserWarehouseVOs(UserWarehouseVO userWarehouseVO) throws Exception {
		UserWarehouseVOExample example = new UserWarehouseVOExample();
		com.fgc.pojo.UserWarehouseVOExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userWarehouseVO.getUserId());
		userWarehouseVOMapper.deleteByExample(example);

		String userId = userWarehouseVO.getUserId();
		String warehouseIds = userWarehouseVO.getWarehouseIds();

		if (MMStringUtil.isNotEmpty(warehouseIds)) {
			String[] arrayWarehouseids = warehouseIds.split(",");
			UserWarehouseVO newUserDeptVO = null;
			for (String warehouseid : arrayWarehouseids) {
				newUserDeptVO = new UserWarehouseVO();
				newUserDeptVO.setUserId(userId);
				newUserDeptVO.setWarehouseId(warehouseid);
				userWarehouseVOMapper.insert(newUserDeptVO);
			}
		}
		return WebAppResult.ok();
	}

}
