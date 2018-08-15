package com.fgc.service.receipt.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.mapper.ReceiptHVOMapper;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.ReceiptHVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月2日
 *
 *     未来离线需求
 */
@Component
public class AfterReceiptDeleteRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private ReceiptHVOMapper receiptHVOMapper;

	public void process(List<String> listIds) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			for (String id : listIds) {
				ReceiptHVO receiptHVO = receiptHVOMapper.selectByPrimaryKey(id);
				String vsrcid = receiptHVO.getVsrcid();
				if (MMStringUtil.isNotEmpty(vsrcid)) {
					OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
					BigDecimal oldNreceivedmny = orderHVO.getNreceivedmny();
					orderHVO.setNreceivedmny(MMNumberUtil.subtract(oldNreceivedmny, receiptHVO.getTotal()));
					String orderEffectbillcode = orderHVO.getEffectbillcode();
					String effectbillcode = receiptHVO.getEffectbillcode();
					if (MMStringUtil.isEmpty(orderEffectbillcode)) {
						orderHVO.setEffectbillcode(effectbillcode);
					}
					PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
					orderHVOMapper.updateByPrimaryKey(orderHVO);
				}
			}
		}
	}
}
