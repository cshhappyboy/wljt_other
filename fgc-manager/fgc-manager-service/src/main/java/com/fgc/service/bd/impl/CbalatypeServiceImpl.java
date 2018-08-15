package com.fgc.service.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.ICbalatypeService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;

/**
 * 服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Service
public class CbalatypeServiceImpl implements ICbalatypeService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_ALL_CBALATYPE}")
	private String REST_QUERY_ALL_CBALATYPE;

	@Value("${REST_QUERY_CBALATYPE_ID}")
	private String REST_QUERY_CBALATYPE_ID;

	@Override
	public String queryData(String local) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_CBALATYPE + "/" + local);
		return strResult;
	}

	@Override
	public String queryNameById(String id, String local) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CBALATYPE_ID + id + "/" + local);
		return strResult;
	}

}
