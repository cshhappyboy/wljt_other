package com.fgc.service.order.impl.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.OrderHVOExample;
import com.fgc.pojo.OrderHVOExample.Criteria;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月9日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaveOrderBillCodeCheckRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	public void process(OrderHVO hvo) {
		String vbillcode = hvo.getVbillcode();
		OrderHVOExample example = new OrderHVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andVbillcodeEqualTo(vbillcode);
		criteria.andDrEqualTo(MMNCUtils.getDR(0));
		List<OrderHVO> list = orderHVOMapper.selectByExample(example);
		if (MMCollectionUtil.isNotEmpty(list)) {
			throw new RuntimeException("保存错误！单据号存在重复！单据号为:" + vbillcode);
		}
	}
}
