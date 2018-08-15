package com.fgc.service.bd.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.ICmaterialService;
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
public class CmaterialServiceImpl implements ICmaterialService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_ALL_CMATERIAL_CLASS}")
	private String REST_QUERY_ALL_CMATERIAL_CLASS;

	@Value("${REST_QUERY_ALL_CMATERIAL_DATA}")
	private String REST_QUERY_ALL_CMATERIAL_DATA;

	@Value("${REST_QUERY_CMATERIAL_CODE_ID}")
	private String REST_QUERY_CMATERIAL_CODE_ID;

	@Value("${REST_QUERY_CMATERIAL_NAME_ID}")
	private String REST_QUERY_CMATERIAL_NAME_ID;

	@Value("${REST_QUERY_CMATERIAL_SPEC_ID}")
	private String REST_QUERY_CMATERIAL_SPEC_ID;

	@Value("${REST_QUERY_CMATERIAL_TYPE_ID}")
	private String REST_QUERY_CMATERIAL_TYPE_ID;

	@Value("${REST_QUERY_CMATERIAL_MEASDOC_ID}")
	private String REST_QUERY_CMATERIAL_MEASDOC_ID;

	@Override
	public String queryClassData(String filterData, String id) throws Exception {
		Map<String, String> param = new HashMap<>();
		param.put("filterData", filterData);
		param.put("id", id);
		String result = HttpClientUtil
				.doPost(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_CMATERIAL_CLASS, param);
		return result;
	}

	@Override
	public String queryCmaterialData(String filterData, String id, String local) throws Exception {
		Map<String, String> param = new HashMap<>();
		param.put("filterData", filterData);
		param.put("classId", id);
		param.put("local", local);
		String result = HttpClientUtil
				.doPost(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_CMATERIAL_DATA, param);
		return result;
	}

	@Override
	public String transCmaterialCodeById(String id) throws Exception {
		String result = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CMATERIAL_CODE_ID + id);
		return result;
	}

	@Override
	public String transCmaterialNameById(String id, String local) throws Exception {
		String result = HttpClientUtil.doGet(
				pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CMATERIAL_NAME_ID + id + "/" + local);
		return result;
	}

	@Override
	public String transCmaterialSpecById(String id) throws Exception {
		String result = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CMATERIAL_SPEC_ID + id);
		return result;
	}

	@Override
	public String transCmaterialTypeById(String id) throws Exception {
		String result = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CMATERIAL_TYPE_ID + id);
		return result;
	}

	@Override
	public String transCmaterialMeasdocById(String id) throws Exception {
		String result = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_CMATERIAL_MEASDOC_ID + id);
		return result;
	}

}
