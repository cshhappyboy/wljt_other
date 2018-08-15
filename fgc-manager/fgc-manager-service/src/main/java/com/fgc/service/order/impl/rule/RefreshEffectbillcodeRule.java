package com.fgc.service.order.impl.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.pojo.OrderBVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年5月9日
 *
 *     未来离线需求
 */
@Component
public class RefreshEffectbillcodeRule {

	@Autowired
	private EffcetBillCodeRule effcetBillCodeRule;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	public void process(List<OrderBVO> listBVOs, String effectbillcode) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listBVOs) && MMStringUtil.isNotEmpty(effectbillcode)) {
			for (OrderBVO bvo : listBVOs) {
				String cmaterial = bvo.getCmaterial();
				if (effcetBillCodeRule.isCan(cmaterial)) {
					PojoTools.beforeUpdate(OrderBVO.class, bvo);
					bvo.setSizecode(effectbillcode);
					orderBVOMapper.updateByPrimaryKey(bvo);
				}
			}
		}
	}
}
