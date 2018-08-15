package com.fgc.service.order.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.util.PubParam;
import com.fgc.service.order.impl.util.EffcetBillCodeRule;
import com.fgc.service.order.impl.util.ZhekouRule;
import com.fgc.service.pub.IPubInfoService;
import com.pub.rule.IRule;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月31日
 *
 *     未来离线需求
 */
@Component
public class BeforeOrderBodyUpdateRule implements IRule<OrderHVO, OrderBVO> {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private EffcetBillCodeRule effcetCodeRule;

	@Autowired
	private ZhekouRule zhekouRule;

	@Override
	public void process(OrderHVO hvo, OrderBVO[] bvos) throws Exception {
		if (MMValueUtils.isNotEmpty(hvo) && MMValueUtils.isNotEmpty(bvos)) {
			List<String> listMsg = new ArrayList<>();
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
				if (zhekouRule.isZheKou(bvo.getCmaterial())) {
					bvo.setVbdef10("Y");
					BigDecimal nastnum = bvo.getNastnum();
					if (MMNumberUtil.isGtZero(nastnum)) {
						throw new RuntimeException("折扣类物料销售数量不能大于0！");
					}
				} else {
					bvo.setVbdef10("N");
				}
				String materialcode = bvo.getMaterialcode();
				BigDecimal ninvoicenastnum = bvo.getNinvoicenastnum();
				BigDecimal ninastnum = bvo.getNinastnum();
				BigDecimal ninfonum = bvo.getNinfonum();
				BigDecimal nastnum = bvo.getNastnum();

				if (bvo.getServices() == 0L
						&& !MMStringUtil.isEqual(cbilltype, pubInfoService.getValueByCode(PubParam.ORDER_RETURNSALE_BILLTYPE))) {
					if (MMNumberUtil.isLs(nastnum, ninvoicenastnum)) {
						this.contrantMsg(listMsg, materialcode, "数量不能小于已开票发票数量");
					}
					if (MMNumberUtil.isLs(nastnum, ninastnum)) {
						this.contrantMsg(listMsg, materialcode, "数量不能小于已入库数量");
					}
					if (MMNumberUtil.isLs(nastnum, ninfonum)) {
						this.contrantMsg(listMsg, materialcode, "数量不能小于通知生产数量");
					}
					if (effcetCodeRule.isCan(bvo.getCmaterial()) && MMStringUtil.isNotEmpty(hvo.getEffectbillcode())) {
						bvo.setSizecode(hvo.getEffectbillcode());
					}
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
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}

	/**
	 * 
	 * @param listMsg
	 * @param msg
	 */
	private void contrantMsg(List<String> listMsg, String materialcode, String msg) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("物料编码:【" + materialcode + "】,");
		sBuilder.append(msg);
		sBuilder.append("。");
		listMsg.add(sBuilder.toString());
	}
}
