package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月31日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderBodyInfoRule {

	/**
	 * @param listBVOs
	 */
	public void process(List<OrderBVO> listBVOs) {
		if (MMValueUtils.isNotEmpty(listBVOs)) {
			for (OrderBVO bvo : listBVOs) {
				BigDecimal nthisinfonum = bvo.getNthisinfonum();
				if (MMNumberUtil.isNotNullAndNotZero(nthisinfonum)) {
					BigDecimal ninfonum = bvo.getNinfonum();
					BigDecimal saleNum = bvo.getSalenum();
					BigDecimal changeNum = MMNumberUtil.add(ninfonum, nthisinfonum);
					if(MMNumberUtil.isLs(saleNum, changeNum)){
						throw new RuntimeException("通知生产数量不能大于销售数量");
					}
					bvo.setNinfonum(changeNum);
				}
			}
		}
	}
}