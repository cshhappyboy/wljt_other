package com.fgc.service.receipt.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.ReceiptHVO;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;

/**
 * 预收款单修改时回写销售订单
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月3日
 *
 *     未来离线需求
 */
@Component
public class AfterReceiptUpdateRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	public void process(ReceiptHVO hvo, ReceiptHVO oldHVO) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo)) {
			String vsrcid = hvo.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
				BigDecimal oldNreceivedmny = orderHVO.getNreceivedmny();

				BigDecimal total = hvo.getTotal();
				BigDecimal oldTotal = oldHVO.getTotal();
				BigDecimal changeTotal = MMNumberUtil.subtract(total, oldTotal);
				orderHVO.setNreceivedmny(MMNumberUtil.add(oldNreceivedmny, changeTotal));
				PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
				orderHVOMapper.updateByPrimaryKey(orderHVO);
			}
		}
	}

}
