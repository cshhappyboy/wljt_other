package com.fgc.service.bd.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.ICdeptService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;

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

	@Value("${REST_QUERY_ALL_CDEPT}")
	private String REST_QUERY_ALL_CDEPT;

	@Value("${REST_QUERY_CDEPT_ID}")
	private String REST_QUERY_CDEPT_ID;

	@Override
	public String queryData(String filterData, String id) throws Exception {
		Map<String, String> mapParam = new HashMap<>();
		mapParam.put("filterData", filterData);
		mapParam.put("id", id);
		String strResult = HttpClientUtil.doPost(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_CDEPT,
				mapParam);
		return strResult;
	}

	@Override
	public String queryNameById(String id) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CDEPT_ID + id);
		return strResult;
	}

}
