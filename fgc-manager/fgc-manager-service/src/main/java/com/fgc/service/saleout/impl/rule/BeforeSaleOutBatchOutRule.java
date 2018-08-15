package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.AggVO;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月16日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutBatchOutRule {

	public void process(List<AggVO<SaleOutHVO, SaleOutBVO>> aggVOs, String nowDate) throws Exception {
		for (AggVO<SaleOutHVO, SaleOutBVO> aggVO : aggVOs) {
			SaleOutHVO headVO = aggVO.getHeadVO();
			SaleOutBVO[] bodyVOs = aggVO.getBodyVOs();
			BigDecimal sumNum = BigDecimal.ZERO;
			for (SaleOutBVO saleOutBVO : bodyVOs) {
				BigDecimal nshouldassistnum = saleOutBVO.getNshouldassistnum();
				BigDecimal nshouldnum = saleOutBVO.getNshouldnum();
				saleOutBVO.setNassistnum(nshouldassistnum);
				saleOutBVO.setNnum(nshouldnum);

				String dbizdate = saleOutBVO.getDbizdate();
				if (MMStringUtil.isEmpty(dbizdate)) {
					saleOutBVO.setDbizdate(nowDate);
				}
				sumNum = MMNumberUtil.add(sumNum,saleOutBVO.getNassistnum());
			}
			headVO.setNtotalnum(sumNum);
		}
	}
}
