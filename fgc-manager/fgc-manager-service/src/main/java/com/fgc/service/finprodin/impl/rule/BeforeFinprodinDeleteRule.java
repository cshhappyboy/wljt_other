package com.fgc.service.finprodin.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.FinprodinBVOMapper;
import com.fgc.mapper.FinprodinHVOMapper;
import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinBVOExample;
import com.fgc.pojo.FinprodinBVOExample.Criteria;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.utils.MMNCUtils;
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
public class BeforeFinprodinDeleteRule {

	@Autowired
	private FinprodinHVOMapper finprodinHVOMapper;

	@Autowired
	private FinprodinBVOMapper finprodinBVOMapper;

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	public void process(List<String> listIds) {
		for (String id : listIds) {
			FinprodinHVO finprodinHVO = finprodinHVOMapper.selectByPrimaryKey(id);
			String vsrcid = finprodinHVO.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
				BigDecimal ntotalinnum = orderHVO.getNtotalinnum();
				BigDecimal ntotalnum = finprodinHVO.getNtotalnum();
				orderHVO.setNtotalinnum(MMNumberUtil.subtract(ntotalinnum, ntotalnum));
				if(MMNumberUtil.isEqualZero(orderHVO.getNtotalinnum())){
					orderHVO.setAlreadyin(0L);
				}
				PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
				orderHVOMapper.updateByPrimaryKey(orderHVO);

				FinprodinBVOExample example = new FinprodinBVOExample();
				Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(id);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<FinprodinBVO> listBVOs = finprodinBVOMapper.selectByExample(example);
				for (FinprodinBVO bvo : listBVOs) {
					String vsrcbid = bvo.getVsrcbid();
					if (MMStringUtil.isNotEmpty(vsrcbid)) {
						OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
						BigDecimal ninassistnum = bvo.getNinassistnum();
						BigDecimal ninnum = bvo.getNinnum();
						BigDecimal ninastnum = orderBVO.getNinastnum();
						BigDecimal orderNinnum = orderBVO.getNinnum();
						orderBVO.setNinastnum(MMNumberUtil.subtract(ninastnum, ninassistnum));
						orderBVO.setNinnum(MMNumberUtil.subtract(orderNinnum, ninnum));
						
						PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
						orderBVOMapper.updateByPrimaryKey(orderBVO);
					}
				}
			}
		}
	}
}
