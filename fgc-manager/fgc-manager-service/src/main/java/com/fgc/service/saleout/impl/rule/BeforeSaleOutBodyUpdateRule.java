package com.fgc.service.saleout.impl.rule;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.MMStringUtil;
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
public class BeforeSaleOutBodyUpdateRule {

	public void process(SaleOutHVO hvo, SaleOutBVO[] bvos, String nowDate) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			String cwarehouseid = hvo.getCwarehouseid();
			if (new DateTime(nowDate).isBefore(new DateTime(hvo.getDbilldate()))) {
				throw new RuntimeException("出库时间不能早于单据时间！");
			}
			for (SaleOutBVO saleOutBVO : bvos) {
				saleOutBVO.setVbdef1(cwarehouseid);
				String dbizdate = saleOutBVO.getDbizdate();
				if(MMStringUtil.isEmpty(dbizdate)){
					saleOutBVO.setDbizdate(nowDate);
				}
			}
		}
	}
}
