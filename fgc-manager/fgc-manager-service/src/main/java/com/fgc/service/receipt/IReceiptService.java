package com.fgc.service.receipt;

import com.fgc.pojo.ReceiptHVO;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.WebAppResult;

/**
 * 预收款单服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
public interface IReceiptService {
	/**
	 * 根据条件查询数据
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param sessionInfo
	 * @return
	 * @throws Exception
	 */
	public EUDataGridResult queryAllReceiptData(int page, int rows, ReceiptHVO hvo, SessionInfo sessionInfo)
			throws Exception;

	/**
	 * 保存预收款单
	 * 
	 * @param bill
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult saveReceiptVO(JsonBill bill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据id查询表头数据
	 * 
	 * @param id
	 * @return ReceiptHVO
	 * @throws Exception
	 */
	public ReceiptHVO queryReceiptHVOById(String id) throws Exception;

	/**
	 * 根据主键ids(以","分隔),删除对应的vo,改dr = 1
	 * 
	 * @param jsonTS
	 * @return
	 * @throws Exception
	 */
	public WebAppResult deleteReceiptVO(JsonTS jsonTS) throws Exception;

	/**
	 * 修改预收款单保存
	 * 
	 * @param bill
	 * @return WebAppResult
	 */
	public WebAppResult updateReceiptVO(JsonBill bill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 预收款单审批
	 * 
	 * @param jsonTS
	 * @param flag
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult approveReceiptVOs(JsonTS jsonTS, SessionInfo sessionInfo, boolean flag) throws Exception;

	/**
	 * 弃审
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult unApproveReceiptVOs(JsonTS jsonTS) throws Exception;

	/**
	 * @param jsonTS
	 * @return
	 */
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception;

	/**
	 * @param id
	 * @param sessionInfo
	 * @return ReceiptHVO
	 */
	public ReceiptHVO hongchongReceiptVO(String id, SessionInfo sessionInfo) throws Exception;

}
