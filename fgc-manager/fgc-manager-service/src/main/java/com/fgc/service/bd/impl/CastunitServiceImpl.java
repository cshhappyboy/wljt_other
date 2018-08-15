package com.fgc.service.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.ICastunitService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;

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
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_CASTUNIT_ID}")
	private String REST_QUERY_CASTUNIT_ID;

	@Override
	public String transNameById(String id, String local) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CASTUNIT_ID + id + "/" + local);
		return strResult;
	}

}
