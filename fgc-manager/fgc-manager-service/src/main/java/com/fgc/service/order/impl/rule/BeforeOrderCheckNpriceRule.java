package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.MaterialSaleVOMapper;
import com.fgc.pojo.MaterialSaleVO;
import com.fgc.pojo.MaterialSaleVOExample;
import com.fgc.pojo.MaterialSaleVOExample.Criteria;
import com.fgc.pojo.OrderBVO;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
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
public class BeforeOrderCheckNpriceRule {

	@Autowired
	private MaterialSaleVOMapper materialSaleVOMapper;

	/**
	 * @param array
	 */
	public void process(OrderBVO[] array) {
		if (MMArrayUtil.isNotEmpty(array)) {
			List<String> listMsg = new ArrayList<>();
			for (OrderBVO orderBVO : array) {
				String cmaterial = orderBVO.getCmaterial();
				String materialcode = orderBVO.getMaterialcode();
				if (MMStringUtil.isNotEmpty(cmaterial)) {
					MaterialSaleVOExample example = new MaterialSaleVOExample();
					Criteria createCriteria = example.createCriteria();
					createCriteria.andPkmaterialEqualTo(cmaterial);
					List<MaterialSaleVO> listMaterialSaleVOs = materialSaleVOMapper.selectByExample(example);
					if (MMCollectionUtil.isNotEmpty(listMaterialSaleVOs)) {
						MaterialSaleVO materialSaleVO = listMaterialSaleVOs.get(0);
						BigDecimal minprice = materialSaleVO.getMinprice();
						if (MMNumberUtil.isLs(orderBVO.getNsaleprice(), minprice)) {
							StringBuilder sBuilder = new StringBuilder();
							sBuilder.append("物料编码:【" + materialcode + "】");
							sBuilder.append("销售单价小于最低售价,不能保存！");
							sBuilder.append("最低售价为" + minprice + "。");
							listMsg.add(sBuilder.toString());
						}
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}
}
