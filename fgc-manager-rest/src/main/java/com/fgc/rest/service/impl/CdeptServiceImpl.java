package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.DeptVOMapper;
import com.fgc.pojo.DeptVO;
import com.fgc.pojo.DeptVOExample;
import com.fgc.pojo.DeptVOExample.Criteria;
import com.fgc.rest.service.ICdeptService;
import com.fgc.rest.service.IPubInfoService;
import com.pub.model.Tree;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 部门档案实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Service
public class CdeptServiceImpl implements ICdeptService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private DeptVOMapper deptVOMapper;

	@Override
	public List<Tree> queryData(String filterData, String id) throws Exception {
		List<Tree> listTree = new ArrayList<Tree>();

		DeptVOExample example = new DeptVOExample();
		example.setOrderByClause("code");
		Criteria criteria = example.createCriteria();
		criteria.andVdef4EqualTo("2");
		if (MMStringUtil.isNotEmpty(id)) {
			criteria.andPkfatherorgEqualTo(id);
		} else {
			criteria.andPkfatherorgIsNull();
		}

		String pk_org = pubInfoService.getPk_org();
		if (MMStringUtil.isNotEmpty(pk_org)) {
			criteria.andPkorgEqualTo(pk_org);
		}
		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andCodeLike("%" + filterData + "%");

			Criteria createCriteria = example.createCriteria();

			example.or(createCriteria);
			if (MMStringUtil.isNotEmpty(pk_org)) {
				createCriteria.andPkorgEqualTo(pk_org);
			}
			if (MMStringUtil.isNotEmpty(id)) {
				createCriteria.andPkfatherorgEqualTo(id);
			}
			createCriteria.andNameLike("%" + filterData + "%");
		}

		List<DeptVO> listDeptVOs = deptVOMapper.selectByExample(example);
		if (MMCollectionUtil.isNotEmpty(listDeptVOs)) {
			for (DeptVO deptVO : listDeptVOs) {
				Tree tree = new Tree();
				tree.setId(deptVO.getPkdept());
				if (MMStringUtil.isNotEmpty(deptVO.getPkfatherorg())) {
					tree.setPid(deptVO.getPkfatherorg());
				}
				if(this.isParent(deptVO.getPkdept())){
					tree.setState("closed");
				}else {
					tree.setState("open");
				}
				tree.setText(deptVO.getCode() + "  " + deptVO.getName());
				tree.setIconCls("shape_square");

				Map<String, String> attr = new HashMap<>();
				attr.put("name", deptVO.getName());
				tree.setAttributes(attr);
				listTree.add(tree);
			}
		}
		return listTree;
	}

	/**
	 * 是否为父项
	 * 
	 * @param id
	 * @return boolean
	 */
	private boolean isParent(String id) {
		DeptVOExample example = new DeptVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andPkfatherorgEqualTo(id);
		criteria.andVdef4EqualTo("2");
		List<DeptVO> selectByExample = deptVOMapper.selectByExample(example);
		if (MMCollectionUtil.isNotEmpty(selectByExample)) {
			return true;
		}
		return false;
	}

	@Override
	public WebAppResult queryNameById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			DeptVO deptVO = deptVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(deptVO)) {
				String name = deptVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
