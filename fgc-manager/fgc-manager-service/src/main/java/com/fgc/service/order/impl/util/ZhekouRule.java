package com.fgc.service.order.impl.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.MaterialVOMapper;
import com.fgc.pojo.MaterialVO;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月13日
 *
 *     未来离线需求
 */
@Component
public class ZhekouRule {

	@Autowired
	private MaterialVOMapper materialVOMapper;

	public boolean isZheKou(String cmaterial) {
		MaterialVO materialVO = materialVOMapper.selectByPrimaryKey(cmaterial);
		String vdef3 = materialVO.getVdef3();
		if (MMStringUtil.isEqual(vdef3, "Y")) {
			return true;
		}
		return false;
	}

}
