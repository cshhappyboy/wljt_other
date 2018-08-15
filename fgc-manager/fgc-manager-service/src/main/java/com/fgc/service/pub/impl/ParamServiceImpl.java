package com.fgc.service.pub.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.PubParamVOMapper;
import com.fgc.pojo.PubParamVO;
import com.fgc.pojo.PubParamVOExample;
import com.fgc.service.pub.IParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.IDUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月16日
 *
 *     未来离线需求
 */
@Service
public class ParamServiceImpl implements IParamService {

	@Autowired
	private PubParamVOMapper pubParamVOMapper;

	@Override
	public PubParamVO queryParamById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			PubParamVO pubParamVO = pubParamVOMapper.selectByPrimaryKey(id);
			return pubParamVO;
		}
		return null;
	}

	@Override
	public EUDataGridResult queryParam() throws Exception {
		PubParamVOExample example = new PubParamVOExample();
		example.setOrderByClause("name asc");
		PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

		List<PubParamVO> listVOs = pubParamVOMapper.selectByExample(example);

		PageInfo<PubParamVO> info = new PageInfo<>(listVOs);

		EUDataGridResult result = new EUDataGridResult();
		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;
	}

	@Override
	public WebAppResult saveParam(PubParamVO paramVO) throws Exception {
		if (MMValueUtils.isNotEmpty(paramVO)) {
			paramVO.setId(IDUtils.genId());
			pubParamVOMapper.insert(paramVO);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult updateParam(PubParamVO paramVO) throws Exception {
		if (MMValueUtils.isNotEmpty(paramVO)) {
			pubParamVOMapper.updateByPrimaryKey(paramVO);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult deleteParam(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			pubParamVOMapper.deleteByPrimaryKey(id);
			return WebAppResult.ok();
		}
		return null;
	}

}
