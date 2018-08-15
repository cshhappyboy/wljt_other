package com.fgc.service.order;

import java.io.InputStream;
import java.util.List;

import com.fgc.pojo.OrderHVO;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.WebAppResult;

/**
 * 销售订单接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月22日
 *
 *     未来离线需求
 */
public interface IOrderService {
	/**
	 * 查询方法
	 * 
	 * @param page
	 * @param rows
	 * @param sessionInfo
	 * @return EUDataGridResult
	 * @throws Exception
	 */
	public EUDataGridResult queryAllOrder(int page, int rows, OrderHVO hvo, SessionInfo sessionInfo) throws Exception;

	/**
	 * 
	 * 
	 * @param sessionInfo
	 * @param orderH
	 * @return
	 * @throws Exception
	 */
	public WebAppResult saveOrder(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 给导入时用
	 * 
	 * @param sessionInfo
	 * @param orderH
	 * @return
	 * @throws Exception
	 */
	public void saveOrder(List<JsonBill> jsonBills, SessionInfo sessionInfo) throws Exception;

	/**
	 * 修改销售订单
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult updateOrder(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据前台选中的ids(以","隔开),删除对应的数据
	 * 
	 * @param jsonTS
	 * @return
	 * @throws Exception
	 */
	public WebAppResult deleteOrder(JsonTS jsonTS) throws Exception;

	/**
	 * 根据id查询销售订单表体数据
	 * 
	 * @param id
	 * @return JsonBill
	 * @throws Exception
	 */
	public OrderHVO queryOrderHVOById(String id) throws Exception;

	/**
	 * 根据id，查询所有表体数据
	 * 
	 * @param id
	 * @return EUDataGridResult
	 * @throws Exception
	 */
	public EUDataGridResult queryOrderBVOsById(String id) throws Exception;

	/**
	 * 销售订单审批
	 * 
	 * @param jsonTS
	 * @param b
	 *            是否专人审批
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult approveOrderVOs(JsonTS jsonTS, SessionInfo sessionInfo, boolean b) throws Exception;

	/**
	 * 销售订单推单生成预收款单
	 * 
	 * @param id
	 * @param sessionInfo
	 * @return JsonBill
	 * @throws Exception
	 */
	public JsonBill pushReceiptVO(String id, SessionInfo sessionInfo) throws Exception;

	/**
	 * 销售订单转单，返回发票jsonBill
	 * 
	 * @param id
	 * @param sessionInfo
	 * @return JsonBill
	 * @throws Exception
	 */
	public JsonBill orderChange2InvoiceById(String id, String bids, SessionInfo sessionInfo) throws Exception;

	/**
	 * 销售订单转单，返回产成品入库jsonBill
	 * 
	 * @param id
	 * @param bids
	 * @param sessionInfo
	 * @return JsonBill
	 */
	public JsonBill orderChange2FinprodinById(String id, String bids, SessionInfo sessionInfo) throws Exception;

	/**
	 * 销售退货
	 * 
	 * @param id
	 * @param sessionInfo
	 * @return JsonBill
	 * @throws Exception
	 */
	public JsonBill orderReturnById(String id, SessionInfo sessionInfo) throws Exception;

	/**
	 * 销售订单批量推式生成产成品入库单
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult orderBatchPush2Finprodin(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * 弃审
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult unApproveOrderVOs(JsonTS jsonTS) throws Exception;

	/**
	 * 查询表体数据
	 * 
	 * @param hvo
	 * @return EUDataGridResult
	 */
	public EUDataGridResult queryOrderBVOsById4Ref(OrderHVO hvo) throws Exception;

	/**
	 * 销售订单导入
	 * 
	 * @param inputStream
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult importExcel(InputStream inputStream, SessionInfo sessionInfo) throws Exception;

	/**
	 * 订单修订保存
	 * 
	 * @param jsonBill
	 * @param sessionInfo
	 * @return
	 * @throws Exception
	 */
	public WebAppResult reviseOrder(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 批量通知生产
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult infoOrder(JsonTS jsonTS) throws Exception;

	/**
	 * 单条数据通知生产
	 * 
	 * @param jsonBill
	 * @param sessionInfo
	 * @return WebAppResult
	 */
	public WebAppResult singleInfo(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 取消同步功能
	 * 
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception;

	/**
	 * @param inputStream
	 * @return
	 */
	public WebAppResult importOldDataExcel(InputStream inputStream) throws Exception;

	/**
	 * @param jsonBill
	 */
	public void saveOldOrder(JsonBill jsonBill) throws Exception;

	/**
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult batchBlackout(JsonTS jsonTS) throws Exception;

	/**
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult refreshEffectbillcode(JsonTS jsonTS) throws Exception;
}
