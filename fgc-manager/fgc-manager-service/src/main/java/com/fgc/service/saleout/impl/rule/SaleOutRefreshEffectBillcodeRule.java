package com.fgc.service.saleout.impl.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.SaleOutBVOMapper;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年5月15日
 *
 *     未来离线需求
 */
@Component
public class SaleOutRefreshEffectBillcodeRule {
	@Autowired
	private EffcetBillCodeRule effcetBillCodeRule;

	@Autowired
	private SaleOutBVOMapper outBVOMapper;

	public void process(List<SaleOutBVO> listBVOs, String effectbillcode) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listBVOs) && MMStringUtil.isNotEmpty(effectbillcode)) {
			for (SaleOutBVO bvo : listBVOs) {
				String cmaterial = bvo.getCmaterial();
				if (effcetBillCodeRule.isCan(cmaterial)) {
					PojoTools.beforeUpdate(OrderBVO.class, bvo);
					bvo.setVbatchcode(effectbillcode);
					outBVOMapper.updateByPrimaryKey(bvo);
				}
			}
		}
	}
}
