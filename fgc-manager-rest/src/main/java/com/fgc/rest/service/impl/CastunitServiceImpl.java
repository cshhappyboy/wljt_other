package com.fgc.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.MeasdocVOMapper;
import com.fgc.pojo.MeasdocVO;
import com.fgc.rest.service.ICastunitService;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
@Service
public class CastunitServiceImpl implements ICastunitService {

	@Autowired
	private MeasdocVOMapper measdocVOMapper;

	@Override
	public WebAppResult transNameById(String id, String local) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MeasdocVO measdocVO = measdocVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(measdocVO)) {
				String name = measdocVO.getName();
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
