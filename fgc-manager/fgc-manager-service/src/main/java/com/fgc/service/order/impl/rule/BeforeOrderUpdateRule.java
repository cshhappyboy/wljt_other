package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.order.impl.util.ZhekouRule;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMValueUtils;

/**
 * 销售订单修改保存前业务规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderUpdateRule implements IRule<OrderHVO, OrderBVO> {
	
	@Autowired
	private ZhekouRule zhekouRule;
	
	@Autowired
	private IPubInfoService pubInfoService;

	@Override
	public void process(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			BigDecimal sumNum = BigDecimal.ZERO;
			BigDecimal sumNmny = BigDecimal.ZERO;
			BigDecimal sumZkNmny = BigDecimal.ZERO;//折扣钱
			
			String integerMeasdoc = pubInfoService.getValueByCode("INTEGER_MEASDOC");
			String[] imArr = integerMeasdoc.split(",");
			List<String> listImArr = MMArrayUtil.toList(String.class, imArr);
			
			for (OrderBVO bvo : bvos) {
				String csaleunitid = bvo.getCsaleunitid();
				BigDecimal salenum = bvo.getSalenum();
				String materialCode = bvo.getMaterialcode();
				if (listImArr.contains(csaleunitid) && new BigDecimal(salenum.intValue()).compareTo(salenum) != 0) {
					throw new RuntimeException("物料编码：[ " + materialCode + " ]不能有小数,[ "+salenum+" ]");
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
		}
	}
}
