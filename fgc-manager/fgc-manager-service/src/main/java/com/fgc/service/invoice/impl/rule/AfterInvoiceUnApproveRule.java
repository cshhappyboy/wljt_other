package com.fgc.service.invoice.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderHVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.PojoTools;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月14日
 *
 *     未来离线需求
 */
@Component
public class AfterInvoiceUnApproveRule {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	/**
	 * @param aggVOs
	 * @throws Exception
	 */
	public void process(List<InvoiceHVO> listHVOs) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			for (InvoiceHVO invoiceHVO : listHVOs) {
				String vsrcid = invoiceHVO.getVsrcid();
				if (MMStringUtil.isNotEmpty(vsrcid)) {
					OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
					BigDecimal nreceivedmny = orderHVO.getNreceivedmny();
					BigDecimal retainage = invoiceHVO.getRetainage();
					orderHVO.setNreceivedmny(MMNumberUtil.subtract(nreceivedmny, retainage));
					
					PojoTools.beforeUpdate(OrderHVO.class, orderHVO);
					orderHVOMapper.updateByPrimaryKey(orderHVO);
				}
			}
		}
	}
}
