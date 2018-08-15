package com.fgc.service.order.impl.excel.change;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.mapper.CurrtypeVOMapper;
import com.fgc.mapper.CustomerVOMapper;
import com.fgc.mapper.MaterialVOMapper;
import com.fgc.mapper.PsndocVOMapper;
import com.fgc.mapper.PsnjobVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.BilltypeVOExample;
import com.fgc.pojo.BilltypeVOExample.Criteria;
import com.fgc.pojo.CurrtypeVO;
import com.fgc.pojo.CurrtypeVOExample;
import com.fgc.pojo.CustomerVO;
import com.fgc.pojo.CustomerVOExample;
import com.fgc.pojo.MaterialVO;
import com.fgc.pojo.MaterialVOExample;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.PsndocVO;
import com.fgc.pojo.PsndocVOExample;
import com.fgc.pojo.PsnjobVO;
import com.fgc.pojo.PsnjobVOExample;
import com.fgc.pojo.StordocVO;
import com.fgc.pojo.StordocVOExample;
import com.fgc.pojo.util.OrderImportVO;
import com.fgc.pojo.util.PubParam;
import com.fgc.service.adjustrate.IAdjustrateService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月23日
 *
 *     未来离线需求
 */
@Component
public class ImportVOChange2OrderVO {

	@Autowired
	private IPubInfoService pubInfoService;

	/**
	 * @param listVOs
	 * @param nowDate 
	 */
	public List<JsonBill> change2OrderVO(List<OrderImportVO> listVOs, String nowDate) throws Exception {
		Map<String, List<OrderImportVO>> mapData = new HashMap<>();
		if (MMCollectionUtil.isNotEmpty(listVOs)) {
			for (OrderImportVO orderImportVO : listVOs) {
				String vbillcode = orderImportVO.getVbillcode();
				List<OrderImportVO> list = mapData.get(vbillcode);
				if (MMCollectionUtil.isNotEmpty(list)) {
					list.add(orderImportVO);
				} else {
					list = new ArrayList<>();
					list.add(orderImportVO);
					mapData.put(vbillcode, list);
				}
			}
		}

		Set<String> keySet = mapData.keySet();
		List<JsonBill> listJsonBill = new ArrayList<>();

		List<String> errorMsg = new ArrayList<>();
		for (String key : keySet) {
			List<OrderImportVO> list = mapData.get(key);
			for (OrderImportVO orderImportVO : list) {
				// 单价类型
				String vbilltype = orderImportVO.getVbilltype();
				this.transBilltype(orderImportVO, vbilltype, errorMsg);
				// 客户
				String customer = orderImportVO.getCustomer();
				this.transCustomer(orderImportVO, customer, errorMsg);
				// 业务员
				String salesman = orderImportVO.getSalesman();
				this.transSalesman(orderImportVO, salesman, errorMsg);
				// 币种
				String currency = orderImportVO.getCurrency();
				this.transCurrency(orderImportVO, currency, errorMsg,nowDate);
				// 物料
				String cmaterial = orderImportVO.getCmaterial();
				this.transCmaterial(orderImportVO, cmaterial, errorMsg);
				// 发货仓库
				String delwarehouse = orderImportVO.getDelwarehouse();
				this.transWarehouse(orderImportVO, delwarehouse, errorMsg);
			}
			if (MMCollectionUtil.isNotEmpty(errorMsg)) {
				throw new RuntimeException(errorMsg.toString());
			}

			OrderHVO hvo = new OrderHVO();
			OrderImportVO orderImportVO = list.get(0);
			BeanUtils.copyProperties(orderImportVO, hvo);
			hvo.setCbalatype("0001Z0100000000000XZ");
			if (MMStringUtil.isEqual(hvo.getCbilltype(),
					pubInfoService.getValueByCode(PubParam.ORDER_GONGCHENG_BILLTYPE))
					&& MMStringUtil.isEmpty(hvo.getEffectbillcode())) {
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append("单据号为:[");
				sBuilder.append(hvo.getVbillcode());
				sBuilder.append("],批次号不能为空,请检查！");
				errorMsg.add(sBuilder.toString());
			}
			List<OrderBVO> listBVOs = new ArrayList<>();
			for (OrderImportVO bodyImportVO : list) {
				OrderBVO bvo = new OrderBVO();
				BeanUtils.copyProperties(bodyImportVO, bvo);
				BodyVODataCalculate.calData(bvo);
				listBVOs.add(bvo);
			}
			JsonBill jsonBill = new JsonBill();
			jsonBill.setHead(JsonUtils.objectToJson(hvo));
			jsonBill.setInsertBodys(JsonUtils.objectToJson(listBVOs));

			listJsonBill.add(jsonBill);
		}
		if (MMCollectionUtil.isNotEmpty(errorMsg)) {
			throw new RuntimeException(errorMsg.toString());
		}
		return listJsonBill;
	}

