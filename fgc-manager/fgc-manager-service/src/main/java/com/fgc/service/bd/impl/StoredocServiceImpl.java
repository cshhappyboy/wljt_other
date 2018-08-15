package com.fgc.service.bd.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.IStoredocService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月4日
 *
 *     未来离线需求
 */
@Service
public class StoredocServiceImpl implements IStoredocService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_ALL_STOREDOC_DATA}")
	private String REST_QUERY_ALL_STOREDOC_DATA;

	@Value("${REST_QUERY_STOREDOC_ID}")
	private String REST_QUERY_STOREDOC_ID;

	@Override
	public String queryData(String filterData, String userId) throws Exception {
		Map<String, String> mapParam = new HashMap<>();
		mapParam.put("filterData", filterData);
		if (MMStringUtil.isNotEmpty(userId)) {
			mapParam.put("userId", userId);
		}
		String strResult = HttpClientUtil
				.doPost(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_STOREDOC_DATA, mapParam);
		return strResult;
	}

	@Override
	public String transNameById(String id) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_STOREDOC_ID + id);
		return strResult;
	}

}
