package com.fgc.service.finprodin;

import java.util.List;

import com.fgc.pojo.FinprodinHVO;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.WebAppResult;

/**
 * 产成品入库单接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月1日
 *
 *     未来离线需求
 */
public interface IFinprodinService {

	/**
	 * 根据查询条件查询产成品入库单数据
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param sessionInfo
	 * @return
	 */
	public EUDataGridResult queryAllFinprodinVO(int page, int rows, FinprodinHVO hvo, SessionInfo sessionInfo)
			throws Exception;

	/**
	 * 根据表头id查询所有表体的数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryFinprodinBVOs(String id) throws Exception;

	/**
	 * 保存产成品入库单
	 * 
	 * @param jsonBill
	 * @param sessionInfo
	 * @return WebAppResult
	 */
	public WebAppResult saveFinprodinVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 跟id,查询表头数据
	 * 
	 * @param id
	 * @return
	 */
	public FinprodinHVO queryFinprodinHVOById(String id) throws Exception;

	/**
	 * 修改产成品入库单数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	public WebAppResult updateFinprodinVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据ids删除出库单数据
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult deleteFinprodinVOs(JsonTS jsonTS) throws Exception;

	/**
	 * 批量保存
	 * 
	 * @param listJsonBills
	 * @param sessionInfo
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult batchSaveFinprodinVOs(List<JsonBill> listJsonBills, SessionInfo sessionInfo) throws Exception;

	/**
	 * 批量签字
	 * 
	 * @param jsonTS
	 * @param sessionInfo
	 * @return WebAppResult
	 */
	public WebAppResult signBatch(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * 批量取消签字
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult unSignBatch(JsonTS jsonTS) throws Exception;

	/**
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception;
}
