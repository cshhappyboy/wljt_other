package com.fgc.service.bd.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.BalaTypeVOMapper;
import com.fgc.mapper.BankAccbasVOMapper;
import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.mapper.CashAccountVOMapper;
import com.fgc.mapper.CurrtypeVOMapper;
import com.fgc.mapper.CustomerVOMapper;
import com.fgc.mapper.DeptVOMapper;
import com.fgc.mapper.MaterialVOMapper;
import com.fgc.mapper.MeasdocVOMapper;
import com.fgc.mapper.PsndocVOMapper;
import com.fgc.mapper.StordocVOMapper;
import com.fgc.mapper.UserVOMapper;
import com.fgc.pojo.BalaTypeVO;
import com.fgc.pojo.BalaTypeVOExample;
import com.fgc.pojo.BankAccbasVO;
import com.fgc.pojo.BankAccbasVOExample;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.BilltypeVOExample;
import com.fgc.pojo.CashAccountVO;
import com.fgc.pojo.CashAccountVOExample;
import com.fgc.pojo.CurrtypeVO;
import com.fgc.pojo.CurrtypeVOExample;
import com.fgc.pojo.CustomerVO;
import com.fgc.pojo.CustomerVOExample;
import com.fgc.pojo.DeptVO;
import com.fgc.pojo.DeptVOExample;
import com.fgc.pojo.MaterialVO;
import com.fgc.pojo.MaterialVOExample;
import com.fgc.pojo.MeasdocVO;
import com.fgc.pojo.MeasdocVOExample;
import com.fgc.pojo.PsndocVO;
import com.fgc.pojo.PsndocVOExample;
import com.fgc.pojo.PsndocVOExample.Criteria;
import com.fgc.pojo.StordocVO;
import com.fgc.pojo.StordocVOExample;
import com.fgc.pojo.UserVO;
import com.fgc.pojo.UserVOExample;
import com.fgc.pojo.WhstransBVO;
import com.pub.model.Local;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * id翻译为名称工具类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月5日
 *
 *     未来离线需求
 */
@Service
public class IDTrans2NameUtils {

	@Autowired
	private BankAccbasVOMapper bankAccbasVOMapper;

	@Autowired
	private CashAccountVOMapper cashAccountVOMapper;

	@Autowired
	private StordocVOMapper stordocVOMapper;

	@Autowired
	private BalaTypeVOMapper balaTypeVOMapper;

	@Autowired
	private PsndocVOMapper psndocVOMapper;

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Autowired
	private CustomerVOMapper customerVOMapper;

	@Autowired
	private CurrtypeVOMapper currtypeVOMapper;

	@Autowired
	private DeptVOMapper deptVOMapper;

	@Autowired
	private UserVOMapper userVOMapper;

