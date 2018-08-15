package com.fgc.service.order.impl.excel.change;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.mapper.CurrtypeVOMapper;
import com.fgc.mapper.CustomerVOMapper;
import com.fgc.mapper.DeptVOMapper;
import com.fgc.mapper.MaterialVOMapper;
import com.fgc.mapper.PsndocVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.mapper.UserVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.BilltypeVOExample;
import com.fgc.pojo.BilltypeVOExample.Criteria;
import com.fgc.pojo.CurrtypeVO;
import com.fgc.pojo.CurrtypeVOExample;
import com.fgc.pojo.CustomerVO;
import com.fgc.pojo.CustomerVOExample;
import com.fgc.pojo.DeptVO;
import com.fgc.pojo.DeptVOExample;
import com.fgc.pojo.MaterialVO;
import com.fgc.pojo.MaterialVOExample;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.PsndocVO;
import com.fgc.pojo.PsndocVOExample;
import com.fgc.pojo.StordocVO;
import com.fgc.pojo.StordocVOExample;
import com.fgc.pojo.UserVO;
import com.fgc.pojo.UserVOExample;
import com.fgc.pojo.util.OrderImportOldVO;
import com.fgc.service.adjustrate.IAdjustrateService;
import com.pub.utils.BillStatus;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
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
public class ImportVOChange2OrderOldVO {

	/**
	 * @param listVOs
	 */
	public List<JsonBill> change2OrderVO(List<OrderImportOldVO> listVOs) throws Exception {
		Map<String, List<OrderImportOldVO>> mapData = new HashMap<>();
		if (MMCollectionUtil.isNotEmpty(listVOs)) {
			for (OrderImportOldVO orderImportVO : listVOs) {
				String hid = orderImportVO.getHid();
				List<OrderImportOldVO> list = mapData.get(hid);
				if (MMCollectionUtil.isNotEmpty(list)) {
					list.add(orderImportVO);
				} else {
					list = new ArrayList<>();
					list.add(orderImportVO);
					mapData.put(hid, list);
				}
			}
		}

		Set<String> keySet = mapData.keySet();
		List<JsonBill> listJsonBill = new ArrayList<>();

		List<String> errorMsg = new ArrayList<>();
		for (String key : keySet) {
			List<OrderImportOldVO> list = mapData.get(key);
			for (OrderImportOldVO orderImportVO : list) {
				// 单价类型
				String vbilltype = orderImportVO.getVbilltype();
				this.transBilltype(orderImportVO, vbilltype, errorMsg);
				// 客户
				String customer = orderImportVO.getCustomer();
				this.transCustomer(orderImportVO, customer, errorMsg);
				// 业务员
				String salesman = orderImportVO.getSalesman();
				this.transSalesman(orderImportVO, salesman, errorMsg);
				// 部门
				String cdept = orderImportVO.getCdept();
				this.transCdept(orderImportVO, cdept, errorMsg);
				// 币种
				String currency = orderImportVO.getCurrency();
				this.transCurrency(orderImportVO, currency, errorMsg);
				// 物料
				String cmaterial = orderImportVO.getCmaterial();
				this.transCmaterial(orderImportVO, cmaterial, errorMsg);
				// 发货仓库
				String delwarehouse = orderImportVO.getDelwarehouse();
				this.transWarehouse(orderImportVO, delwarehouse, errorMsg);

				this.transUser(orderImportVO, errorMsg);
			}

			if (MMCollectionUtil.isNotEmpty(errorMsg)) {
				throw new RuntimeException(errorMsg.toString());
			}

			OrderHVO hvo = new OrderHVO();
			OrderImportOldVO orderImportVO = list.get(0);
			hvo.setId(orderImportVO.getHid());
			hvo.setVbillcode(orderImportVO.getVbillcode());
			hvo.setCbilltype(orderImportVO.getCbilltype());
			hvo.setDbilldate(orderImportVO.getDbilldate());
			hvo.setCustomer(orderImportVO.getCustomer());
			hvo.setSalesman(orderImportVO.getSalesman());
			hvo.setCdept(orderImportVO.getCdept());
			hvo.setCurrency(orderImportVO.getCurrency());

			hvo.setNexchangerate(new BigDecimal(orderImportVO.getHuilv() == null ? "0" : orderImportVO.getHuilv()));

			hvo.setNreceivedmny(new BigDecimal(orderImportVO.getShijishoukuanjine()));
			hvo.setClient(orderImportVO.getClient());
			hvo.setAddress(orderImportVO.getAddress());
			hvo.setTel(orderImportVO.getTel());
			hvo.setEffectbillcode(orderImportVO.getEffectbillcode());
			hvo.setBillmaker(orderImportVO.getZhidanren());
			hvo.setBillmaketime(orderImportVO.getZhidantime());
			hvo.setApprover(orderImportVO.getShenheren());
			hvo.setApprovetime(orderImportVO.getShenhetime());
			hvo.setCbalatype("0001Z0100000000000XZ");
			hvo.setDr(MMNCUtils.getDR(0));
			hvo.setTs(MMNCUtils.getNowTime());
			hvo.setVbillstatus(BillStatus.APPROVED);
			hvo.setIssync((short) 1);

			List<OrderBVO> listBVOs = new ArrayList<>();
			for (OrderImportOldVO bodyImportVO : list) {
				OrderBVO bvo = new OrderBVO();
				bvo.setHid(bodyImportVO.getHid());
				bvo.setId(bodyImportVO.getBid());
				bvo.setCmaterial(bodyImportVO.getCmaterial());
				bvo.setMaterialcode(bodyImportVO.getMaterialcode());
				bvo.setMaterialspec(bodyImportVO.getMaterialspec());
				bvo.setMaterialtype(bodyImportVO.getMaterialtype());
				bvo.setMeasrate(bodyImportVO.getMeasrate());
				bvo.setCsaleunitid(bodyImportVO.getCsaleunitid());
				bvo.setCastunitid(bodyImportVO.getCastunitid());
				bvo.setCunitid(bodyImportVO.getCunitid());
				bvo.setServices(bodyImportVO.getServices());
				bvo.setVunitratio(bodyImportVO.getVunitratio());
				bvo.setDelwarehouse(bodyImportVO.getDelwarehouse());
				bvo.setDelwarehousecode(bodyImportVO.getDelwarehousecode());
				bvo.setNastnum(new BigDecimal(bodyImportVO.getNastnum() == null ? "0" : bodyImportVO.getNastnum()));
				bvo.setNnum(new BigDecimal(bodyImportVO.getNnum() == null ? "0" : bodyImportVO.getNnum()));
				bvo.setNprice(new BigDecimal(bodyImportVO.getNprice() == null ? "0" : bodyImportVO.getNprice()));
				bvo.setNmny(new BigDecimal(bodyImportVO.getNmny() == null ? "0" : bodyImportVO.getNmny()));
				bvo.setDr(MMNCUtils.getDR(0));
				bvo.setTs(MMNCUtils.getNowTime());
				bvo.setIssync((short) 1);
				bvo.setNinvoicenastnum(new BigDecimal(bodyImportVO.getLeijikaipiaonum()));

				this.calData(bvo);

				listBVOs.add(bvo);
			}
			JsonBill jsonBill = new JsonBill();
			jsonBill.setHead(JsonUtils.objectToJson(hvo));
			jsonBill.setInsertBodys(JsonUtils.objectToJson(listBVOs));

			listJsonBill.add(jsonBill);
		}
		return listJsonBill;
	}

