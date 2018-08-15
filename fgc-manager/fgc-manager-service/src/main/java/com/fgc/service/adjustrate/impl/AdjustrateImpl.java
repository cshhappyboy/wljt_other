package com.fgc.service.adjustrate.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.AdjustrateVOMapper;
import com.fgc.pojo.AdjustrateVO;
import com.fgc.pojo.AdjustrateVOExample;
import com.fgc.pojo.AdjustrateVOExample.Criteria;
import com.fgc.service.adjustrate.IAdjustrateService;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;

/**
 * 服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月28日
 *
 *     未来离线需求
 */
@Service
public class AdjustrateImpl implements IAdjustrateService {

	@Autowired
	private AdjustrateVOMapper adjustrateVOMapper;

	@Override
	public BigDecimal selectByCurreny(String currency,String nowDate) {
		String[] datas = nowDate.split("-");
		if (MMStringUtil.isNotEmpty(currency)) {
			AdjustrateVOExample example = new AdjustrateVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andVdef4EqualTo(datas[0]);
			criteria.andVdef5EqualTo(datas[1]);
			criteria.andVdef2EqualTo(currency);

			List<AdjustrateVO> listAdjustrateVOs = adjustrateVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listAdjustrateVOs)) {
				AdjustrateVO adjustrateVO = listAdjustrateVOs.get(0);
				String adjustrate = adjustrateVO.getAdjustrate();
				return new BigDecimal(adjustrate);
			}
		}
		return null;
	}

	@Override
	public String selectChangeTypeByCurrency(String currency) {
		String year = MMNCUtils.getYear();
		String month = MMNCUtils.getMonth();
		if (MMStringUtil.isNotEmpty(currency)) {
			AdjustrateVOExample example = new AdjustrateVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andVdef4EqualTo(year);
			criteria.andVdef5EqualTo(month);
			criteria.andVdef2EqualTo(currency);

			List<AdjustrateVO> listAdjustrateVOs = adjustrateVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listAdjustrateVOs)) {
				AdjustrateVO adjustrateVO = listAdjustrateVOs.get(0);
				String vdef6 = adjustrateVO.getVdef6();
				return vdef6;
			}
		}
		return null;
	}

}
