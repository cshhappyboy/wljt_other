package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.order.impl.util.ZhekouRule;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月28日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderReviseRule implements IRule<OrderHVO, OrderBVO> {

	@Autowired
	private ZhekouRule zhekouRule;
	
	@Override
	public void process(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			// 为表头存入折本汇率，主要方便发票回写订单是带出汇率
			BigDecimal sumNum = BigDecimal.ZERO;
			BigDecimal sumNmny = BigDecimal.ZERO;
			BigDecimal sumZkNmny = BigDecimal.ZERO;//折扣钱
			for (OrderBVO bvo : bvos) {
				if(MMNumberUtil.isLsZero(bvo.getNprice())){
					throw new RuntimeException("单价不能为负数！");
				}
				if (zhekouRule.isZheKou(bvo.getCmaterial())) {
					sumZkNmny = MMNumberUtil.add(sumZkNmny,bvo.getNmny());
				}
				if(bvo.getServices() == 0L){
					sumNum = MMNumberUtil.add(sumNum, bvo.getNastnum());
				}
				sumNmny = MMNumberUtil.add(sumNmny, bvo.getNmny());
			}
			hvo.setVdef2(sumZkNmny.toString());
			hvo.setNtotalnum(sumNum);
			hvo.setNorigtaxmny(sumNmny);
			hvo.setAlreadyrevise(1L);

			BigDecimal norigtaxmny = hvo.getNorigtaxmny();
			BigDecimal nreceivedmny = hvo.getNreceivedmny();
			if (MMNumberUtil.isLs(norigtaxmny, nreceivedmny)) {
				throw new RuntimeException("订单金额不能小于累计收款金额！");
			}
		}
	}
}
