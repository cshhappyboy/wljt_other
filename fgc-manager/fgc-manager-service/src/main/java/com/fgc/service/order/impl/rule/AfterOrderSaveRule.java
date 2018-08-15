package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderBVOExample;
import com.fgc.pojo.OrderBVOExample.Criteria;
import com.fgc.pojo.OrderHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 销售订单保存后规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月25日
 *
 *     未来离线需求
 */
@Component
public class AfterOrderSaveRule implements IRule<OrderHVO, OrderBVO> {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	@Override
	public void process(OrderHVO hvo, OrderBVO[] bvos) {
		/**
		 * 销售订单保存，需要校验是否是退货，如果是退货，需要回写原单据为退货状态
		 */
		String vsrcid = hvo.getVsrcid();
		if (MMStringUtil.isNotEmpty(vsrcid)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
			PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
			orderHVO.setReturnsale(1L);
			orderHVOMapper.updateByPrimaryKey(orderHVO);

			// 需要回写表体退货数量
			OrderBVOExample example = new OrderBVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andHidEqualTo(vsrcid);
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);
			for (OrderBVO listBVO : listBVOs) {
				String bid = listBVO.getId();
				for (OrderBVO bvo : bvos) {
					String vsrcbid = bvo.getVsrcbid();
					if (MMStringUtil.isEqual(bid, vsrcbid)) {
						PojoTools.beforeUpdate(OrderBVO.class, listBVO);
						listBVO.setNreturnnum(MMNumberUtil.subtract(BigDecimal.ZERO, bvo.getSalenum()));
						orderBVOMapper.updateByPrimaryKey(listBVO);
					}
				}
			}
		}
	}
}
