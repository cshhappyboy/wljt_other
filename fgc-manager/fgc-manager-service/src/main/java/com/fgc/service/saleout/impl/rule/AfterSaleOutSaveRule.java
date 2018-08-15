package com.fgc.service.saleout.impl.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.InvoiceHVOMapper;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.rule.IRule;
import com.pub.utils.MMStringUtil;

/**
 * 销售出库保存后业务规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月31日
 *
 *     未来离线需求
 */
@Component
public class AfterSaleOutSaveRule implements IRule<SaleOutHVO, SaleOutBVO> {

	@Autowired
	private InvoiceHVOMapper invoiceHVOMapper;

	/**
	 * 销售出库保存时，需要回写销售发票
	 */
	@Override
	public void process(SaleOutHVO hvo, SaleOutBVO[] bvos) {
		String vsrcid = hvo.getVsrcid();
		if (MMStringUtil.isNotEmpty(vsrcid)) {
			// 回写发票表头
			InvoiceHVO invoiceHVO = invoiceHVOMapper.selectByPrimaryKey(vsrcid);
			invoiceHVO.setAlreadyout(1L);
			invoiceHVOMapper.updateByPrimaryKey(invoiceHVO);
		}

	}

}
