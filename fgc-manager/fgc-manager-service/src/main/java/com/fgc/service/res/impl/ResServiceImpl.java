package com.fgc.service.res.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.ResVOMapper;
import com.fgc.mapper.RestypeVOMapper;
import com.fgc.pojo.ResVO;
import com.fgc.pojo.ResVOExample;
import com.fgc.pojo.ResVOExample.Criteria;
import com.fgc.pojo.RestypeVO;
import com.fgc.pojo.RestypeVOExample;
import com.fgc.pojo.util.Resource;
import com.fgc.service.pub.IPubInfoService;
import com.fgc.service.res.IResService;
import com.pub.model.Local;
import com.pub.model.SessionInfo;
import com.pub.model.Tree;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;
import com.pub.utils.WebAppResult;

/**
 * 资源 列表服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月10日
 *
 *     未来离线需求
 */
@Service
public class ResServiceImpl implements IResService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private ResVOMapper resVOMapper;

	@Autowired
	private RestypeVOMapper restypeVOMapper;

	private Map<String, String> idAName = null;

	@Override
	public List<Resource> qryAllResTreeGrid() throws Exception {
		/**
		 * 1、查询所有的资源列表数据
		 */
		List<ResVO> listVOs = this.queryAllResData();
		if (MMCollectionUtil.isNotEmpty(listVOs)) {
			if (null == idAName || idAName.size() != listVOs.size()) {
				this.setIdAName(listVOs);
			}
			return this.consResource(listVOs);
		}
		return null;
	}

	/**
	 * @return List<ResVO>
	 * 
	 */
	private List<ResVO> queryAllResData() {
		ResVOExample example = new ResVOExample();
		example.setOrderByClause("seq");
		List<ResVO> listVOs = resVOMapper.selectByExample(example);
		return listVOs;
	}

	/**
	 * 设置id和name的键值对
	 * 
	 * @param gmsRes
	 */
	private void setIdAName(List<ResVO> resVOs) {
		idAName = new HashMap<String, String>();
		for (ResVO obj : resVOs) {
			ResVO res = (ResVO) obj;
			idAName.put(res.getId(), res.getName());
		}
	}

	private List<Resource> consResource(List<ResVO> resVOs) throws Exception {
		List<Resource> resList = new ArrayList<>();

		Map<String, String> resType = getResType();
		for (ResVO resVO : resVOs) {
			Resource resource = new Resource();
			BeanUtils.copyProperties(resVO, resource);
			if (MMStringUtil.isNotEmpty(resVO.getPid())) {
				resource.setPname(idAName.get(resource.getPid()));
			}
			resource.setIconCls(resVO.getIcon());
			resource.setRestypeName(resType.get(resource.getRestypeId()));
			resList.add(resource);
		}
		return resList;

	}

	/**
	 * 获取资源类型
	 * 
	 * @return Map<String, String>
	 */
	private Map<String, String> getResType() {
		RestypeVOExample example = new RestypeVOExample();
		List<RestypeVO> listRestypeVOs = restypeVOMapper.selectByExample(example);

		Map<String, String> mapData = new HashMap<>();

		if (MMCollectionUtil.isNotEmpty(listRestypeVOs)) {
			for (RestypeVO restypeVO : listRestypeVOs) {
				mapData.put(restypeVO.getId(), restypeVO.getName());
			}
		}
		return mapData;
	}

	@Override
	public List<Tree> contTree(String type, SessionInfo sessionInfo) throws Exception {
		List<Tree> listTree = new ArrayList<Tree>();

		ResVOExample example = new ResVOExample();
		example.setOrderByClause("seq");// 排序
		Criteria criteria = example.createCriteria();
		if (type.equals("0")) {
			criteria.andRestypeIdEqualTo(type);// 只查询菜单资源
			if (MMValueUtils.isNotEmpty(sessionInfo)) {
				String cuserid = sessionInfo.getId();
				List<String> resIDs = null;
				if (!cuserid.equals(pubInfoService.getValueByCode("ROOT_CODE"))) {
					resIDs = resVOMapper.queryResIDByUserId(cuserid);
					if (MMCollectionUtil.isNotEmpty(resIDs)) {
						criteria.andIdIn(resIDs);
					} else {
						criteria.andIdEqualTo("#####");
					}
				}
			}
		}

		List<ResVO> listResVOs = resVOMapper.selectByExample(example);
		if (MMCollectionUtil.isNotEmpty(listResVOs)) {
			for (ResVO resVO : listResVOs) {
				Tree tree = new Tree();
				BeanUtils.copyProperties(resVO, tree);
				tree.setState("open");

				String local = sessionInfo.getLocal();
				if (MMStringUtil.isEqual(local, Local.CH)) {
					tree.setText(resVO.getName());
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					tree.setText(resVO.getEname());
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					tree.setText(resVO.getFname());
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					tree.setText(resVO.getMname());
				}
				tree.setIconCls(resVO.getIcon());

				Map<String, String> attributes = new HashMap<>();
				attributes.put("url", resVO.getUrl());
				tree.setAttributes(attributes);
				listTree.add(tree);
			}
		}
		return listTree;
	}

	@Override
	public List<RestypeVO> queryAllRestype() throws Exception {
		RestypeVOExample example = new RestypeVOExample();
		List<RestypeVO> listRestypeVOs = restypeVOMapper.selectByExample(example);
		return listRestypeVOs;
	}

	@Override
	public WebAppResult saveRes(Resource resource) throws Exception {
		if (MMValueUtils.isNotEmpty(resource)) {
			ResVO resVO = new ResVO();
			BeanUtils.copyProperties(resource, resVO);
			resVO.setIcon(resource.getIconCls());
			PojoTools.beforeInsert(ResVO.class, resVO);
			resVOMapper.insert(resVO);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult deleteResVOs(String[] ids) throws Exception {
		if (MMArrayUtil.isNotEmpty(ids)) {
			for (String id : ids) {
				resVOMapper.deleteByPrimaryKey(id);
			}
		}
		return WebAppResult.ok();
	}

	@Override
	public Resource queryResById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			ResVOExample example = new ResVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			List<ResVO> listResVOs = resVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listResVOs)) {
				List<Resource> listResource = this.consResource(listResVOs);
				return listResource.get(0);
			}
		}
		return null;
	}

	@Override
	public WebAppResult updateResVO(Resource resource) throws Exception {
		if (MMValueUtils.isNotEmpty(resource)) {
			ResVO resVO = new ResVO();
			BeanUtils.copyProperties(resource, resVO);
			resVO.setIcon(resource.getIconCls());
			resVOMapper.updateByPrimaryKey(resVO);
			return WebAppResult.ok();
		}
		return null;
	}
}
