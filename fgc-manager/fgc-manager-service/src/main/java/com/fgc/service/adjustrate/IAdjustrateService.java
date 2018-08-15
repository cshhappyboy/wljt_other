package com.fgc.service.adjustrate;

import java.math.BigDecimal;

/**
 * 根据币种获取汇率
 *  
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月28日
 *
 *   未来离线需求
 */
public interface IAdjustrateService {
	
	public BigDecimal selectByCurreny(String currency, String nowDate);
	
	public String selectChangeTypeByCurrency(String currency);
	
}
