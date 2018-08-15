package com.fgc.service.invoice;

import java.util.List;

import com.fgc.pojo.InvoiceHVO;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.WebAppResult;

/**
 * 销售发票服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月30日
 *
 *     未来离线需求
 */
public interface InvoiceService {
	/**
	 * 根据条件查询发票
	 * 
	 * @param page
	 * @param rows
	 * @param hvo
	 * @param sessionInfo
	 * @return
	 * @throws Exception
	 */
	public EUDataGridResult queryAllData(int page, int rows, InvoiceHVO hvo, SessionInfo sessionInfo) throws Exception;

	/**
	 * 查询销售发票表体行
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryInvoiceBVOsById(String id) throws Exception;

	/**
	 * 保存发票信息
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	public WebAppResult saveInvoiceVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 修改保存发票数据
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	public WebAppResult updateInvoiceVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 通过表头主键查询表头数据
	 * 
	 * @param ids
	 * @return InvoiceHVO
	 * @throws Exception
	 */
	public InvoiceHVO queryInvoiceHVOById(String id) throws Exception;

	/**
	 * 根据主键id 删除销售发票表头表体数据
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult deleteInvoiceVOsByIds(JsonTS jsonTS) throws Exception;

	/**
	 * 销售发票审批
	 * 
	 * @param ids
	 * @param sessionInfo
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult approveInvoiceVOs(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * 推式生成销售发票
	 * 
	 * @param listHVOs
	 * @param listBVOs
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult pushInvoiceVOs(List<JsonBill> jsonBills, SessionInfo sessionInfo) throws Exception;

	/**
	 * 弃审
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	public WebAppResult unUpproveInvoiceVOs(JsonTS jsonTS) throws Exception;

	/**
	 * 查询表体
	 * 
	 * @param id
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryInvoiceBVOsById4Ref(String id) throws Exception;

	/**
	 * 给发票打上欠款标识
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	public WebAppResult batchDebtInvoice(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * @param ids
	 * @return WebAppResult
	 */
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception;

}