	/**
	 * @param list
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void transHVO(Class<?> clazz, List<?> list, String local) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Set<String> billtype = new HashSet<>();
		Map<String, String> mapBilltype = new HashMap<>();

		Set<String> customer = new HashSet<>();
		Map<String, String> mapCustomer = new HashMap<>();

		Set<String> currency = new HashSet<>();
		Map<String, String> mapCurrency = new HashMap<>();

		Set<String> cdept = new HashSet<>();
		Map<String, String> mapCdept = new HashMap<>();

		Set<String> cuserid = new HashSet<>();
		Map<String, String> mapCuserid = new HashMap<>();

		Set<String> psndoc = new HashSet<>();
		Map<String, String> mapPsndoc = new HashMap<>();

		Set<String> balaType = new HashSet<>();
		Map<String, String> mapBalaType = new HashMap<>();

		Set<String> stordoc = new HashSet<>();
		Map<String, String> mapStordoc = new HashMap<>();

		Set<String> cashAccount = new HashSet<>();
		Map<String, String> mapCashAccount = new HashMap<>();

		Set<String> bank = new HashSet<>();
		Map<String, String> mapBank = new HashMap<>();

		if (MMCollectionUtil.isNotEmpty(list)) {
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (method.getName().equals("getCbilltype") || method.getName().equals("getVsrcbilltype")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							billtype.add(str);
						}
					}
				} else if (method.getName().equals("getCustomer")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							customer.add(str);
						}
					}
				} else if (method.getName().equals("getCurrency")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							currency.add(str);
						}
					}
				} else if (method.getName().equals("getCdept") || method.getName().equals("getCdptid")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							cdept.add(str);
						}
					}
				} else if (method.getName().equals("getSalesman") || method.getName().equals("getCbizid")
						|| method.getName().equals("getCotherbizid")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							psndoc.add(str);
						}
					}
				} else if (method.getName().equals("getCbalatype")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							balaType.add(str);
						}
					}
				} else if (method.getName().equals("getBillmaker") || method.getName().equals("getModifier")
						|| method.getName().equals("getApprover") || method.getName().equals("getReviser")||method.getName().equals("getSohbillmaker")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							String[] split = str.split(",");
							if (MMStringUtil.isNotEmpty(split[0])) {
								cuserid.add(split[0]);
							}
							if (split.length > 1 && MMStringUtil.isNotEmpty(split[1])) {
								cuserid.add(split[1]);
							}

						}
					}
				} else if (method.getName().equals("getCwarehouseid") || method.getName().equals("getCotherwhid")
						|| method.getName().equals("getCoutwarehouseid")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							stordoc.add(str);
						}
					}
				} else if (method.getName().equals("getCashaccount")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							cashAccount.add(str);
						}
					}
				} else if (method.getName().equals("getCbankid")) {
					for (Object obj : list) {
						String str = (String) method.invoke(obj);
						if (MMStringUtil.isNotEmpty(str)) {
							bank.add(str);
						}
					}
				}
			}

			// 翻译单据类型
			if (billtype.size() > 0) {
				BilltypeVOExample example = new BilltypeVOExample();
				com.fgc.pojo.BilltypeVOExample.Criteria criteria = example.createCriteria();
				criteria.andPkbilltypeidIn(MMCollectionUtil.toList(billtype));
				List<BilltypeVO> listBilltypeVOs = billtypeVOMapper.selectByExample(example);
				for (BilltypeVO billtypeVO : listBilltypeVOs) {
					if (MMStringUtil.isEqual(Local.CH, local)) {
						mapBilltype.put(billtypeVO.getPkbilltypeid(), billtypeVO.getBilltypename());
					} else if (MMStringUtil.isEqual(Local.EN, local)) {
						mapBilltype.put(billtypeVO.getPkbilltypeid(), billtypeVO.getVdef10());
					} else if (MMStringUtil.isEqual(Local.FR, local)) {
						mapBilltype.put(billtypeVO.getPkbilltypeid(), billtypeVO.getVdef11());
					} else if (MMStringUtil.isEqual(Local.MJ, local)) {
						mapBilltype.put(billtypeVO.getPkbilltypeid(), billtypeVO.getVdef12());
					}
				}
			}
			if (customer.size() > 0) {
				CustomerVOExample customerVOExample = new CustomerVOExample();
				com.fgc.pojo.CustomerVOExample.Criteria customerCriteria = customerVOExample.createCriteria();
				customerCriteria.andPkcustomerIn(MMCollectionUtil.toList(customer));
				List<CustomerVO> listCustomerVOs = customerVOMapper.selectByExample(customerVOExample);
				for (CustomerVO customerVO : listCustomerVOs) {
					mapCustomer.put(customerVO.getPkcustomer(), customerVO.getName());
				}
			}
			if (currency.size() > 0) {
				CurrtypeVOExample currtypeVOExample = new CurrtypeVOExample();
				com.fgc.pojo.CurrtypeVOExample.Criteria currtypeCriteria = currtypeVOExample.createCriteria();
				currtypeCriteria.andPkcurrtypeIn(MMCollectionUtil.toList(currency));
				List<CurrtypeVO> listCurrtypeVOs = currtypeVOMapper.selectByExample(currtypeVOExample);
				for (CurrtypeVO currtypeVO : listCurrtypeVOs) {
					if (MMStringUtil.isEqual(Local.CH, local)) {
						mapCurrency.put(currtypeVO.getPkcurrtype(), currtypeVO.getName());
					} else {
						mapCurrency.put(currtypeVO.getPkcurrtype(), currtypeVO.getCurrtypesign());
					}
				}
			}
			if (psndoc.size() > 0) {
				PsndocVOExample psndocVOExample = new PsndocVOExample();
				Criteria psndocVOCriteria = psndocVOExample.createCriteria();
				psndocVOCriteria.andPkpsndocIn(MMCollectionUtil.toList(psndoc));
				List<PsndocVO> listPsndocVOs = psndocVOMapper.selectByExample(psndocVOExample);
				for (PsndocVO psndocVO : listPsndocVOs) {
					mapPsndoc.put(psndocVO.getPkpsndoc(), psndocVO.getName());
				}
			}

			if (cdept.size() > 0) {
				DeptVOExample deptVOExample = new DeptVOExample();
				com.fgc.pojo.DeptVOExample.Criteria deptVOCriteria = deptVOExample.createCriteria();
				deptVOCriteria.andPkdeptIn(MMCollectionUtil.toList(cdept));
				List<DeptVO> listDeptVOs = deptVOMapper.selectByExample(deptVOExample);
				for (DeptVO deptVO : listDeptVOs) {
					mapCdept.put(deptVO.getPkdept(), deptVO.getName());
				}
			}

			if (balaType.size() > 0) {
				BalaTypeVOExample balaTypeVOExample = new BalaTypeVOExample();
				com.fgc.pojo.BalaTypeVOExample.Criteria balaTypeCriteria = balaTypeVOExample.createCriteria();
				balaTypeCriteria.andPkbalatypeIn(MMCollectionUtil.toList(balaType));
				List<BalaTypeVO> listBalaTypeVOs = balaTypeVOMapper.selectByExample(balaTypeVOExample);
				for (BalaTypeVO balaTypeVO : listBalaTypeVOs) {
					if (MMStringUtil.isEqual(Local.CH, local)) {
						mapBalaType.put(balaTypeVO.getPkbalatype(), balaTypeVO.getName());
					} else if (MMStringUtil.isEqual(Local.EN, local)) {
						mapBalaType.put(balaTypeVO.getPkbalatype(), balaTypeVO.getVdef10());
					} else if (MMStringUtil.isEqual(Local.FR, local)) {
						mapBalaType.put(balaTypeVO.getPkbalatype(), balaTypeVO.getVdef11());
					} else if (MMStringUtil.isEqual(Local.MJ, local)) {
						mapBalaType.put(balaTypeVO.getPkbalatype(), balaTypeVO.getVdef12());
					}
				}
			}

			if (cuserid.size() > 0) {
				UserVOExample userVOExample = new UserVOExample();
				com.fgc.pojo.UserVOExample.Criteria userCriteria = userVOExample.createCriteria();
				userCriteria.andCuseridIn(MMCollectionUtil.toList(cuserid));
				List<UserVO> listUserVOs = userVOMapper.selectByExample(userVOExample);
				for (UserVO userVO : listUserVOs) {
					mapCuserid.put(userVO.getCuserid(), userVO.getUsername());
				}
			}
			if (stordoc.size() > 0) {
				StordocVOExample stordocVOExample = new StordocVOExample();
				com.fgc.pojo.StordocVOExample.Criteria stordocCriteria = stordocVOExample.createCriteria();
				stordocCriteria.andPkstordocIn(MMCollectionUtil.toList(stordoc));
				List<StordocVO> listStordocVOs = stordocVOMapper.selectByExample(stordocVOExample);
				for (StordocVO stordocVO : listStordocVOs) {
					mapStordoc.put(stordocVO.getPkstordoc(), stordocVO.getName());
				}
			}
			if (cashAccount.size() > 0) {
				CashAccountVOExample cashAccountExample = new CashAccountVOExample();
				com.fgc.pojo.CashAccountVOExample.Criteria cashAccountCriteria = cashAccountExample.createCriteria();
				cashAccountCriteria.andPkcashaccountIn(MMCollectionUtil.toList(cashAccount));
				List<CashAccountVO> listCashAccountVOs = cashAccountVOMapper.selectByExample(cashAccountExample);
				for (CashAccountVO cashAccountVO : listCashAccountVOs) {
					mapCashAccount.put(cashAccountVO.getPkcashaccount(), cashAccountVO.getName());
				}
			}
			if (bank.size() > 0) {
				BankAccbasVOExample bankAccbasVOExample = new BankAccbasVOExample();
				com.fgc.pojo.BankAccbasVOExample.Criteria bankCriteria = bankAccbasVOExample.createCriteria();
				bankCriteria.andPkbankaccbasIn(MMCollectionUtil.toList(bank));
				List<BankAccbasVO> listBankAccbasVOs = bankAccbasVOMapper.selectByExample(bankAccbasVOExample);
				for (BankAccbasVO bankAccbasVO : listBankAccbasVOs) {
					mapBank.put(bankAccbasVO.getPkbankaccbas(), bankAccbasVO.getName());
				}
			}

			for (Method method : methods) {
				if (method.getName().equals("setCbilltype") || method.getName().equals("setVsrcbilltype")) {
					for (Object obj : list) {
						Method cMethod = null;
						if (method.getName().equals("setCbilltype")) {
							cMethod = clazz.getMethod("getCbilltype");
						} else {
							cMethod = clazz.getMethod("getVsrcbilltype");
						}
						method.invoke(obj, mapBilltype.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCustomer")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getCustomer");
						method.invoke(obj, mapCustomer.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCurrency")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getCurrency");
						method.invoke(obj, mapCurrency.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setSalesman") || method.getName().equals("setCbizid")
						|| method.getName().equals("setCotherbizid")) {
					for (Object obj : list) {
						Method cMethod = null;
						if (method.getName().equals("setSalesman")) {
							cMethod = clazz.getMethod("getSalesman");
						} else if (method.getName().equals("setCbizid")) {
							cMethod = clazz.getMethod("getCbizid");
						} else {
							cMethod = clazz.getMethod("getCotherbizid");
						}
						method.invoke(obj, mapPsndoc.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCdept") || method.getName().equals("setCdptid")) {
					for (Object obj : list) {
						Method cMethod = null;
						if (method.getName().equals("setCdept")) {
							cMethod = clazz.getMethod("getCdept");
						} else {
							cMethod = clazz.getMethod("getCdptid");
						}
						method.invoke(obj, mapCdept.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCbalatype")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getCbalatype");
						method.invoke(obj, mapBalaType.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setBillmaker")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getBillmaker");
						String str = (String) cMethod.invoke(obj);
						if (MMStringUtil.isEmpty(str)) {
							continue;
						}
						String[] split = str.split(",");
						StringBuilder sBuilder = new StringBuilder();
						if (MMStringUtil.isNotEmpty(split[0])) {
							sBuilder.append(mapCuserid.get(split[0]));
						}
						if (split.length > 1 && MMStringUtil.isNotEmpty(split[1])) {
							if (MMStringUtil.isNotEmpty(split[0])) {
								sBuilder.append(",");
							}
							sBuilder.append(mapCuserid.get(split[1]));
						}
						method.invoke(obj, sBuilder.toString());
					}
				} else if (method.getName().equals("setModifier")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getModifier");
						method.invoke(obj, mapCuserid.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setApprover")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getApprover");
						method.invoke(obj, mapCuserid.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setReviser")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getReviser");
						method.invoke(obj, mapCuserid.get(cMethod.invoke(obj)));
					}
				}else if(method.getName().equals("setSohbillmaker")){
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getSohbillmaker");
						method.invoke(obj, mapCuserid.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCwarehouseid") || method.getName().equals("setCotherwhid")
						|| method.getName().equals("setCoutwarehouseid")) {
					for (Object obj : list) {
						Method cMethod = null;
						if (method.getName().equals("setCwarehouseid")) {
							cMethod = clazz.getMethod("getCwarehouseid");
						} else if (method.getName().equals("setCotherwhid")) {
							cMethod = clazz.getMethod("getCotherwhid");
						} else {
							cMethod = clazz.getMethod("getCoutwarehouseid");
						}
						method.invoke(obj, mapStordoc.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCashaccount")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getCashaccount");
						method.invoke(obj, mapCashAccount.get(cMethod.invoke(obj)));
					}
				} else if (method.getName().equals("setCbankid")) {
					for (Object obj : list) {
						Method cMethod = clazz.getMethod("getCbankid");
						method.invoke(obj, mapBank.get(cMethod.invoke(obj)));
					}
				}
			}
		}
	}

	@Autowired
	private MaterialVOMapper materialVOMapper;

	@Autowired
	private MeasdocVOMapper measdocVOMapper;

	public void transBVO(Class<?> clazz, List<?> list, String local) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Set<String> cmaterial = new HashSet<>();
		Set<String> cunitid = new HashSet<>();

		Map<String, String> mapName = new HashMap<>();
		Map<String, String> mapFRName = new HashMap<>();

		Map<String, String> mapMeasdocName = new HashMap<>();

		if (MMCollectionUtil.isNotEmpty(list)) {
			for (Object obj : list) {
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.getName().equals("getCmaterial")) {
						String str = (String) method.invoke(obj);
						cmaterial.add(str);
					}
					if (method.getName().equals("getCastunitid")) {
						String str = (String) method.invoke(obj);
						cunitid.add(str);
					}
					if (method.getName().equals("getCsaleunitid")) {
						String str = (String) method.invoke(obj);
						cunitid.add(str);
					}
					if (method.getName().equals("getCunitid")) {
						String str = (String) method.invoke(obj);
						cunitid.add(str);
					}
				}
			}
			MaterialVOExample materialVOExample = new MaterialVOExample();
			com.fgc.pojo.MaterialVOExample.Criteria mCriteria = materialVOExample.createCriteria();
			mCriteria.andPkmaterialIn(MMCollectionUtil.toList(cmaterial));
			List<MaterialVO> listMaterialVOs = materialVOMapper.selectByExample(materialVOExample);
			for (MaterialVO materialVO : listMaterialVOs) {
				mapFRName.put(materialVO.getCode(), materialVO.getMaterialshortname());
				if (MMStringUtil.isEqual(local, Local.CH)) {
					mapName.put(materialVO.getCode(), materialVO.getName());
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					mapName.put(materialVO.getCode(), materialVO.getEname());
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					mapName.put(materialVO.getCode(), materialVO.getMaterialshortname());
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					mapName.put(materialVO.getCode(), materialVO.getMaterialmnecode());
				}
			}
			MeasdocVOExample measdocVOExample = new MeasdocVOExample();
			com.fgc.pojo.MeasdocVOExample.Criteria createCriteria = measdocVOExample.createCriteria();
			createCriteria.andPkmeasdocIn(MMCollectionUtil.toList(cunitid));
			List<MeasdocVO> listMeasdocVOs = measdocVOMapper.selectByExample(measdocVOExample);
			for (MeasdocVO measdocVO : listMeasdocVOs) {
				mapMeasdocName.put(measdocVO.getPkmeasdoc(), measdocVO.getName());
			}

			for (Object obj : list) {
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					if (method.getName().equals("setMaterialname")) {
						Method cMethod = clazz.getMethod("getMaterialcode");
						method.invoke(obj, mapName.get(cMethod.invoke(obj)));
					}
					if (obj instanceof WhstransBVO) {
						if (method.getName().equals("setVbdef1")) {
							Method cMethod = clazz.getMethod("getMaterialcode");
							method.invoke(obj, mapFRName.get(cMethod.invoke(obj)));
						}
					}
					if (method.getName().equals("setCastunitid")) {
						Method cMethod = clazz.getMethod("getCastunitid");
						method.invoke(obj, mapMeasdocName.get(cMethod.invoke(obj)));
					}
					if (method.getName().equals("setCsaleunitid")) {
						Method cMethod = clazz.getMethod("getCsaleunitid");
						method.invoke(obj, mapMeasdocName.get(cMethod.invoke(obj)));
					}
					if (method.getName().equals("setCunitid")) {
						Method cMethod = clazz.getMethod("getCunitid");
						method.invoke(obj, mapMeasdocName.get(cMethod.invoke(obj)));
					}
				}
			}
		}
	}
}
