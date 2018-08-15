package com.fgc.service.bd.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.ICashaccountService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;

/**
 * 服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月6日
 *
 *     未来离线需求
 */
@Service
public class CashaccountServiceImpl implements ICashaccountService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_ALL_CASHACCOUNT}")
	private String REST_QUERY_ALL_CASHACCOUNT;

	@Value("${REST_QUERY_CASHACCOUNT_ID}")
	private String REST_QUERY_CASHACCOUNT_ID;

	@Override
	public String queryData(String filterData) throws Exception {
		Map<String, String> mapParam = new HashMap<>();
		mapParam.put("filterData", filterData);
		String strResult = HttpClientUtil
				.doPost(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_CASHACCOUNT, mapParam);
		return strResult;
	}

	@Override
	public String queryNameById(String id, String local) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CASHACCOUNT_ID + id + "/" + local);
		return strResult;
	}

}
