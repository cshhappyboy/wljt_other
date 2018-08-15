package com.fgc.service.whstrans.impl.rule;

import org.springframework.stereotype.Component;

import com.fgc.pojo.WhstransHVO;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 校验出库和入库不能相同
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月3日
 *
 *     未来离线需求
 */
@Component
public class CheckStoreDoceRule {

	public void process(WhstransHVO hvo) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo)) {
			String cotherwhid = hvo.getCotherwhid();// 入库仓库
			String coutwarehouseid = hvo.getCoutwarehouseid();
			if (MMStringUtil.isEqual(cotherwhid, coutwarehouseid)) {
				throw new RuntimeException("入库仓库和出库仓库不能相同");
			}
		}
	}
}
