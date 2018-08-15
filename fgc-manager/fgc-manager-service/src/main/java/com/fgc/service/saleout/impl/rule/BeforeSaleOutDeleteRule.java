package com.fgc.service.saleout.impl.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.InvoiceHVOMapper;
import com.fgc.mapper.SaleOutHVOMapper;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;

/**
 * 销售出库删除回写销售发票和销售订单
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月15日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutDeleteRule {

	@Autowired
	private SaleOutHVOMapper outHVOMapper;

	@Autowired
	private InvoiceHVOMapper invoiceHVOMapper;

	public void process(List<String> listIds) {
		for (String id : listIds) {
			SaleOutHVO headVO = outHVOMapper.selectByPrimaryKey(id);
			String vsrcid = headVO.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				InvoiceHVO invoiceHVO = invoiceHVOMapper.selectByPrimaryKey(vsrcid);
				if (MMNumberUtil.isLsEqualZero(invoiceHVO.getNtotaloutnum())) {
					invoiceHVO.setAlreadyout(0L);
				}
				invoiceHVOMapper.updateByPrimaryKey(invoiceHVO);
			}
		}
	}

}