	private Map<String, String> mapWarehouse = new HashMap<>();

	private Map<String, String> mapWarehousecode = new HashMap<>();

	@Autowired
	private StordocVOMapper stordocVOMapper;

	/**
	 * @param orderImportVO
	 * @param delwarehouse
	 * @param errorMsg
	 */
	private void transWarehouse(OrderImportVO orderImportVO, String delwarehouse, List<String> errorMsg) {
		if (MMStringUtil.isNotEmpty(delwarehouse)) {
			String value = mapWarehouse.get(delwarehouse);
			String code = mapWarehousecode.get(delwarehouse);
			if (MMStringUtil.isEmpty(value)) {
				StordocVOExample example = new StordocVOExample();
				com.fgc.pojo.StordocVOExample.Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(delwarehouse);
				List<StordocVO> list = stordocVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(list)) {
					value = list.get(0).getPkstordoc();
					code = list.get(0).getName();
					mapWarehouse.put(delwarehouse, value);
					mapWarehousecode.put(delwarehouse, code);
				}
			}
			orderImportVO.setDelwarehouse(value);
			orderImportVO.setDelwarehousecode(code);
		}
	}

	private Map<String, String> mapCmaterial = new HashMap<>();
	// 编码
	private Map<String, String> mapCode = new HashMap<>();
	// 规格
	private Map<String, String> mapSpec = new HashMap<>();
	// 型号
	private Map<String, String> mapType = new HashMap<>();
	// 销售单位
	private Map<String, String> mapXiaoshouDW = new HashMap<>();
	// 销售单位与单位比例值
	private Map<String, String> mapVunitratio = new HashMap<>();
	// 主单位
	private Map<String, String> mapZhuDW = new HashMap<>();
	// 辅单位
	private Map<String, String> mapfuDW = new HashMap<>();
	// 主单位/辅单位
	private Map<String, String> mapMeasrate = new HashMap<>();
	// 服务类
	private Map<String, Long> mapServices = new HashMap<>();

	@Autowired
	private MaterialVOMapper materialVOMapper;

	/**
	 * @param orderImportVO
	 * @param cmaterial
	 * @param errorMsg
	 * @return String
	 */
	private void transCmaterial(OrderImportVO orderImportVO, String cmaterial, List<String> errorMsg) {
		if (MMStringUtil.isNotEmpty(cmaterial)) {
			String material = mapCmaterial.get(cmaterial);
			String spec = mapSpec.get(cmaterial);
			String type = mapType.get(cmaterial);
			String xiaoshouDW = mapXiaoshouDW.get(cmaterial);
			String vunitratio = mapVunitratio.get(cmaterial);
			String zhuDW = mapZhuDW.get(cmaterial);
			String fuDW = mapfuDW.get(cmaterial);
			String measrate = mapMeasrate.get(cmaterial);
			String code = mapCode.get(cmaterial);
			Long services = mapServices.get(cmaterial);
			if (MMStringUtil.isEmpty(material)) {
				MaterialVOExample example = new MaterialVOExample();
				com.fgc.pojo.MaterialVOExample.Criteria criteria = example.createCriteria();
				criteria.andCodeEqualTo(cmaterial);
				List<MaterialVO> listMaterialVOs = materialVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(listMaterialVOs)) {
					material = listMaterialVOs.get(0).getPkmaterial();
					xiaoshouDW = listMaterialVOs.get(0).getVdef1() == null ? listMaterialVOs.get(0).getFumeasdoc()
							: listMaterialVOs.get(0).getVdef1();
					vunitratio = listMaterialVOs.get(0).getVdef2() == null ? "1/1" : listMaterialVOs.get(0).getVdef2();
					type = listMaterialVOs.get(0).getMaterialtype();
					spec = listMaterialVOs.get(0).getVdef20();
					zhuDW = listMaterialVOs.get(0).getZhumeasdoc();
					fuDW = listMaterialVOs.get(0).getFumeasdoc();
					measrate = listMaterialVOs.get(0).getMeasrate();
					code = listMaterialVOs.get(0).getCode();
					services = Long.valueOf(listMaterialVOs.get(0).getFee().equals("N") ? "0" : "1");
					mapCmaterial.put(cmaterial, material);
					mapXiaoshouDW.put(cmaterial, xiaoshouDW);
					mapVunitratio.put(cmaterial, vunitratio);
					mapSpec.put(cmaterial, spec);
					mapType.put(cmaterial, type);
					mapZhuDW.put(cmaterial, zhuDW);
					mapfuDW.put(cmaterial, fuDW);
					mapMeasrate.put(cmaterial, measrate);
					mapCode.put(cmaterial, code);
					mapServices.put(cmaterial, services);
				} else {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号为:[");
					sBuilder.append(orderImportVO.getVbillcode());
					sBuilder.append("],物料编码为:[");
					sBuilder.append(cmaterial);
					sBuilder.append("]不存在,请检查！");
					errorMsg.add(sBuilder.toString());
				}
			}
			orderImportVO.setCmaterial(material);
			orderImportVO.setMaterialcode(code);
			orderImportVO.setMaterialspec(spec);
			orderImportVO.setMaterialtype(type);
			orderImportVO.setCsaleunitid(xiaoshouDW);
			orderImportVO.setVunitratio(vunitratio);
			orderImportVO.setCastunitid(fuDW);
			orderImportVO.setCunitid(zhuDW);
			orderImportVO.setMeasrate(measrate);
			orderImportVO.setServices(services);
		}
	}

	private Map<String, String> mapCurrency = new HashMap<>();

	@Autowired
	private CurrtypeVOMapper currtypeVOMapper;

	@Autowired
	private IAdjustrateService adjustrateService;

	/**
	 * @param orderImportVO
	 * @param currency
	 * @param errorMsg
	 * @return String
	 */
	private void transCurrency(OrderImportVO orderImportVO, String currency, List<String> errorMsg,String nowDate) {
		if (MMStringUtil.isNotEmpty(currency)) {
			String value = mapCurrency.get(currency);
			if (MMStringUtil.isEmpty(value)) {
				CurrtypeVOExample example = new CurrtypeVOExample();
				com.fgc.pojo.CurrtypeVOExample.Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(currency);
				List<CurrtypeVO> listCurrtypeVOs = currtypeVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(listCurrtypeVOs)) {
					value = listCurrtypeVOs.get(0).getPkcurrtype();
					mapCurrency.put(currency, value);
				} else {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号为:[");
					sBuilder.append(orderImportVO.getVbillcode());
					sBuilder.append("],币种为:[");
					sBuilder.append(currency);
					sBuilder.append("]不存在,请检查！");
					errorMsg.add(sBuilder.toString());
				}
			}
			BigDecimal nexchangerate = adjustrateService.selectByCurreny(value,nowDate);
			orderImportVO.setNexchangerate(nexchangerate);
			orderImportVO.setCurrency(value);
		}
	}

	private Map<String, String> mapSalesman = new HashMap<>();

	@Autowired
	private PsndocVOMapper psndocVOMapper;

	private Map<String, String> mapCdept = new HashMap<>();

	@Autowired
	private PsnjobVOMapper psnjobVOMapper;

	/**
	 * @param orderImportVO
	 * @param salesman
	 * @param errorMsg
	 * @return String
	 */
	private void transSalesman(OrderImportVO orderImportVO, String salesman, List<String> errorMsg) {
		if (MMStringUtil.isNotEmpty(salesman)) {
			String value = mapSalesman.get(salesman);
			if (MMStringUtil.isEmpty(value)) {
				PsndocVOExample example = new PsndocVOExample();
				com.fgc.pojo.PsndocVOExample.Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(salesman);
				List<PsndocVO> listPsndocVOs = psndocVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(listPsndocVOs)) {
					value = listPsndocVOs.get(0).getPkpsndoc();
					mapSalesman.put(salesman, value);
				} else {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号为:[");
					sBuilder.append(orderImportVO.getVbillcode());
					sBuilder.append("],业务员为:[");
					sBuilder.append(salesman);
					sBuilder.append("]不存在,请检查！");
					errorMsg.add(sBuilder.toString());
				}

			}
			orderImportVO.setSalesman(value);
			if (MMStringUtil.isNotEmpty(value)) {
				String cdept = mapCdept.get(value);
				if (MMStringUtil.isEmpty(cdept)) {
					PsnjobVOExample example = new PsnjobVOExample();
					com.fgc.pojo.PsnjobVOExample.Criteria criteria = example.createCriteria();
					criteria.andPkpsndocEqualTo(value);
					List<PsnjobVO> list = psnjobVOMapper.selectByExample(example);
					if (MMCollectionUtil.isNotEmpty(list)) {
						cdept = list.get(0).getPkdept();
						mapCdept.put(value, cdept);
					}
				}
				orderImportVO.setCdept(cdept);
			}
		}
	}

	private Map<String, String> mapCustomer = new HashMap<>();

	@Autowired
	private CustomerVOMapper customerVOMapper;

	/**
	 * @param orderImportVO
	 * @param customer
	 * @param errorMsg
	 * @return String
	 */
	private void transCustomer(OrderImportVO orderImportVO, String customer, List<String> errorMsg) {
		if (MMStringUtil.isNotEmpty(customer)) {
			String value = mapCustomer.get(customer);
			if (MMStringUtil.isEmpty(value)) {
				CustomerVOExample example = new CustomerVOExample();
				com.fgc.pojo.CustomerVOExample.Criteria criteria = example.createCriteria();
				criteria.andNameEqualTo(customer);
				List<CustomerVO> list = customerVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(list)) {
					String pkcustomer = list.get(0).getPkcustomer();
					mapCustomer.put(value, pkcustomer);
					value = pkcustomer;
				} else {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号为:[");
					sBuilder.append(orderImportVO.getVbillcode());
					sBuilder.append("],客户名称为:[");
					sBuilder.append(customer);
					sBuilder.append("]不存在,请检查！");
					errorMsg.add(sBuilder.toString());
				}
			}
			orderImportVO.setCustomer(value);
		}
	}

	private Map<String, String> mapBilltype = new HashMap<>();

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	/**
	 * @param orderImportVO
	 * @param vbilltype
	 * @param errorMsg
	 * @return
	 */
	private void transBilltype(OrderImportVO orderImportVO, String vbilltype, List<String> errorMsg) {
		if (MMStringUtil.isNotEmpty(vbilltype)) {
			String value = mapBilltype.get(vbilltype);
			if (MMStringUtil.isEmpty(value)) {
				BilltypeVOExample example = new BilltypeVOExample();
				Criteria criteria = example.createCriteria();
				criteria.andBilltypenameEqualTo(vbilltype);
				List<BilltypeVO> list = billtypeVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(list)) {
					String pkbilltypeid = list.get(0).getPkbilltypeid();
					mapBilltype.put(value, pkbilltypeid);
					value = pkbilltypeid;
				} else {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append("单据号为:[");
					sBuilder.append(orderImportVO.getVbillcode());
					sBuilder.append("],交易类型为:[");
					sBuilder.append(vbilltype);
					sBuilder.append("]不存在,请检查！");
					errorMsg.add(sBuilder.toString());
				}
			}
			orderImportVO.setCbilltype(value);
		}

	}

}
