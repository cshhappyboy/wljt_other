package com.fgc.service.receipt.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fgc.pojo.ReceiptHVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;

/**
 * 审批校验本次收款金额小于销售订单金额30%，需要专人审批
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月12日
 *
 *     未来离线需求
 */
@Component
public class BeforeReceiptApproveCheckMoneyRule {

	public void process(List<ReceiptHVO> listHVOs) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			List<String> listMsg = new ArrayList<>();
			for (ReceiptHVO hvo : listHVOs) {
				String vbillcode = hvo.getVbillcode();
				BigDecimal total = hvo.getTotal();
				BigDecimal nreceivedmny = hvo.getNreceivedmny();
				BigDecimal nordermny = hvo.getNordermny();
				
				if (MMNumberUtil.isLs(MMNumberUtil.add(total,nreceivedmny), MMNumberUtil.multiply(nordermny, new BigDecimal(0.3)))) {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号：【" + vbillcode + "】");
					sBuilder.append("实际收款金额+此次收款金额小于订单金额的30%，需要专人审批");
					listMsg.add(sBuilder.toString());
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}

	}

}
