package com.fgc.service.billcode;

import java.util.List;

/**
 * 单据号服务接口
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月24日
 *
 *     未来离线需求
 * 
 */
public interface IBillCodeService {
	/**
	 * 根据条件生成单据号
	 * 
	 * @param size
	 *            需要返回多少单据号
	 * @param billflag
	 *            单据标识
	 * @return List<String>
	 * @throws Exception
	 */
	public List<String> generateBillCode(String billtype, String billflag, int size) throws Exception;

	/**
	 * 根据条件生成单据号
	 * 
	 * @param billflag
	 *            单据标识
	 * @return List<String>
	 * @throws Exception
	 */
	public String generateBillCode(String billtype, String billflag) throws Exception;

	/**
	 * 生成有效订单号
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String generateEffectBillCode(String cdept) throws Exception;

}
