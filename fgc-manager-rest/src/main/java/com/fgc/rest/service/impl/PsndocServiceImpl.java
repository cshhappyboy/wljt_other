package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.PsndocVOMapper;
import com.fgc.mapper.PsnjobVOMapper;
import com.fgc.pojo.PsndocVO;
import com.fgc.pojo.PsndocVOExample;
import com.fgc.pojo.PsndocVOExample.Criteria;
import com.fgc.pojo.PsnjobVO;
import com.fgc.pojo.PsnjobVOExample;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.pojo.databsase.Billtype;
import com.fgc.rest.service.ICdeptService;
import com.fgc.rest.service.IPsndocService;
import com.fgc.rest.service.IPubInfoService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Service
public class PsndocServiceImpl implements IPsndocService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private PsndocVOMapper psndocVOMapper;

	@Autowired
	private PsnjobVOMapper psnjobVOMapper;

	@Override
	public EUDataGridResult queryData(String filterData) throws Exception {
		PsndocVOExample example = new PsndocVOExample();
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
		List<PsndocVO> listCustomers = psndocVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listCustomers)) {
			BaseDataVO bd = null;
			for (PsndocVO psndocVO : listCustomers) {
				bd = new BaseDataVO();
				bd.setId(psndocVO.getPkpsndoc());
				bd.setCode(psndocVO.getCode());
				bd.setName(psndocVO.getName());
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
			PsndocVO psndocVO = psndocVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(psndocVO)) {
				String name = psndocVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

	@Autowired
	private ICdeptService cdeptService;

	@Override
	public WebAppResult queryCdeptByPkpsndoc(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			PsnjobVOExample example = new PsnjobVOExample();
			com.fgc.pojo.PsnjobVOExample.Criteria criteria = example.createCriteria();
			criteria.andPkpsndocEqualTo(id);
			List<PsnjobVO> listPsnjobVOs = psnjobVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listPsnjobVOs)) {
				PsnjobVO psnjobVO = listPsnjobVOs.get(0);
				String pkdept = psnjobVO.getPkdept();
				WebAppResult result = cdeptService.queryNameById(pkdept);
				String deptName = (String) result.getData();

				Billtype billtype = new Billtype();
				billtype.setBilltype_id(pkdept);
				billtype.setBilltype_name(deptName);
				return WebAppResult.ok(billtype);
			}
		}
		return WebAppResult.ok();
	}

}
