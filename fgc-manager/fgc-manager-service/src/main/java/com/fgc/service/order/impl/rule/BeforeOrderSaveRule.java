package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;
import java.util.List;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.fgc.service.order.impl.util.ZhekouRule;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 销售订单保存前规则
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月25日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderSaveRule implements IRule<OrderHVO, OrderBVO> {

	@Autowired
	private EffcetBillCodeRule effcetBillCodeRule;

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Autowired
	private ZhekouRule zhekouRule;

	@Override
	public void process(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			this.setDefaultInfo(hvo, bvos);
			// 为表头存入折本汇率，主要方便发票回写订单是带出汇率
			BigDecimal sumZkNmny = BigDecimal.ZERO;// 折扣钱
			BigDecimal sumNum = BigDecimal.ZERO;
			BigDecimal sumNmny = BigDecimal.ZERO;

			String cbilltype = hvo.getCbilltype();

			String integerMeasdoc = pubInfoService.getValueByCode("INTEGER_MEASDOC");
			String[] imArr = integerMeasdoc.split(",");
			List<String> listImArr = MMArrayUtil.toList(String.class, imArr);

			for (OrderBVO bvo : bvos) {
				String csaleunitid = bvo.getCsaleunitid();
				BigDecimal salenum = bvo.getSalenum();
				String materialCode = bvo.getMaterialcode();
				if (listImArr.contains(csaleunitid) && new BigDecimal(salenum.intValue()).compareTo(salenum) != 0) {
					throw new RuntimeException("物料编码：[ " + materialCode + " ]不能有小数,[ "+salenum+" ]");
				}

				String delwarehousecode = bvo.getDelwarehousecode();
				String delwarehouse = bvo.getDelwarehouse();
				if (MMStringUtil.isNotEmpty(delwarehousecode) && MMStringUtil.isEmpty(delwarehouse)) {
					throw new RuntimeException("仓库出现错误,请重新输入仓库！！！");
				}
				if (MMNumberUtil.isLsZero(bvo.getNprice())) {
					throw new RuntimeException("单价不能为负数！");
				}
				if (zhekouRule.isZheKou(bvo.getCmaterial())) {
					bvo.setVbdef10("Y");
					sumZkNmny = MMNumberUtil.add(sumZkNmny, bvo.getNmny());
				} else {
					bvo.setVbdef10("N");
				}
				if (MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"))
						|| MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_GONGCHENG_BILLTYPE"))) {
					if (MMNumberUtil.isLsZero(bvo.getNmny()) && MMNumberUtil.isLs(bvo.getNmny(),
							new BigDecimal(pubInfoService.getValueByCode("ZHE_KOU")))) {
						throw new RuntimeException("折扣金额不能小于定义好的金额,折扣金额为【" + bvo.getNmny() + "】,定义的金额为【"
								+ pubInfoService.getValueByCode("ZHE_KOU") + "】");
					}
				}
				if (bvo.getServices() == 0L) {
					sumNum = MMNumberUtil.add(sumNum, bvo.getNastnum());
				}
				sumNmny = MMNumberUtil.add(sumNmny, bvo.getNmny());
			}

			if (MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"))) {
				if (MMNumberUtil.isGtZero(sumNum) || MMNumberUtil.isGtZero(sumNmny)) {
					throw new RuntimeException("退货订单，数量和金额不允许大于0！");
				}
			}

			hvo.setVdef2(sumZkNmny.toString());
			hvo.setNtotalnum(sumNum);
			hvo.setNorigtaxmny(sumNmny);
			// 补充数据
			this.setDataValue(hvo, bvos);
		}
	}

	/**
	 * @param hvo
	 * @throws Exception
	 */
	private void setDataValue(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		Long returnsale = hvo.getReturnsale();
		if (MMValueUtils.isEmpty(returnsale)) {
			hvo.setReturnsale(0L);
		}
		hvo.setNreceivedmny(BigDecimal.ZERO);
		hvo.setNtotalinnum(BigDecimal.ZERO);
		hvo.setNtotalinvoicemny(BigDecimal.ZERO);
		hvo.setNtotalinvoicenum(BigDecimal.ZERO);
		// 设置单据类型编码
		String cbilltype = hvo.getCbilltype();
		BilltypeVO billtypeVO = billtypeVOMapper.selectByPrimaryKey(cbilltype);
		hvo.setVbilltype(billtypeVO.getPkbilltypecode());

		String effectbillcode = hvo.getEffectbillcode();
		for (OrderBVO bvo : bvos) {
			Long gift = bvo.getGift();
			if (MMValueUtils.isEmpty(gift)) {
				bvo.setGift(0L);
			}
			BigDecimal ninvoicesalenum = bvo.getNinvoicesalenum();
			BigDecimal ninastnum = bvo.getNinastnum();
			if (MMNumberUtil.isNullOrZero(ninvoicesalenum)) {
				bvo.setNinvoicesalenum(BigDecimal.ZERO);
			}
			if (MMNumberUtil.isNullOrZero(ninastnum)) {
				bvo.setNinastnum(BigDecimal.ZERO);
			}
			bvo.setNexchangerate(hvo.getNexchangerate().toString());

			if (MMStringUtil.isNotEmpty(effectbillcode)) {
				if (effcetBillCodeRule.isCan(bvo.getCmaterial())) {
					bvo.setSizecode(effectbillcode);
				}
			}
		}
	}

	/**
	 * 设置VO默认值
	 * 
	 * @param hvo
	 * @param bvos
	 */
	private void setDefaultInfo(OrderHVO hvo, OrderBVO[] bvos) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		hvo.setPkGroup(pk_group);
		hvo.setPkOrg(pk_org);
		for (OrderBVO bvo : bvos) {
			bvo.setPkGroup(pk_group);
			bvo.setPkOrg(pk_org);
		}
	}
}