	private void calData(OrderBVO bvo) throws Exception {
		String vunitratio = bvo.getVunitratio();
		if (MMStringUtil.isNotEmpty(vunitratio)) {
			String[] splitVunitratio = vunitratio.split("/");
			BigDecimal divideVunitratio = MMNumberUtil.divide(new BigDecimal(splitVunitratio[0]),
					new BigDecimal(splitVunitratio[1]));
			bvo.setSalenum(MMNumberUtil.multiply(bvo.getNastnum(), divideVunitratio));
			BigDecimal nmny = bvo.getNmny();
			if (MMNumberUtil.isNotNullAndNotZero(nmny)) {
				bvo.setNsaleprice(MMNumberUtil.divide(nmny, bvo.getSalenum()));
			}
		}
		String measrate = bvo.getMeasrate();
		if (MMStringUtil.isNotEmpty(measrate)) {
			String[] splitMeasrate = measrate.split("/");
			BigDecimal divideMeasrate = MMNumberUtil.divide(new BigDecimal(splitMeasrate[0]),
					new BigDecimal(splitMeasrate[1]));
			bvo.setNinvoicenum(MMNumberUtil.multiply(bvo.getNinvoicenastnum(), divideMeasrate));
			if (MMStringUtil.isNotEmpty(vunitratio)) {
				String[] splitVunitratio = vunitratio.split("/");
				BigDecimal divideVunitratio = MMNumberUtil.divide(new BigDecimal(splitVunitratio[0]),
						new BigDecimal(splitVunitratio[1]));
				bvo.setNinvoicesalenum(MMNumberUtil.multiply(bvo.getNinvoicenastnum(), divideVunitratio));
				bvo.setNinvoicemny(MMNumberUtil.multiply(bvo.getNinvoicenastnum(), bvo.getNprice()));
			}
		}
	}

