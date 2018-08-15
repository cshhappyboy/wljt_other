package com.fgc.service.saleout;

import java.util.List;

import com.fgc.pojo.SaleOutHVO;
import com.pub.model.SessionInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.WebAppResult;

/**
 * 销售出库服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月31日
 *
 *     未来离线需求
 */
public interface ISaleOutService {

	/**
	 * 查询方法
	 * 
	 * @param page
	 * @param rows
	 * @param sessionInfo
	 * @return EUDataGridResult
	 * @throws Exception
	 */
	public EUDataGridResult queryAllSaleOutVO(int page, int rows, SaleOutHVO hvo, SessionInfo sessionInfo)
			throws Exception;

	/**
	 * 根据id 查询销售出库表体数据
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public EUDataGridResult querySaleOutBVOs(String id) throws Exception;

	/**
	 * 保存销售出库
	 * 
	 * @param jsonBill
	 * @return
	 * @throws Exception
	 */
	public WebAppResult saveSaleOutVO4Invoice(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 批量保存销售出库
	 * 
	 * @param jsonBill
	 * @return
	 * @throws Exception
	 */
	public WebAppResult saveSaleOutVOBatch(List<JsonBill> listJsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据主键查询销售出库表头数据
	 * 
	 * @param id
	 * @return SaleOutHVO
	 */
	public SaleOutHVO querySaleOutHVOById(String id) throws Exception;

	/**
	 * 修改销售出库单
	 * 
	 * @param jsonBill
	 * @return WebAppResult
	 */
	public WebAppResult updateSaleOutVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception;

	/**
	 * 根据主键删除销售出库单
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	public WebAppResult deleteSaleOut(JsonTS jsonTS) throws Exception;

	/**
	 * 销售出库签字
	 * 
	 * @param ids
	 * @param sessionInfo
	 * @return WebAppResult
	 * @throws Exception
	 */
	public WebAppResult signSaleOutVOs(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * 销售出库取消签字
	 * 
	 * @param ids
	 * @return WebAppResult
	 */
	public WebAppResult unSignSaleOutVOs(JsonTS jsonTS) throws Exception;

	/**
	 * 销售出库批量出库
	 * 
	 * @param ids
	 * @param sessionInfo
	 * @return WebAppResult
	 */
	public WebAppResult batchSaleout(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception;

	/**
	 * @param ids
	 * @return WebAppResult
	 */
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception;

	/**
	 * @param jsonTS
	 * @return WebAppResult
	 */
	public WebAppResult refreshEffectbillcode(JsonTS jsonTS) throws Exception;

}
