package com.fgc.service.whstrans;

import com.fgc.pojo.WhstransHVO;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.WebAppResult;

/**
 * 转库单接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月5日
 *
 *     未来离线需求
 */
public interface IWhstranService {

	/**
	 * 根据条件查询所有转库单
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param sessionInfo
	 * @return
	 */
	EUDataGridResult queryAllWhstransVO(int page, int rows, WhstransHVO hvo, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据表头主键查询所有表体数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	EUDataGridResult queryWhstransBVOs(String id) throws Exception;

	/**
	 * 保存转库单数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	WebAppResult saveWhstransVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据id查询转库单数据
	 * 
	 * @param id
	 * @return FinprodinHVO
	 */
	WhstransHVO queryWhstransHVOById(String id) throws Exception;

	/**
	 * 修改转库单数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	WebAppResult updateWhstransVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 批量删除转库单数据
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	WebAppResult deleteWhstransVOs(JsonTS jsonTS) throws Exception;

	/**
	 * 转库单审批
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	WebAppResult batchApprove(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * 转库单弃审
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	WebAppResult unBatchApprove(JsonTS jsonTS) throws Exception;

	/**
	 * @param ids
	 * @return WebAppResult
	 */
	WebAppResult unSyncData(JsonTS jsonTS) throws Exception;

}