	@Autowired
	private UserVOMapper userVOMapper;

	private Map<String, String> mapUser = new HashMap<>();

	/**
	 * @param orderImportVO
	 * @param errorMsg
	 */
	private void transUser(OrderImportOldVO orderImportVO, List<String> errorMsg) {
		List<String> listUserid = new ArrayList<>();
		String zhidanren = orderImportVO.getZhidanren();
		if (MMStringUtil.isNotEmpty(zhidanren)) {
			String value = mapUser.get(zhidanren);
			if (MMStringUtil.isNotEmpty(value)) {
				orderImportVO.setZhidanren(value);
			} else {
				listUserid.add(zhidanren);
			}
		}
		String shenheren = orderImportVO.getShenheren();
		if (MMStringUtil.isNotEmpty(shenheren)) {
			String value = mapUser.get(shenheren);
			if (MMStringUtil.isNotEmpty(value)) {
				orderImportVO.setShenheren(value);
			} else {
				listUserid.add(shenheren);
			}
		}
		if (MMCollectionUtil.isNotEmpty(listUserid)) {
			UserVOExample example = new UserVOExample();
			com.fgc.pojo.UserVOExample.Criteria criteria = example.createCriteria();
			criteria.andUsernameIn(listUserid);
			List<UserVO> listUserVOs = userVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listUserVOs)) {
				for (UserVO userVO : listUserVOs) {
					mapUser.put(userVO.getUsername(), userVO.getCuserid());
					if (MMStringUtil.isEqual(orderImportVO.getZhidanren(), userVO.getUsername())) {
						orderImportVO.setZhidanren(userVO.getCuserid());
					}
					if (MMStringUtil.isEqual(orderImportVO.getShenheren(), userVO.getUsername())) {
						orderImportVO.setShenheren(userVO.getCuserid());
					}
				}
			}
		}
	}

	@Autowired
	private DeptVOMapper deptVOMapper;

	/**
	 * @param orderImportVO
	 * @param cdept
	 * @param errorMsg
	 */
	private void transCdept(OrderImportOldVO orderImportVO, String value, List<String> errorMsg) {
		if (MMStringUtil.isNotEmpty(value)) {
			String cdept = mapCdept.get(value);
			if (MMStringUtil.isEmpty(cdept)) {
				DeptVOExample example = new DeptVOExample();
				com.fgc.pojo.DeptVOExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andNameEqualTo(value);
				List<DeptVO> list = deptVOMapper.selectByExample(example);
				if (MMCollectionUtil.isNotEmpty(list)) {
					cdept = list.get(0).getPkdept();
					mapCdept.put(value, cdept);
				}
			}
			orderImportVO.setCdept(cdept);
		}
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
	private void transWarehouse(OrderImportOldVO orderImportVO, String delwarehouse, List<String> errorMsg) {
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
	private void transCmaterial(OrderImportOldVO orderImportVO, String cmaterial, List<String> errorMsg) {
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
					vunitratio = listMaterialVOs.get(0).getVdef2() == null ? "1/1"
							: listMaterialVOs.get(0).getVdef2();
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
	private void transCurrency(OrderImportOldVO orderImportVO, String currency, List<String> errorMsg) {
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
//			BigDecimal nexchangerate = adjustrateService.selectByCurreny(value);
//			orderImportVO.setNexchangerate(nexchangerate);
//			orderImportVO.setCurrency(value);
		}
	}

	private Map<String, String> mapSalesman = new HashMap<>();

	@Autowired
	private PsndocVOMapper psndocVOMapper;

	private Map<String, String> mapCdept = new HashMap<>();

	/**
	 * @param orderImportVO
	 * @param salesman
	 * @param errorMsg
	 * @return String
	 */
	private void transSalesman(OrderImportOldVO orderImportVO, String salesman, List<String> errorMsg) {
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
	private void transCustomer(OrderImportOldVO orderImportVO, String customer, List<String> errorMsg) {
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
	private void transBilltype(OrderImportOldVO orderImportVO, String vbilltype, List<String> errorMsg) {
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
