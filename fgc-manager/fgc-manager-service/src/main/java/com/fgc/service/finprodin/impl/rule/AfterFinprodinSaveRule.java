package com.fgc.service.finprodin.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 产成品入库单业务保存后规则类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月1日
 *
 *     未来离线需求
 */
@Component
public class AfterFinprodinSaveRule implements IRule<FinprodinHVO, FinprodinBVO> {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	@Override
	public void process(FinprodinHVO hvo, FinprodinBVO[] bvos) {
		// 产成品入库保存，需要回写销售订单表体的已入库数量
		String vsrcid = hvo.getVsrcid();
		if (MMStringUtil.isNotEmpty(vsrcid)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
			orderHVO.setAlreadyin(1L);
			BigDecimal ntotalinnum = orderHVO.getNtotalinnum();
			orderHVO.setNtotalinnum(MMNumberUtil.add(ntotalinnum,hvo.getNtotalnum()));
			PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
			orderHVOMapper.updateByPrimaryKey(orderHVO);

			for (FinprodinBVO finprodinBVO : bvos) {
				String vsrcbid = finprodinBVO.getVsrcbid();
				if (MMStringUtil.isNotEmpty(vsrcbid)) {
					OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
					BigDecimal ninassistnum = finprodinBVO.getNinassistnum();
					BigDecimal ninnum = finprodinBVO.getNinnum();
					BigDecimal ninastnum = orderBVO.getNinastnum();
					BigDecimal orderNinnum = orderBVO.getNinnum();
					orderBVO.setNinastnum(MMNumberUtil.add(ninastnum, ninassistnum));
					orderBVO.setNinnum(MMNumberUtil.add(orderNinnum, ninnum));
					PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
					orderBVOMapper.updateByPrimaryKey(orderBVO);
				}
			}
		}
	}
}
