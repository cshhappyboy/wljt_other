package com.fgc.service.bd.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fgc.service.bd.IBilltypeService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.HttpClientUtil;

/**
 * 单据类型服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Service
public class BilltypeServiceImpl implements IBilltypeService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Value("${REST_QUERY_ALL_BILLTYPE}")
	private String REST_QUERY_ALL_BILLTYPE;

	@Value("${REST_QUERY_BILLTYPE_ID}")
	private String REST_QUERY_BILLTYPE_ID;

	@Override
	public String queryBilltypeData(String typeCode, String local) throws Exception {
		String strResult = HttpClientUtil.doGet(
				pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_ALL_BILLTYPE + typeCode + "/" + local);
		return strResult;
	}

	@Override
	public String queryBilltypeNameById(String id, String local) throws Exception {
		String strResult = HttpClientUtil
				.doGet(pubInfoService.getValueByCode("REST_BASE_URL") + REST_QUERY_BILLTYPE_ID + id + "/" + local);
		return strResult;
	}

}
