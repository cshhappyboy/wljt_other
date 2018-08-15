package com.fgc.service.order.impl.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.pojo.util.PubParam;
import com.fgc.service.adjustrate.IAdjustrateService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.AggVO;
import com.pub.utils.BillStatus;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;

/**
 * 单据转换工具类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月24日
 *
 *     未来离线需求
 */
@Component
public class OrderChangeUtils {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private IAdjustrateService adjustrateService;

	/**
	 * @param listAggVOs
	 * @param nowDate
	 * @param listBillcodes
	 * @return List<JsonBill>
	 */
	public List<JsonBill> changeVO2InvoiceVO(List<AggVO<OrderHVO, OrderBVO>> listAggVOs, String nowDate) {
		List<JsonBill> listJsonBill = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listAggVOs)) {
			for (AggVO<OrderHVO, OrderBVO> aggVO : listAggVOs) {
				OrderHVO headVO = aggVO.getHeadVO();
				OrderBVO[] bodyVOs = aggVO.getBodyVOs();
				BigDecimal nexchangerate = adjustrateService.selectByCurreny(headVO.getCurrency(),nowDate);

				InvoiceHVO invoiceHVO = change2InvoiceHVO(headVO, nowDate, nexchangerate);
				InvoiceBVO[] invoiceBVOs = change2InvoiceBVOs(bodyVOs, headVO, nexchangerate);

				JsonBill jsonBill = new JsonBill();
				jsonBill.setHead(JsonUtils.objectToJson(invoiceHVO));
				jsonBill.setInsertBodys(JsonUtils.objectToJson(invoiceBVOs));

				listJsonBill.add(jsonBill);
			}
		}
		return listJsonBill;
	}

	/**
	 * 转换表头数据
	 * 
	 * @param nowDate
	 * @param nexchangerate
	 * 
	 * @param listHVOs
	 * @param listBillcodes
	 */
	private InvoiceHVO change2InvoiceHVO(OrderHVO headVO, String nowDate, BigDecimal nexchangerate) {
		InvoiceHVO invoiceHVO = new InvoiceHVO();
		invoiceHVO.setVbillstatus(BillStatus.FREE);
		invoiceHVO.setDbilldate(nowDate);// 单据日期
		invoiceHVO.setCustomer(headVO.getCustomer());// 客户
		invoiceHVO.setCurrency(headVO.getCurrency());// 币种
		invoiceHVO.setVsrcid(headVO.getId());
		invoiceHVO.setVsrccode(headVO.getVbillcode());
		invoiceHVO.setCdept(headVO.getCdept());
		invoiceHVO.setSalesman(headVO.getSalesman());
		invoiceHVO.setCbalatype(headVO.getCbalatype());
		if (MMStringUtil.isEqual(headVO.getCbalatype(), "0001Z0100000000000XZ")) {
			invoiceHVO.setCashaccount(pubInfoService.getCashaccount(headVO.getCdept()));
		}
		invoiceHVO.setClient(headVO.getClient());
		invoiceHVO.setAddress(headVO.getAddress());
		invoiceHVO.setTel(headVO.getTel());
		invoiceHVO.setMemo(headVO.getMemo());
		invoiceHVO.setVorderbillcode(headVO.getVbillcode());
		invoiceHVO.setEffectbillcode(headVO.getEffectbillcode());
		invoiceHVO.setNsalemny(headVO.getNorigtaxmny());
		invoiceHVO.setNtotalrecemny(headVO.getNreceivedmny());
		invoiceHVO.setVsrcbilltype(headVO.getCbilltype());
		invoiceHVO.setReturnsale(headVO.getReturnsale());
		invoiceHVO.setCbilltype("0001A110000000001SS1");
		invoiceHVO.setVbilltype("32-02");

		invoiceHVO.setNexchangerate(nexchangerate);
		invoiceHVO.setVsrcbilltypecode(headVO.getVbilltype());
		invoiceHVO.setNtotalinvoicemny(headVO.getNtotalinvoicemny());
		invoiceHVO.setVdef2(headVO.getVdef2());

		return invoiceHVO;
	}

	/**
	 * 转换表体数据
	 * 
	 * @param listBVOs
	 * @param nexchangerate
	 */
	private InvoiceBVO[] change2InvoiceBVOs(OrderBVO[] listBVOs, OrderHVO headVO, BigDecimal nexchangerate) {
		List<InvoiceBVO> listInvoiceBVOs = new ArrayList<>();
		if (MMArrayUtil.isNotEmpty(listBVOs)) {
			InvoiceBVO invoiceBVO = null;
			for (OrderBVO orderBVO : listBVOs) {
				invoiceBVO = new InvoiceBVO();
				invoiceBVO.setCmaterial(orderBVO.getCmaterial());// 物料
				invoiceBVO.setMaterialcode(orderBVO.getMaterialcode());
				invoiceBVO.setMaterialspec(orderBVO.getMaterialspec());
				invoiceBVO.setMaterialtype(orderBVO.getMaterialtype());
				invoiceBVO.setCastunitid(orderBVO.getCastunitid());// 单位
				invoiceBVO.setNastnum(MMNumberUtil.subtract(orderBVO.getNastnum(), orderBVO.getNinvoicenastnum()));// 辅数量
				invoiceBVO.setCunitid(orderBVO.getCunitid());// 主单位
				invoiceBVO.setNnum(MMNumberUtil.subtract(orderBVO.getNnum(), orderBVO.getNinvoicenum()));// 主数量
				invoiceBVO.setNprice(orderBVO.getNprice());// 单价
				invoiceBVO.setVsrcid(orderBVO.getHid());
				invoiceBVO.setVsrcbid(orderBVO.getId());
				invoiceBVO.setCsaleunitid(orderBVO.getCsaleunitid());
				invoiceBVO.setVunitratio(orderBVO.getVunitratio());
				invoiceBVO.setNoinvoicesalenum(
						MMNumberUtil.subtract(orderBVO.getSalenum(), orderBVO.getNinvoicesalenum()));
				invoiceBVO.setSalenum(MMNumberUtil.subtract(orderBVO.getSalenum(), orderBVO.getNinvoicesalenum()));
				invoiceBVO.setNsaleprice(orderBVO.getNsaleprice());
				invoiceBVO.setNmny(MMNumberUtil.subtract(orderBVO.getNmny(), orderBVO.getNinvoicemny()));// 金额

				invoiceBVO.setSizecode(orderBVO.getSizecode());
				invoiceBVO.setDelwarehouse(orderBVO.getDelwarehouse());
				invoiceBVO.setNexchangerate(nexchangerate.toString());
				invoiceBVO.setCustomer(headVO.getCustomer());
				invoiceBVO.setCurrency(headVO.getCurrency());
				invoiceBVO.setCbalatype(headVO.getCurrency());
				invoiceBVO.setGift(orderBVO.getGift());
				invoiceBVO.setServices(orderBVO.getServices());
				invoiceBVO.setVtransrate(orderBVO.getMeasrate());
				invoiceBVO.setDelwarehousecode(orderBVO.getDelwarehousecode());
				invoiceBVO.setVbdef10(orderBVO.getVbdef10());
				invoiceBVO.setVbdef5(orderBVO.getVbdef1());
				invoiceBVO.setVbdef6(orderBVO.getVbdef2());
				
				String cbilltype = headVO.getCbilltype();
				if(MMStringUtil.isEqual(pubInfoService.getValueByCode(PubParam.ORDER_RETURNSALE_BILLTYPE), cbilltype)){
					invoiceBVO.setNoutnum(orderBVO.getNoutnastum());
					invoiceBVO.setVbdef9(orderBVO.getNoutnum() == null ? "0" : orderBVO.getNoutnum().toString());
				}

				if (MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"), cbilltype)) {
					invoiceBVO.setCsubjcode("1001A110000000000Q18");
				} else if (MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_GONGCHENG_BILLTYPE"), cbilltype)) {
					invoiceBVO.setCsubjcode("1001A110000000000Q17");
				} else {
					invoiceBVO.setCsubjcode("1001A110000000000Q18");
				}
				listInvoiceBVOs.add(invoiceBVO);
			}
		}
		return MMArrayUtil.toArray(listInvoiceBVOs);
	}

	/**
	 * 将VO聚合
	 * 
	 * @param listHVOs
	 * @param listBVOs
	 * @return AggVO<OrderHVO, OrderBVO>
	 */
	public List<AggVO<OrderHVO, OrderBVO>> aggVOs(List<OrderHVO> listHVOs, List<OrderBVO> listBVOs) {
		List<AggVO<OrderHVO, OrderBVO>> listAggVOs = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			AggVO<OrderHVO, OrderBVO> aggVO = null;
			for (OrderHVO hvo : listHVOs) {
				aggVO = new AggVO<>();
				String id = hvo.getId();
				List<OrderBVO> list = null;
				if (MMCollectionUtil.isNotEmpty(listBVOs)) {
					list = new ArrayList<>();
					for (OrderBVO bvo : listBVOs) {
						String hid = bvo.getHid();
						if (MMStringUtil.isEqual(id, hid)) {
							list.add(bvo);
						}
					}
				}
				aggVO.setHeadVO(hvo);
				aggVO.setBodyVOs(MMArrayUtil.toArray(list));
				listAggVOs.add(aggVO);
			}
		}
		return listAggVOs;
	}

	/**
	 * 销售订单转换为预收款单VO
	 * 
	 * @param nowDate
	 * 
	 * @param hvo
	 * @return ReceiptHVO
	 */
	public ReceiptHVO changeVO2ReceiptVO(OrderHVO headVO, String nowDate) {
		ReceiptHVO receiptHVO = new ReceiptHVO();
		receiptHVO.setMaxtotal(MMNumberUtil.subtract(headVO.getNorigtaxmny(), headVO.getNreceivedmny()));
		receiptHVO.setMintotal(BigDecimal.ZERO);
		receiptHVO.setVbillstatus(BillStatus.FREE);
		receiptHVO.setDbilldate(nowDate);// 单据日期
		receiptHVO.setCustomer(headVO.getCustomer());// 客户
		receiptHVO.setTotal(MMNumberUtil.subtract(headVO.getNorigtaxmny(), headVO.getNreceivedmny()));
		receiptHVO.setCdept(headVO.getCdept());// 部门
		receiptHVO.setSalesman(headVO.getSalesman());
		receiptHVO.setCurrency(headVO.getCurrency());
		receiptHVO.setCbalatype(headVO.getCbalatype());
		receiptHVO.setVorderbillcode(headVO.getVbillcode());
		receiptHVO.setVsrcbilltype(headVO.getCbilltype());
		receiptHVO.setNordermny(headVO.getNorigtaxmny());
		receiptHVO.setVsrcid(headVO.getId());
		receiptHVO.setVsrccode(headVO.getVbillcode());
		receiptHVO.setEffectbillcode(headVO.getEffectbillcode());
		receiptHVO.setNreceivedmny(headVO.getNreceivedmny());
		if (MMStringUtil.isEqual(headVO.getCbalatype(), "0001Z0100000000000XZ")) {
			receiptHVO.setCashaccount(pubInfoService.getCashaccount(headVO.getCdept()));
		}

		BigDecimal adjustrate = adjustrateService.selectByCurreny(headVO.getCurrency(),nowDate);
		receiptHVO.setTaux(adjustrate);

		return receiptHVO;
	}

	/**
	 * 销售订单转换为产成品入库单
	 * 
	 * @param listAggVOs
	 * @param nowDate
	 * @return List<JsonBill>
	 * @throws Exception
	 */
	public List<JsonBill> changeVO2Finprodin(List<AggVO<OrderHVO, OrderBVO>> listAggVOs, String nowDate)
			throws Exception {
		List<JsonBill> listJsonBill = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listAggVOs)) {
			for (AggVO<OrderHVO, OrderBVO> aggVO : listAggVOs) {
				OrderHVO headVO = aggVO.getHeadVO();
				OrderBVO[] bodyVOs = aggVO.getBodyVOs();

				FinprodinHVO finprodinHVO = change2FinprodinHVO(headVO, nowDate);
				FinprodinBVO[] finprodinBVOs = change2FinprodinBVOs(bodyVOs, headVO, nowDate);
				finprodinHVO.setCwarehouseid(bodyVOs[0].getDelwarehouse());
				JsonBill jsonBill = new JsonBill();
				jsonBill.setHead(JsonUtils.objectToJson(finprodinHVO));
				jsonBill.setInsertBodys(JsonUtils.objectToJson(finprodinBVOs));

				listJsonBill.add(jsonBill);
			}
		}
		return listJsonBill;
	}

	/**
	 * 销售订单转换为产成品入库单
	 * 
	 * @param listAggVOs
	 * @param nowDate
	 * @return List<JsonBill>
	 * @throws Exception
	 */
	public List<JsonBill> changeVO2FinprodinBatch(List<AggVO<OrderHVO, OrderBVO>> listAggVOs, String nowDate)
			throws Exception {
		if (MMCollectionUtil.isNotEmpty(listAggVOs)) {
			for (AggVO<OrderHVO, OrderBVO> aggVO : listAggVOs) {
				OrderHVO headVO = aggVO.getHeadVO();
				OrderBVO[] bodyVOs = aggVO.getBodyVOs();

				FinprodinHVO finprodinHVO = change2FinprodinHVO(headVO, nowDate);
				List<JsonBill> jsonBills = change2FinprodinVOs(bodyVOs, finprodinHVO, headVO, nowDate);
				return jsonBills;
			}
		}
		return null;
	}

	/**
	 * @param bodyVOs
	 * @param finprodinHVO
	 * @param headVO
	 * @param headVO
	 * @param nowDate
	 * @return
	 * @throws Exception
	 */
	private List<JsonBill> change2FinprodinVOs(OrderBVO[] bodyVOs, FinprodinHVO finprodinHVO, OrderHVO headVO,
			String nowDate) throws Exception {
		List<JsonBill> listJsonBills = new ArrayList<>();
		if (MMArrayUtil.isNotEmpty(bodyVOs)) {
			FinprodinBVO finprodinBVO = null;
			Map<String, List<FinprodinBVO>> mapList = new HashMap<>();
			for (OrderBVO orderBVO : bodyVOs) {
				if (orderBVO.getServices() == 1L) {
					continue;
				}

				if (MMNumberUtil.isLsEqualZero(MMNumberUtil.subtract(orderBVO.getNastnum(), orderBVO.getNinastnum()))
						&& MMNumberUtil
								.isLsEqualZero(MMNumberUtil.subtract(orderBVO.getNnum(), orderBVO.getNinnum()))) {
					continue;
				}

				finprodinBVO = new FinprodinBVO();
				finprodinBVO.setCmaterial(orderBVO.getCmaterial());// 物料
				finprodinBVO.setMaterialcode(orderBVO.getMaterialcode());
				finprodinBVO.setMaterialspec(orderBVO.getMaterialspec());
				finprodinBVO.setMaterialtype(orderBVO.getMaterialtype());
				finprodinBVO.setCastunitid(orderBVO.getCastunitid());// 单位
				finprodinBVO.setNinassistnum(MMNumberUtil.subtract(orderBVO.getNastnum(), orderBVO.getNinastnum()));// 辅数量
				finprodinBVO.setCunitid(orderBVO.getCunitid());
				finprodinBVO.setNinnum(MMNumberUtil.subtract(orderBVO.getNnum(), orderBVO.getNinnum()));
				finprodinBVO.setVsrcid(orderBVO.getHid());
				finprodinBVO.setVsrcbid(orderBVO.getId());

				finprodinBVO.setVbatchcode(orderBVO.getSizecode());
				finprodinBVO.setDbizindate(nowDate);
				finprodinBVO.setVtransrate(orderBVO.getMeasrate());
				finprodinBVO.setVbatchcode(orderBVO.getSizecode());
				finprodinBVO.setVbdef1(orderBVO.getNexchangerate());
				finprodinBVO.setVbdef2(orderBVO.getNmny().toString());

				String type = adjustrateService.selectChangeTypeByCurrency(headVO.getCurrency());
				// 0=源币种×汇率＝目的币种（本币） //1=源币种÷汇率＝目的币种（本币）
				BigDecimal nmny = orderBVO.getNmny();
				BigDecimal nnum = orderBVO.getNnum();
				if (MMStringUtil.isEqual("0", type)) {
					// 按销售订单金额携带后除以汇率除以2
					BigDecimal codtunitmny = MMNumberUtil.divide(MMNumberUtil.multiply(nmny, headVO.getNexchangerate()),
							BigDecimal.valueOf(2L));
					finprodinBVO.setCostunitmny(codtunitmny);
					finprodinBVO.setCostunitprice(MMNumberUtil.divide(codtunitmny, nnum));

				} else {
					BigDecimal divide = MMNumberUtil.divide(nmny, headVO.getNexchangerate());
					BigDecimal codtunitmny = MMNumberUtil.divide(divide, BigDecimal.valueOf(2L));
					finprodinBVO.setCostunitmny(codtunitmny);
					finprodinBVO.setCostunitprice(MMNumberUtil.divide(codtunitmny, nnum));
				}

				String delwarehouse = orderBVO.getDelwarehouse();
				List<FinprodinBVO> list = mapList.get(delwarehouse);
				if (MMCollectionUtil.isNotEmpty(list)) {
					list.add(finprodinBVO);
				} else {
					List<FinprodinBVO> listBVOs = new ArrayList<>();
					listBVOs.add(finprodinBVO);
					mapList.put(delwarehouse, listBVOs);
				}
			}

			Set<String> keySet = mapList.keySet();
			JsonBill jsonBill = null;
			for (String key : keySet) {
				jsonBill = new JsonBill();
				FinprodinHVO newHVO = new FinprodinHVO();
				BeanUtils.copyProperties(finprodinHVO, newHVO);
				newHVO.setCwarehouseid(key);
				List<FinprodinBVO> listBodys = mapList.get(key);
				jsonBill.setHead(JsonUtils.objectToJson(newHVO));
				jsonBill.setInsertBodys(JsonUtils.objectToJson(listBodys));
				listJsonBills.add(jsonBill);
			}

		}
		return listJsonBills;
	}

	/**
	 * @param headVO
	 * @param nowDate
	 * @param bodyVOs
	 * @return
	 */
	private FinprodinBVO[] change2FinprodinBVOs(OrderBVO[] listBVOs, OrderHVO headVO, String nowDate) throws Exception {
		List<FinprodinBVO> listFinprodinBVOs = new ArrayList<>();
		if (MMArrayUtil.isNotEmpty(listBVOs)) {
			FinprodinBVO finprodinBVO = null;
			for (OrderBVO orderBVO : listBVOs) {
				finprodinBVO = new FinprodinBVO();
				finprodinBVO.setCmaterial(orderBVO.getCmaterial());// 物料
				finprodinBVO.setMaterialcode(orderBVO.getMaterialcode());
				finprodinBVO.setMaterialspec(orderBVO.getMaterialspec());
				finprodinBVO.setMaterialtype(orderBVO.getMaterialtype());
				finprodinBVO.setCastunitid(orderBVO.getCastunitid());// 单位
				finprodinBVO.setNinassistnum(MMNumberUtil.subtract(orderBVO.getNastnum(), orderBVO.getNinastnum()));// 辅数量
				finprodinBVO.setCunitid(orderBVO.getCunitid());
				finprodinBVO.setNinnum(MMNumberUtil.subtract(orderBVO.getNnum(), orderBVO.getNinnum()));
				finprodinBVO.setVsrcid(orderBVO.getHid());
				finprodinBVO.setVsrcbid(orderBVO.getId());

				finprodinBVO.setVbatchcode(headVO.getEffectbillcode());
				finprodinBVO.setDbizindate(nowDate);

				finprodinBVO.setVtransrate(orderBVO.getMeasrate());
				finprodinBVO.setVbatchcode(orderBVO.getSizecode());

				String type = adjustrateService.selectChangeTypeByCurrency(headVO.getCurrency());
				// 0=源币种×汇率＝目的币种（本币） //1=源币种÷汇率＝目的币种（本币）
				BigDecimal nmny = orderBVO.getNmny();
				BigDecimal nnum = orderBVO.getNnum();
				if (MMStringUtil.isEqual("0", type)) {
					// 按销售订单金额携带后除以汇率除以2
					BigDecimal codtunitmny = MMNumberUtil.divide(MMNumberUtil.multiply(nmny, headVO.getNexchangerate()),
							BigDecimal.valueOf(2L));
					finprodinBVO.setCostunitmny(codtunitmny);
					finprodinBVO.setCostunitprice(MMNumberUtil.divide(codtunitmny, nnum));

				} else {
					BigDecimal divide = MMNumberUtil.divide(nmny, headVO.getNexchangerate());
					BigDecimal codtunitmny = MMNumberUtil.divide(divide, BigDecimal.valueOf(2L));
					finprodinBVO.setCostunitmny(codtunitmny);
					finprodinBVO.setCostunitprice(MMNumberUtil.divide(codtunitmny, nnum));
				}
				finprodinBVO.setVbdef1(orderBVO.getNexchangerate());
				finprodinBVO.setVbdef2(orderBVO.getNmny().toString());

				listFinprodinBVOs.add(finprodinBVO);
			}
		}
		return MMArrayUtil.toArray(listFinprodinBVOs);
	}

	/**
	 * @param headVO
	 * @param nowDate
	 * @return
	 */
	private FinprodinHVO change2FinprodinHVO(OrderHVO headVO, String nowDate) {
		FinprodinHVO finprodinHVO = new FinprodinHVO();
		finprodinHVO.setCbilltype("0001A110000000001SSC");
		finprodinHVO.setVbilltype("46-01");
		finprodinHVO.setDbilldate(nowDate);// 单据日期
		finprodinHVO.setVsrcid(headVO.getId());
		finprodinHVO.setVsrccode(headVO.getVbillcode());
		finprodinHVO.setVbillstatus(BillStatus.FREE);
		finprodinHVO.setCdept(headVO.getCdept());
		finprodinHVO.setSalesman(headVO.getSalesman());
		finprodinHVO.setVorderbillcode(headVO.getVbillcode());
		finprodinHVO.setEffectbillcode(headVO.getEffectbillcode());
		finprodinHVO.setMemo(headVO.getMemo());
		return finprodinHVO;
	}

	/**
	 * 退货VO转换
	 * 
	 * @param headVO
	 * @param listBVOs
	 * @param nowDate
	 * @return JsonBill
	 */
	public JsonBill changeOrderSelf(OrderHVO orderHVO, List<OrderBVO> listBVOs, String nowDate) {
		orderHVO.setCbilltype(pubInfoService.getValueByCode(PubParam.ORDER_RETURNSALE_BILLTYPE));
		orderHVO.setVsrcid(orderHVO.getId());
		orderHVO.setVsrccode(orderHVO.getVbillcode());
		orderHVO.setId(null);
		orderHVO.setVbillcode(null);
		orderHVO.setDbilldate(nowDate);

		orderHVO.setVbillstatus(BillStatus.FREE);
		orderHVO.setBillmaker(null);
		orderHVO.setModifier(null);
		orderHVO.setModifiedtime(null);
		orderHVO.setApprover(null);
		orderHVO.setApprovetime(null);
		orderHVO.setTs(null);
		orderHVO.setDr(null);
		orderHVO.setIssync(null);
		orderHVO.setVdef1(null);

		orderHVO.setReturnsale(1L);
		orderHVO.setAlreadyin(0L);
		orderHVO.setAlreadyinvoice(0L);
		orderHVO.setAlreadyrevise(0L);

		orderHVO.setNorigtaxmny(null);
		orderHVO.setNreceivedmny(null);
		orderHVO.setNtotalinvoicemny(null);
		orderHVO.setNtotalinvoicenum(null);
		orderHVO.setNtotalinnum(null);
		orderHVO.setNtotalnum(null);

		BigDecimal nexchangerate = adjustrateService.selectByCurreny(orderHVO.getCurrency(),nowDate);
		orderHVO.setNexchangerate(nexchangerate);

		for (OrderBVO orderBVO : listBVOs) {
			orderBVO.setVsrcid(orderBVO.getHid());
			orderBVO.setVsrcbid(orderBVO.getId());
			orderBVO.setId(null);
			orderBVO.setHid(null);
			orderBVO.setSalenum(MMNumberUtil.subtract(BigDecimal.ZERO, orderBVO.getSalenum()));
			orderBVO.setNastnum(MMNumberUtil.subtract(BigDecimal.ZERO, orderBVO.getNastnum()));
			orderBVO.setNmny(MMNumberUtil.subtract(BigDecimal.ZERO, orderBVO.getNmny()));
			orderBVO.setNnum(MMNumberUtil.subtract(BigDecimal.ZERO, orderBVO.getNnum()));
			orderBVO.setNinastnum(null);
			orderBVO.setNinfonum(null);
			orderBVO.setNinnum(null);
			orderBVO.setNinvoicemny(null);
			orderBVO.setNinvoicenastnum(null);
			orderBVO.setNinvoicenum(null);
			orderBVO.setNinvoicesalenum(null);
			orderBVO.setNoutnastum(orderBVO.getNoutnastum());
			orderBVO.setNoutnum(orderBVO.getNoutnum());
			orderBVO.setNthisinfonum(null);
		}

		JsonBill jsonBill = new JsonBill();
		jsonBill.setHead(JsonUtils.objectToJson(orderHVO));
		jsonBill.setInsertBodys(JsonUtils.objectToJson(listBVOs));
		return jsonBill;
	}

}
