package com.fgc.rest.service.impl.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.MaterialStockVOMapper;
import com.fgc.pojo.MaterialStockVO;
import com.fgc.pojo.MaterialStockVOExample;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 有效订单号是否要设置在表体行上
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月3日
 *
 *     未来离线需求
 */
@Component
public class EffcetBillCodeRule {

	@Autowired
	private MaterialStockVOMapper materialStockVOMapper;

	/**
	 * 是否可以设置有效订单号在表体行上
	 * 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isCan(String cmaterial) throws Exception {
		MaterialStockVOExample materialStockVOExample = new MaterialStockVOExample();
		com.fgc.pojo.MaterialStockVOExample.Criteria createCriteria = materialStockVOExample.createCriteria();
		createCriteria.andPkmaterialEqualTo(cmaterial);
		List<MaterialStockVO> listMaterialStockVOs = materialStockVOMapper.selectByExample(materialStockVOExample);
		if (MMCollectionUtil.isNotEmpty(listMaterialStockVOs)) {
			MaterialStockVO materialStockVO = listMaterialStockVOs.get(0);
			String wholemanaflag = materialStockVO.getWholemanaflag();
			if (MMStringUtil.isEqual("Y", wholemanaflag)) {
				return true;
			}
		}
		return false;
	}

}
