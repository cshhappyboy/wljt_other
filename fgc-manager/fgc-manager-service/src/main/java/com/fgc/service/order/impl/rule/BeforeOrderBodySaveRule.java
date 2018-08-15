package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.fgc.service.order.impl.util.ZhekouRule;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 主要用于修改/修订保存时，给新增的表体上赋默认值
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月31日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderBodySaveRule implements IRule<OrderHVO, OrderBVO> {

	@Autowired
	private EffcetBillCodeRule effcetCodeRule;

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private ZhekouRule zhekouRule;

	@Override
	public void process(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(bvos)) {
			String cbilltype = hvo.getCbilltype();
			for (OrderBVO bvo : bvos) {
				String delwarehousecode = bvo.getDelwarehousecode();
				String delwarehouse = bvo.getDelwarehouse();
				if (MMStringUtil.isNotEmpty(delwarehousecode) && MMStringUtil.isEmpty(delwarehouse)) {
					throw new RuntimeException("仓库出现错误,请重新输入仓库！！！");
				}
				if (MMNumberUtil.isLsZero(bvo.getNprice())) {
					throw new RuntimeException("单价不能为负数！");
				}
				if(!MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"))){
					if (zhekouRule.isZheKou(bvo.getCmaterial())) {
						bvo.setVbdef10("Y");
						BigDecimal nastnum = bvo.getNastnum();
						if (MMNumberUtil.isGtZero(nastnum)) {
							throw new RuntimeException("折扣类物料销售数量不能大于0！");
						}
					} else {
						bvo.setVbdef10("N");
					}
				}
				
				this.setDefaultInfo(bvo);
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

				if (effcetCodeRule.isCan(bvo.getCmaterial()) && MMStringUtil.isNotEmpty(hvo.getEffectbillcode())) {
					bvo.setSizecode(hvo.getEffectbillcode());
				}
				if (MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"))
						|| MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode("ORDER_GONGCHENG_BILLTYPE"))) {
					if (MMNumberUtil.isLsZero(bvo.getNmny()) && MMNumberUtil.isLs(bvo.getNmny(),
							new BigDecimal(pubInfoService.getValueByCode("ZHE_KOU")))) {
						throw new RuntimeException("折扣金额不能小于定义好的金额,折扣金额为【" + bvo.getNmny() + "】,定义的金额为【"
								+ pubInfoService.getValueByCode("ZHE_KOU") + "】");
					}
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
	private void setDefaultInfo(OrderBVO bvo) {
		String pk_group = pubInfoService.getPk_group();
		String pk_org = pubInfoService.getPk_org();
		bvo.setPkGroup(pk_group);
		bvo.setPkOrg(pk_org);
	}

}
