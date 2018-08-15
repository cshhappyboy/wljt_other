package com.fgc.service.pub;

import com.fgc.pojo.PubParamVO;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月16日
 *
 *     未来离线需求
 */
public interface IParamService {

	public PubParamVO queryParamById(String id) throws Exception;

	public EUDataGridResult queryParam() throws Exception;

	public WebAppResult saveParam(PubParamVO paramVO) throws Exception;

	public WebAppResult updateParam(PubParamVO paramVO) throws Exception;

	public WebAppResult deleteParam(String id) throws Exception;

}
