package com.fgc.service.order.impl.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.utils.AggVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 销售订单审批校验
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月6日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderApproveCheckRule {

	public void process(List<AggVO<OrderHVO, OrderBVO>> listAggVOs) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listAggVOs)) {
			List<String> listMsg = new ArrayList<>();
			for (AggVO<OrderHVO, OrderBVO> aggVO : listAggVOs) {
				OrderHVO headVO = aggVO.getHeadVO();
				String vbillcode = headVO.getVbillcode();
				String cbalatype = headVO.getCbalatype();
				if(MMStringUtil.isEmpty(cbalatype)){
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号:【" + vbillcode + "】,");
					sBuilder.append("结算方式不能为空");
					listMsg.add(sBuilder.toString());
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}
}
