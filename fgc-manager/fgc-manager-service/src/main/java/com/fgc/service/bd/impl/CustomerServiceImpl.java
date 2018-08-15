package com.fgc.service.bd.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.ICustomerService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;

/**
 * 客户档案服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_ALL_CUSTOMER}")
	private String REST_QUERY_ALL_CUSTOMER;

	@Value("${REST_QUERY_CUSTOMER_ID}")
	private String REST_QUERY_CUSTOMER_ID;

	@Override
	public String queryData(String filterData) throws Exception {
		Map<String, String> mapParam = new HashMap<>();
		mapParam.put("filterData", filterData);
		String strResult = HttpClientUtil
				.doPost(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_CUSTOMER, mapParam);
		return strResult;
	}

	@Override
	public String queryNameById(String id) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CUSTOMER_ID + id);
		return strResult;
	}

}
