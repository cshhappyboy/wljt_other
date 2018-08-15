package com.fgc.service.receipt.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderBVOExample;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.pub.rule.ISRule;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
@Component
public class AfterReceiptSaveRule implements ISRule<ReceiptHVO> {

	@Autowired
	private EffcetBillCodeRule effcetCodeRule;

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	@Override
	public void process(ReceiptHVO hvo) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo)) {
			String vsrcid = hvo.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
				BigDecimal oldNreceivedmny = orderHVO.getNreceivedmny();
				orderHVO.setNreceivedmny(MMNumberUtil.add(oldNreceivedmny, hvo.getTotal()));
				String orderEffectbillcode = orderHVO.getEffectbillcode();
				String effectbillcode = hvo.getEffectbillcode();
				if (MMStringUtil.isEmpty(orderEffectbillcode)) {
					orderHVO.setEffectbillcode(effectbillcode);
				}
				PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
				orderHVOMapper.updateByPrimaryKey(orderHVO);

				OrderBVOExample example = new OrderBVOExample();
				com.fgc.pojo.OrderBVOExample.Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(vsrcid);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<OrderBVO> listOrderBVOs = orderBVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(listOrderBVOs)) {
					for (OrderBVO orderBVO : listOrderBVOs) {
						String cmaterial = orderBVO.getCmaterial();
						if (effcetCodeRule.isCan(cmaterial)) {
							PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
							orderBVO.setSizecode(effectbillcode);
							orderBVOMapper.updateByPrimaryKey(orderBVO);
						}
					}
				}
			}
		}
	}
}
