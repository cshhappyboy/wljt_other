package com.fgc.service.finprodin.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMCollectionUtil;
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
public class AfterFinprodinUpdateRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	public void process(JsonBill newJsonBill, JsonBill oldJsonBill) {
		String head = newJsonBill.getHead();
		String oldHead = oldJsonBill.getHead();

		FinprodinHVO headVO = JsonUtils.jsonToPojo(head, FinprodinHVO.class);
		FinprodinHVO oldHeadVO = JsonUtils.jsonToPojo(oldHead, FinprodinHVO.class);

		String vsrcid = headVO.getVsrcid();
		if (MMStringUtil.isNotEmpty(vsrcid)) {
			BigDecimal changeNum = MMNumberUtil.subtract(headVO.getNtotalnum(), oldHeadVO.getNtotalnum());

			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
			BigDecimal ntotalinnum = orderHVO.getNtotalinnum();
			orderHVO.setNtotalinnum(MMNumberUtil.add(ntotalinnum, changeNum));
			PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
			orderHVOMapper.updateByPrimaryKey(orderHVO);

			// 2、表体数量回写
			// 2.1、表体是新增的咱就不管，因为没有上下游关系
			// 2.2、表体是修改的跟表体一样，把旧的减掉，再加上老的
			String updateBodys = newJsonBill.getUpdateBodys();
			String oldBodys = oldJsonBill.getRealyBodys();
			List<FinprodinBVO> updateBVOs = JsonUtils.jsonToList(updateBodys, FinprodinBVO.class);
			List<FinprodinBVO> oldBVOs = JsonUtils.jsonToList(oldBodys, FinprodinBVO.class);
			if (MMCollectionUtil.isNotEmpty(updateBVOs)) {
				for (FinprodinBVO bvo : updateBVOs) {
					String id = bvo.getId();
					for (FinprodinBVO oldBVO : oldBVOs) {
						String oldID = oldBVO.getId();
						if (MMStringUtil.isEqual(id, oldID)) {
							String vsrcbid = bvo.getVsrcbid();
							if (MMStringUtil.isNotEmpty(vsrcbid)) {
								OrderBVO orderBVO = orderBVOMapper.selectByPrimaryKey(vsrcbid);
								BigDecimal ninassistnum = bvo.getNinassistnum();
								BigDecimal oldNinassistnum = oldBVO.getNinassistnum();
								BigDecimal bUpdateChangeNastnum = MMNumberUtil.subtract(ninassistnum, oldNinassistnum);

								BigDecimal ninastnum = orderBVO.getNinastnum();
								orderBVO.setNinastnum(MMNumberUtil.add(ninastnum, bUpdateChangeNastnum));
								
								BigDecimal ninnum = bvo.getNinnum();
								BigDecimal oldNinnum = oldBVO.getNinnum();
								BigDecimal bUpdateChangeNum = MMNumberUtil.subtract(ninnum, oldNinnum);
								BigDecimal orderNinnum = orderBVO.getNinnum();
								orderBVO.setNinnum(MMNumberUtil.add(orderNinnum, bUpdateChangeNum));
								PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
								orderBVOMapper.updateByPrimaryKey(orderBVO);
							}
						}
					}
				}
			}

			// 2.3、表体是删除的重置对应的销售订单的已开票销售数量和已开票主数量
			String deleteBodys = newJsonBill.getDeleteBodys();
			List<FinprodinBVO> deleteBVOs = JsonUtils.jsonToList(deleteBodys, FinprodinBVO.class);
			if (MMCollectionUtil.isNotEmpty(deleteBVOs)) {
				for (FinprodinBVO bvo : deleteBVOs) {
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
