package com.fgc.service.order.impl.excel.change;

import java.math.BigDecimal;

import com.fgc.pojo.OrderBVO;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;

/**
 * 表体数量金额计算
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月8日
 *
 *     未来离线需求
 */
public class BodyVODataCalculate {

	public static void calData(OrderBVO bvo) throws Exception {
		String vunitratio = bvo.getVunitratio();
		if (MMStringUtil.isNotEmpty(vunitratio)) {
			String[] splitVunitratio = vunitratio.split("/");
			BigDecimal divideVunitratio = MMNumberUtil.divide(new BigDecimal(splitVunitratio[0]),
					new BigDecimal(splitVunitratio[1]));
			bvo.setNastnum(MMNumberUtil.divide(bvo.getSalenum(), divideVunitratio));

			String measrate = bvo.getMeasrate();
			if (MMStringUtil.isNotEmpty(measrate)) {
				String[] splitMeasrate = measrate.split("/");
				BigDecimal divideMeasrate = MMNumberUtil.divide(new BigDecimal(splitMeasrate[0]),
						new BigDecimal(splitMeasrate[1]));
				bvo.setNnum(MMNumberUtil.multiply(bvo.getNastnum(), divideMeasrate));
			}
		}
		BigDecimal nmny = bvo.getNmny();
		if(MMNumberUtil.isNotNullAndNotZero(nmny)){
			bvo.setNprice(MMNumberUtil.divide(nmny, bvo.getNastnum()));
		}
		if(MMNumberUtil.isNotNullAndNotZero(nmny)){
			bvo.setNsaleprice(MMNumberUtil.divide(nmny, bvo.getSalenum()));
		}
	}
}
