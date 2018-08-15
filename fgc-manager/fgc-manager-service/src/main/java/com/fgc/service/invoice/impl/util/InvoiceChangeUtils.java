package com.fgc.service.invoice.impl.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
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
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月8日
 *
 *     未来离线需求
 */
@Component
public class InvoiceChangeUtils {

	@Autowired
	private IPubInfoService pubInfoService;

	/**
	 * @param list
	 * @param listBVOs
	 * @return
	 */
	public List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs(List<InvoiceHVO> listHVOs, List<InvoiceBVO> listBVOs) {
		List<AggVO<InvoiceHVO, InvoiceBVO>> listAggVOs = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			AggVO<InvoiceHVO, InvoiceBVO> aggVO = null;
			for (InvoiceHVO hvo : listHVOs) {
				aggVO = new AggVO<>();
				String id = hvo.getId();
				List<InvoiceBVO> list = null;
				if (MMCollectionUtil.isNotEmpty(listBVOs)) {
					list = new ArrayList<>();
					for (InvoiceBVO bvo : listBVOs) {
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
	 * @param listAggVOs
	 * @param linShouBilltype
	 * @param nowDate
	 * @return
	 */
	public List<JsonBill> changeVO2SaleOutVOBatch(List<AggVO<InvoiceHVO, InvoiceBVO>> listAggVOs, String nowDate) {
		List<JsonBill> allJsonBill = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listAggVOs)) {
			boolean isLingshou = false;
			boolean isReturnsale = false;
			for (AggVO<InvoiceHVO, InvoiceBVO> aggVO : listAggVOs) {
				InvoiceHVO headVO = aggVO.getHeadVO();
				InvoiceBVO[] bodyVOs = aggVO.getBodyVOs();
				String vsrcbilltype = headVO.getVsrcbilltype();
				if (MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"), vsrcbilltype)) {
					isLingshou = true;
				} else if (MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"),
						vsrcbilltype)) {
					isReturnsale = true;
				}

				SaleOutHVO saleOutHVO = change2SaleOutHVO(headVO, nowDate);
				List<JsonBill> jsonBills = change2SaleOutBatch(bodyVOs, saleOutHVO, isLingshou, isReturnsale, nowDate);
				allJsonBill.addAll(jsonBills);
			}
		}
		return allJsonBill;
	}

	/**
	 * @param bodyVOs
	 * @param saleOutHVO
	 * @param flag
	 * @param isReturnsale
	 * @param nowDate
	 * @return List<JsonBill>
	 */
	private List<JsonBill> change2SaleOutBatch(InvoiceBVO[] bodyVOs, SaleOutHVO saleOutHVO, boolean isLingshou,
			boolean isReturnsale, String nowDate) {
		List<JsonBill> listJsonBills = new ArrayList<>();
		if (MMArrayUtil.isNotEmpty(bodyVOs)) {
			SaleOutBVO saleOutBVO = null;
			Map<String, List<SaleOutBVO>> mapList = new HashMap<>();
			for (InvoiceBVO invoiceBVO : bodyVOs) {
				saleOutBVO = new SaleOutBVO();
				Long services = invoiceBVO.getServices();
				if (services == 1L) {
					continue;
				}
				BigDecimal noutnum = invoiceBVO.getNoutnum();
				if (isReturnsale && MMNumberUtil.isEqualZero(noutnum)) {
					continue;
				}

				saleOutBVO.setCmaterial(invoiceBVO.getCmaterial());// 物料
				saleOutBVO.setMaterialcode(invoiceBVO.getMaterialcode());
				saleOutBVO.setMaterialspec(invoiceBVO.getMaterialspec());
				saleOutBVO.setMaterialtype(invoiceBVO.getMaterialtype());
				saleOutBVO.setCastunitid(invoiceBVO.getCastunitid());// 辅单位
				saleOutBVO.setCunitid(invoiceBVO.getCunitid());
				saleOutBVO.setVsrcid(invoiceBVO.getHid());
				saleOutBVO.setVsrcbid(invoiceBVO.getId());
				saleOutBVO.setVbatchcode(invoiceBVO.getSizecode());
				saleOutBVO.setNshouldassistnum(invoiceBVO.getNastnum());
				saleOutBVO.setNshouldnum(invoiceBVO.getNnum());
				saleOutBVO.setVorderbid(invoiceBVO.getVsrcbid());
				saleOutBVO.setVorderhid(invoiceBVO.getVsrcid());
				saleOutBVO.setVtransrate(invoiceBVO.getVtransrate());
				saleOutBVO.setNmny(invoiceBVO.getNmny());
				saleOutBVO.setNprice(invoiceBVO.getNprice());
				saleOutBVO.setVbdef10(invoiceBVO.getGift().toString());// 赠品
				if (isLingshou) {
					saleOutBVO.setNassistnum(invoiceBVO.getNastnum());
					saleOutBVO.setNnum(invoiceBVO.getNnum());
					saleOutBVO.setDbizdate(nowDate);
				} else if (isReturnsale) {
					saleOutBVO.setNassistnum(MMNumberUtil.subtract(BigDecimal.ZERO, invoiceBVO.getNoutnum()));
					saleOutBVO.setNnum(
							new BigDecimal(invoiceBVO.getVbdef9() == null ? "0" : "-" + invoiceBVO.getVbdef9()));
					saleOutBVO.setDbizdate(nowDate);
				}

				String delwarehouse = invoiceBVO.getDelwarehouse();
				List<SaleOutBVO> list = mapList.get(delwarehouse);
				if (MMCollectionUtil.isNotEmpty(list)) {
					list.add(saleOutBVO);
				} else {
					List<SaleOutBVO> listBVOs = new ArrayList<>();
					listBVOs.add(saleOutBVO);
					mapList.put(delwarehouse, listBVOs);
				}
			}

			Set<String> keySet = mapList.keySet();
			JsonBill jsonBill = null;
			for (String key : keySet) {
				jsonBill = new JsonBill();
				SaleOutHVO newHVO = new SaleOutHVO();
				BeanUtils.copyProperties(saleOutHVO, newHVO);
				newHVO.setCwarehouseid(key);
				List<SaleOutBVO> listBodys = mapList.get(key);
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
	 * @return
	 */
	private SaleOutHVO change2SaleOutHVO(InvoiceHVO headVO, String nowDate) {
		SaleOutHVO saleOutHVO = new SaleOutHVO();
		saleOutHVO.setCbilltype("1001A11000000000JY6O");
		saleOutHVO.setVbilltype("4C-Cxx-002");
		saleOutHVO.setVbillstatus(BillStatus.FREE);
		saleOutHVO.setDbilldate(nowDate);// 单据日期
		saleOutHVO.setVsrcid(headVO.getId());
		saleOutHVO.setVsrccode(headVO.getVbillcode());
		saleOutHVO.setCdept(headVO.getCdept());
		saleOutHVO.setSalesman(headVO.getSalesman());
		saleOutHVO.setClient(headVO.getClient());
		saleOutHVO.setAddress(headVO.getAddress());
		saleOutHVO.setTel(headVO.getTel());
		saleOutHVO.setMemo(headVO.getMemo());
		saleOutHVO.setVorderbillcode(headVO.getVorderbillcode());
		saleOutHVO.setEffectbillcode(headVO.getEffectbillcode());
		saleOutHVO.setReturnsale(headVO.getReturnsale());
		saleOutHVO.setVinvoicebillcode(headVO.getVbillcode());
		saleOutHVO.setCdept(headVO.getCdept());
		saleOutHVO.setSalesman(headVO.getSalesman());
		saleOutHVO.setVorderhid(headVO.getVsrcid());
		saleOutHVO.setVdef10(headVO.getVsrcbilltype());
		return saleOutHVO;
	}

}
