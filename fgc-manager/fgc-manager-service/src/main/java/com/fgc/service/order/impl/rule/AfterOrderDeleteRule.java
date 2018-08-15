package com.fgc.service.order.impl.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.OrderHVOExample;
import com.fgc.pojo.OrderHVOExample.Criteria;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月12日
 *
 *     未来离线需求
 */
@Component
public class AfterOrderDeleteRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	public void process(List<String> ids) {
		if (MMCollectionUtil.isNotEmpty(ids)) {
			OrderHVOExample example = new OrderHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(ids);
			List<OrderHVO> listDatas = orderHVOMapper.selectByExample(example);
			for (OrderHVO hvo : listDatas) {
				String vsrcid = hvo.getVsrcid();
				if (MMStringUtil.isNotEmpty(vsrcid)) {
					OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
					PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
					orderHVO.setReturnsale(0L);
					orderHVOMapper.updateByPrimaryKey(orderHVO);
				}
			}
		}
	}

}
