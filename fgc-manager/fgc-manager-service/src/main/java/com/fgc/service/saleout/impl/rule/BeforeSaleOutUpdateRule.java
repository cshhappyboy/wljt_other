package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.SaleOutBVOMapper;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutUpdateRule implements IRule<SaleOutHVO, SaleOutBVO> {
	
	@Autowired
	private SaleOutBVOMapper outBVOMapper;

	@Override
	public void process(SaleOutHVO hvo, SaleOutBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			BigDecimal sumNum = BigDecimal.ZERO;
			String cwarehouseid = hvo.getCwarehouseid();
			for (SaleOutBVO bvo : bvos) {
				bvo.setVbdef1(cwarehouseid);
				BigDecimal nassistnum = bvo.getNassistnum();
				sumNum = MMNumberUtil.add(sumNum, nassistnum);
				outBVOMapper.updateByPrimaryKey(bvo);
			}
			hvo.setNtotalnum(sumNum);
		}
	}
}
