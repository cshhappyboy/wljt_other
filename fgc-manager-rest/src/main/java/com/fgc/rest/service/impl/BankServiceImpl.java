package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.BankAccbasVOMapper;
import com.fgc.pojo.BankAccbasVO;
import com.fgc.pojo.BankAccbasVOExample;
import com.fgc.pojo.BankAccbasVOExample.Criteria;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.IBankService;
import com.fgc.rest.service.IPubInfoService;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 接口实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BankAccbasVOMapper bankAccbasVOMapper;

	@Override
	public EUDataGridResult queryData(String filterData) throws Exception {
		BankAccbasVOExample example = new BankAccbasVOExample();
		Criteria criteria = example.createCriteria();

		String pk_org = pubInfoService.getPk_org();
		criteria.andPkorgEqualTo(pk_org);
		criteria.andVdef4EqualTo("2");

		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andAccnumLike("%" + filterData + "%");
			Criteria createCriteria = example.createCriteria();
			example.or(createCriteria);
			createCriteria.andNameLike("%" + filterData + "%");
		}
		List<BankAccbasVO> listBankAccbasVOs = bankAccbasVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listBankAccbasVOs)) {
			BaseDataVO bd = null;
			for (BankAccbasVO bankAccbasVO : listBankAccbasVOs) {
				bd = new BaseDataVO();
				bd.setId(bankAccbasVO.getPkbankaccbas());
				bd.setCode(bankAccbasVO.getAccnum());
				bd.setName(bankAccbasVO.getName());
				listBDs.add(bd);
			}
		}
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(listBDs);
		result.setTotal(listBDs.size());

		return result;
	}

	@Override
	public WebAppResult queryNameById(String id, String local) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			BankAccbasVO bankAccbasVO = bankAccbasVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(bankAccbasVO)) {
				String name = null;
				name = bankAccbasVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
