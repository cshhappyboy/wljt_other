package com.fgc.service.manaul;

import com.fgc.pojo.ManualVO;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.WebAppResult;

/**
 * 手动同步接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月13日
 *
 *     未来离线需求
 */
public interface IManualService {

	public ManualVO queryDataById(String id) throws Exception;

	public EUDataGridResult queryData() throws Exception;

	public WebAppResult saveData(ManualVO manualVO) throws Exception;

	public WebAppResult updateData(ManualVO manualVO) throws Exception;

	public WebAppResult deleteData(String id) throws Exception;

	public WebAppResult syncManual(ManualVO manualVO) throws Exception;

}
