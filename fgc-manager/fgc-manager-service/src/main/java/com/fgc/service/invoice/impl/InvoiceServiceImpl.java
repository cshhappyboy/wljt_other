package com.fgc.service.invoice.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.InvoiceBVOMapper;
import com.fgc.mapper.InvoiceHVOMapper;
import com.fgc.pojo.BillTypeFlag;
import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceBVOExample;
import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.InvoiceHVOExample;
import com.fgc.pojo.InvoiceHVOExample.Criteria;
import com.fgc.pojo.util.PubParam;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.invoice.InvoiceService;
import com.fgc.service.invoice.impl.rule.AfterInvoiceApproveRule;
import com.fgc.service.invoice.impl.rule.AfterInvoiceSaveRule;
import com.fgc.service.invoice.impl.rule.AfterInvoiceUnApproveRule;
import com.fgc.service.invoice.impl.rule.AfterInvoiceUpdateRule;
import com.fgc.service.invoice.impl.rule.BeforeInvoiceApproveChcekRule;
import com.fgc.service.invoice.impl.rule.BeforeInvoiceBodySaveRule;
import com.fgc.service.invoice.impl.rule.BeforeInvoiceBodyUpdateRule;
import com.fgc.service.invoice.impl.rule.BeforeInvoicePushSaleOutCheckOnhandRule;
import com.fgc.service.invoice.impl.rule.BeforeInvoiceSaveRule;
import com.fgc.service.invoice.impl.rule.BeforeInvoiceUpdateRule;
import com.fgc.service.invoice.impl.rule.BeforerInvoiceDeleteRule;
import com.fgc.service.invoice.impl.rule.INCheckCurrencyCashCountRule;
import com.fgc.service.invoice.impl.util.InvoiceChangeUtils;
import com.fgc.service.pub.IPubInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.model.SessionInfo;
import com.pub.utils.AggVO;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.IUParamVO;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;
import com.pub.utils.WebAppResult;

/**
 * 销售发票服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月30日
 *
 *     未来离线需求
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private InvoiceChangeUtils invoiceChangeUtils;

	@Autowired
	private BeforeInvoiceApproveChcekRule beforeInvoiceApproveChcekRule;

	@Autowired
	private INCheckCurrencyCashCountRule checkCurrencyCashCountRule;

	@Autowired
	private BeforeInvoicePushSaleOutCheckOnhandRule beforeInvoicePushSaleOutCheckOnhandRule;

	@Autowired
	private AfterInvoiceUnApproveRule afterInvoiceUnApproveRule;

	@Autowired
	private BeforeInvoiceBodySaveRule beforeInvoiceBodySaveRule;

	@Autowired
	private BeforeInvoiceBodyUpdateRule beforeInvoiceBodyUpdateRule;

	@Autowired
	private BeforeInvoiceUpdateRule beforeInvoiceUpdateRule;

	@Autowired
	private AfterInvoiceApproveRule afterInvoiceApproveRule;

	@Autowired
	private BeforerInvoiceDeleteRule beforerInvoiceDeleteRule;

	@Autowired
	private AfterInvoiceUpdateRule afterInvoiceUpdateRule;

	@Autowired
	private AfterInvoiceSaveRule afterInvoiceSaveRule;

	@Autowired
	private BeforeInvoiceSaveRule beforeInvoiceSaveRule;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private InvoiceHVOMapper invoiceHVOMapper;

	@Autowired
	private InvoiceBVOMapper invoiceBVOMapper;

	@Override
	public EUDataGridResult queryAllData(int page, int rows, InvoiceHVO hvo, SessionInfo sessionInfo) throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		InvoiceHVOExample hExample = new InvoiceHVOExample();
		hExample.setOrderByClause(" dbilldate desc ");
		hExample.setOrderByClause(" vbillcode desc ");
		Criteria hcriteria = hExample.createCriteria();
		hcriteria.andDrEqualTo(MMNCUtils.getDR(0));

		this.getWhereSql(hvo, hcriteria, sessionInfo);

		PageHelper.startPage(page, rows);

		List<InvoiceHVO> listInvoiceHVO = invoiceHVOMapper.selectByExample(hExample);
		PageInfo<InvoiceHVO> info = new PageInfo<>(listInvoiceHVO);

		trans2NameUtils.transHVO(InvoiceHVO.class, info.getList(), sessionInfo.getLocal());

		result.setRows(info.getList());
		result.setTotal(info.getTotal());

		return result;
	}

	/**
	 * 拼装查询条件
	 * 
	 * @param hvo
	 * @param hcriteria
	 * @param sessionInfo
	 */
	private void getWhereSql(InvoiceHVO hvo, Criteria hcriteria, SessionInfo sessionInfo) {
		Short issync = hvo.getIssync();
		if (MMValueUtils.isNotEmpty(issync) && issync != 2) {
			hcriteria.andIssyncEqualTo(issync);
		}
		// 销售发票号、
		String vbillcode = hvo.getVbillcode();
		if (MMStringUtil.isNotEmpty(vbillcode)) {
			hcriteria.andVbillcodeLike("%" + vbillcode + "%");
		}
		// 销售订单类型、
		String vsrcbilltype = hvo.getVsrcbilltype();
		if (MMStringUtil.isNotEmpty(vsrcbilltype)) {
			hcriteria.andVsrcbilltypeEqualTo(vsrcbilltype);
		}
		// 部门、
		String cdept = hvo.getCdept();
		List<String> dataDept = sessionInfo.getDataDept();
		if (MMCollectionUtil.isNotEmpty(dataDept)) {
			if (MMStringUtil.isNotEmpty(cdept)) {
				if (dataDept.contains(cdept)) {
					hcriteria.andCdeptEqualTo(cdept);
				} else {
					hcriteria.andCdeptEqualTo("###");
				}
			} else {
				hcriteria.andCdeptIn(dataDept);
			}
		} else {
			hcriteria.andCdeptEqualTo("###");
		}
		// 业务员、
		String salesman = hvo.getSalesman();
		if (MMStringUtil.isNotEmpty(salesman)) {
			hcriteria.andSalesmanEqualTo(salesman);
		}
		// 销售订单号、
		String vorderbillcode = hvo.getVorderbillcode();
		if (MMStringUtil.isNotEmpty(vorderbillcode)) {
			hcriteria.andVorderbillcodeLike("%" + vorderbillcode + "%");
		}
		// 有效订单号（支持批量输入、execl表拷贝、非空查询）、
		String effectbillcode_con = hvo.getEffectbillcode_con();
		if ("0".equals(effectbillcode_con) || "".equals(effectbillcode_con)) {
			String effectbillcode = hvo.getEffectbillcode();
			if (MMStringUtil.isNotEmpty(effectbillcode)) {
				String[] arrayEff = effectbillcode.split(",");
				if (MMArrayUtil.isNotEmpty(arrayEff)) {
					for (String eff : arrayEff) {
						hcriteria.andEffectbillcodeLike("%" + eff + "%");
					}
					// hcriteria.andEffectbillcodeIn(MMArrayUtil.toList(String.class,
					// arrayEff));
				}
			}
		} else {
			hcriteria.andEffectbillcodeIsNull();
		}
		// 累积收款金额（为零或空值查询）、
		BigDecimal ntotalrecemny = hvo.getNtotalrecemny();
		if (MMValueUtils.isNotEmpty(ntotalrecemny)) {
			hcriteria.andNtotalrecemnyEqualTo(ntotalrecemny);
		}
		// 单据日期、
		String dbilldatestart = hvo.getDbilldatestart();
		String dbilldateend = hvo.getDbilldateend();
		if (MMStringUtil.isNotEmpty(dbilldatestart) && MMStringUtil.isNotEmpty(dbilldateend)) {
			hcriteria.andDbilldateBetween(dbilldatestart, dbilldateend);
		}
		// 客户、
		String customer = hvo.getCustomer();
		if (MMStringUtil.isNotEmpty(customer)) {
			hcriteria.andCustomerEqualTo(customer);
		}
		// 单据状态、
		Long vbillstatus = hvo.getVbillstatus();
		if (MMValueUtils.isNotEmpty(vbillstatus)) {
			hcriteria.andVbillstatusEqualTo(vbillstatus);
		}
		// 制单人、
		String billmaker = hvo.getBillmaker();
		if (MMStringUtil.isNotEmpty(billmaker)) {
			hcriteria.andBillmakerEqualTo(billmaker);
		}
		// 审批人、
		String approver = hvo.getApprover();
		if (MMStringUtil.isNotEmpty(approver)) {
			hcriteria.andApproverEqualTo(approver);
		}
		// 客户联系人、
		String client = hvo.getClient();
		if (MMStringUtil.isNotEmpty(client)) {
			hcriteria.andClientEqualTo(client);
		}
		// 地址、
		String address = hvo.getAddress();
		if (MMStringUtil.isNotEmpty(address)) {
			hcriteria.andAddressEqualTo(address);
		}
		// 电话、
		String tel = hvo.getTel();
		if (MMStringUtil.isNotEmpty(tel)) {
			hcriteria.andTelEqualTo(tel);
		}
		// 备注、
		String memo = hvo.getMemo();
		if (MMStringUtil.isNotEmpty(memo)) {
			hcriteria.andMemoLike("%" + memo + "%");
		}
		// 物料、仓库
		String cmaterial = hvo.getCmaterial();
		String delwarehouse = hvo.getDelwarehouse();
		InvoiceBVOExample example = new InvoiceBVOExample();
		com.fgc.pojo.InvoiceBVOExample.Criteria criteria = example.createCriteria();
		if (MMStringUtil.isNotEmpty(cmaterial) || MMStringUtil.isNotEmpty(delwarehouse)) {
			if (MMStringUtil.isNotEmpty(cmaterial) && MMStringUtil.isNotEmpty(delwarehouse)) {
				criteria.andCmaterialEqualTo(cmaterial);
				criteria.andDelwarehouseEqualTo(delwarehouse);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
			} else if (MMStringUtil.isNotEmpty(cmaterial)) {
				criteria.andCmaterialEqualTo(cmaterial);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
			} else if (MMStringUtil.isNotEmpty(delwarehouse)) {
				criteria.andDelwarehouseEqualTo(delwarehouse);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
			}
			List<InvoiceBVO> listBVOs = invoiceBVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				Set<String> setStr = new HashSet<>();
				for (InvoiceBVO bvo : listBVOs) {
					String hid = bvo.getHid();
					setStr.add(hid);
				}
				hcriteria.andIdIn(MMCollectionUtil.toList(setStr));
			} else {
				hcriteria.andIdEqualTo("###");
			}
		}

	}

	@Override
	public EUDataGridResult queryInvoiceBVOsById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			EUDataGridResult result = new EUDataGridResult();

			InvoiceBVOExample example = new InvoiceBVOExample();
			com.fgc.pojo.InvoiceBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<InvoiceBVO> listBVOs = invoiceBVOMapper.selectByExample(example);

			PageInfo<InvoiceBVO> info = new PageInfo<>(listBVOs);
			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Override
	public WebAppResult saveInvoiceVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			// 获取表头json
			String head = jsonBill.getHead();
			// 获取表体json
			String bodys = jsonBill.getInsertBodys();

			// 将表头json、表体json转为对应的VO
			InvoiceHVO hvo = JsonUtils.jsonToPojo(head, InvoiceHVO.class);
			List<InvoiceBVO> listBVOs = JsonUtils.jsonToList(bodys, InvoiceBVO.class);

			// 保存前规则
			beforeInvoiceSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
			checkCurrencyCashCountRule.process(hvo);
			/**
			 * 保存vo
			 */
			String vbillcode = billCodeService.generateBillCode(BillTypeFlag.INVOICE_TYPE, BillTypeFlag.INVOICE_FLAG);
			IUParamVO paramVO = new IUParamVO();
			paramVO.setVbillcode(vbillcode);
			paramVO.setCuserid(sessionInfo.getId());
			PojoTools.beforeInsert(InvoiceHVO.class, hvo, paramVO);
			String hid = hvo.getId();

			invoiceHVOMapper.insert(hvo);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (InvoiceBVO bvo : listBVOs) {
					bvo.setHid(hid);

					PojoTools.beforeInsert(InvoiceBVO.class, bvo);
					invoiceBVOMapper.insert(bvo);
				}
			}
			// 保存后规则
			afterInvoiceSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));

			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "销售发票保存报错");
	}

	@Override
	public WebAppResult updateInvoiceVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			// 获取表头json
			String head = jsonBill.getHead();
			// 获取新增表体json
			String insertBodys = jsonBill.getInsertBodys();
			// 获取修改表体json
			String updataBodys = jsonBill.getUpdateBodys();
			// 获取删除表体json
			String deleteBodys = jsonBill.getDeleteBodys();
			// 获取现存的表体json
			String realyBodys = jsonBill.getRealyBodys();

			// 将表头json、表体json转为对应的VO
			InvoiceHVO hvo = null;
			List<InvoiceBVO> insertListBVOs = null;
			List<InvoiceBVO> updateListBVOs = null;
			List<InvoiceBVO> deleteListBVOs = null;
			List<InvoiceBVO> realyListBVOs = new ArrayList<>();
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, InvoiceHVO.class);
			}
			if (MMStringUtil.isNotEmpty(insertBodys)) {
				insertListBVOs = JsonUtils.jsonToList(insertBodys, InvoiceBVO.class);
			}
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, InvoiceBVO.class);
			}
			if (MMStringUtil.isNotEmpty(deleteBodys)) {
				deleteListBVOs = JsonUtils.jsonToList(deleteBodys, InvoiceBVO.class);
			}
			if (MMStringUtil.isNotEmpty(realyBodys)) {
				realyListBVOs = JsonUtils.jsonToList(realyBodys, InvoiceBVO.class);
			}

			// 在UI删除表体数据的时候，选中行删除，UI会把选中的数据同时当做修改和删除的数据使用，
			// 为了解决这个问题，在后台修改保存的时候在修改VO集合中把状态为删除的记录清除
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs) && MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (InvoiceBVO dbvo : deleteListBVOs) {
					Iterator<InvoiceBVO> iterator = updateListBVOs.iterator();
					while (iterator.hasNext()) {
						InvoiceBVO ubvo = iterator.next();
						if (MMStringUtil.isEqual(dbvo.getId(), ubvo.getId())) {
							iterator.remove();
						}
					}
				}
			}
			/**
			 * 修改保存vo
			 */
			// 获取到数据库中的旧数据，用来回写销售订单开票数量用
			JsonBill oldJsonBill = this.queryOldInvoiceData(hvo.getId());
			// 保存前规则
			beforeInvoiceUpdateRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			checkCurrencyCashCountRule.process(hvo);

			beforeInvoiceBodySaveRule.process(hvo, MMArrayUtil.toArray(insertListBVOs));

			beforeInvoiceBodyUpdateRule.process(hvo, MMArrayUtil.toArray(updateListBVOs));

			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			String hid = hvo.getId();

			InvoiceHVO dbHVO = invoiceHVOMapper.selectByPrimaryKey(hid);
			if (PojoTools.canBeforeUpdate(hvo.getTs(), dbHVO.getTs())) {
				PojoTools.beforeUpdate(InvoiceHVO.class, hvo, paramVO);
				invoiceHVOMapper.updateByPrimaryKey(hvo);
			}
			if (MMCollectionUtil.isNotEmpty(insertListBVOs)) {
				for (InvoiceBVO bvo : insertListBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(InvoiceBVO.class, bvo);
					invoiceBVOMapper.insert(bvo);
				}
			}
			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (InvoiceBVO bvo : updateListBVOs) {
					InvoiceBVO dbBvo = invoiceBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeUpdate(InvoiceBVO.class, bvo);
						invoiceBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs)) {
				for (InvoiceBVO bvo : deleteListBVOs) {
					InvoiceBVO dbBvo = invoiceBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeDelete(InvoiceBVO.class, bvo);
						invoiceBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			JsonBill newJsonBill = new JsonBill();
			newJsonBill.setHead(JsonUtils.objectToJson(hvo));
			newJsonBill.setInsertBodys(JsonUtils.objectToJson(MMArrayUtil.toArray(insertListBVOs)));
			newJsonBill.setUpdateBodys(JsonUtils.objectToJson(MMArrayUtil.toArray(updateListBVOs)));
			newJsonBill.setDeleteBodys(JsonUtils.objectToJson(MMArrayUtil.toArray(deleteListBVOs)));
			afterInvoiceUpdateRule.process(newJsonBill, oldJsonBill);

			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "销售发票保存报错");
	}

	/**
	 * @param id
	 * @return
	 */
	private JsonBill queryOldInvoiceData(String id) throws Exception {
		InvoiceHVO oldInvoice = this.queryInvoiceHVOById(id);
		EUDataGridResult olDataGridResult = this.queryInvoiceBVOsById(id);
		List<?> listBVOs = olDataGridResult.getRows();

		JsonBill jsonBill = new JsonBill();
		jsonBill.setHead(JsonUtils.objectToJson(oldInvoice));
		jsonBill.setRealyBodys(JsonUtils.objectToJson(listBVOs));
		return jsonBill;
	}

	@Override
	public InvoiceHVO queryInvoiceHVOById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			// 查询hvo
			InvoiceHVOExample hExample = new InvoiceHVOExample();
			Criteria hcriteria = hExample.createCriteria();
			hcriteria.andIdEqualTo(id);
			hcriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<InvoiceHVO> listHVOs = invoiceHVOMapper.selectByExample(hExample);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				return listHVOs.get(0);
			}
		}
		return null;
	}

	/**
	 * 校验Ts
	 * 
	 * @param jsonTS
	 * @return
	 * @throws Exception
	 */
	private List<String> checkTs(JsonTS jsonTS) throws Exception {
		List<String> listIds = new ArrayList<>();
		if (MMValueUtils.isNotEmpty(jsonTS)) {
			String data = jsonTS.getData();
			List<InvoiceHVO> listPojoTs = JsonUtils.jsonToList(data, InvoiceHVO.class);
			if (listPojoTs.size() > 1000) {
				throw new RuntimeException("每次只能操作1000条数据，请检查!");
			}
			if (MMCollectionUtil.isNotEmpty(listPojoTs)) {

				for (InvoiceHVO jspHVO : listPojoTs) {
					String id = jspHVO.getId();
					String jspts = jspHVO.getTs();

					InvoiceHVO dbHVO = invoiceHVOMapper.selectByPrimaryKey(id);
					if (PojoTools.canBeforeUpdate(jspts, dbHVO.getTs())) {
						listIds.add(id);
					}
				}
			}
		}
		return listIds;
	}

	@Override
	public WebAppResult deleteInvoiceVOsByIds(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			beforerInvoiceDeleteRule.process(listIds);
			// 删除hvo
			invoiceHVOMapper.deleteByPrimaryKeys(listIds);
			// 删除bvos
			invoiceBVOMapper.deleteByHeadPrimaryKeys(listIds);

			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "删除订单失败");
	}

	@Override
	public WebAppResult approveInvoiceVOs(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 1、需要将状态变为审批态
			 */
			InvoiceHVOExample example = new InvoiceHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<InvoiceHVO> listHVOs = invoiceHVOMapper.selectByExample(example);

			beforeInvoiceApproveChcekRule.process(listHVOs);

			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			paramVO.setYeDate(sessionInfo.getNowDate());
			for (InvoiceHVO hvo : listHVOs) {
				Long isdebt = hvo.getIsdebt();// 尾款欠款标识
				if (isdebt == 1L) {
					hvo.setRetainage(BigDecimal.ZERO);
				}
				PojoTools.beforeApprove(InvoiceHVO.class, hvo, paramVO);
				invoiceHVOMapper.updateByPrimaryKey(hvo);
			}

			InvoiceBVOExample invoiceBVOExample = new InvoiceBVOExample();
			com.fgc.pojo.InvoiceBVOExample.Criteria createCriteria = invoiceBVOExample.createCriteria();
			createCriteria.andHidIn(listIds);
			createCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<InvoiceBVO> listBVOs = invoiceBVOMapper.selectByExample(invoiceBVOExample);

			List<AggVO<InvoiceHVO, InvoiceBVO>> aggVOs = invoiceChangeUtils.aggVOs(listHVOs, listBVOs);

			/**
			 * 2、零售发票审核，生成销售出库单审核（应发和实发一起生成），库存存量校验，库存不足或为零时，提示行号、仓库、物料、 差异主数量、
			 * 差异辅数量。工程发票审核，生成销售出库单保存应发（只生成应发数量）
			 */
			beforeInvoicePushSaleOutCheckOnhandRule.process(aggVOs);
			afterInvoiceApproveRule.process(aggVOs, sessionInfo);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult pushInvoiceVOs(List<JsonBill> jsonBills, SessionInfo sessionInfo) throws Exception {
		String id = null;
		if (MMCollectionUtil.isNotEmpty(jsonBills)) {
			for (JsonBill jsonBill : jsonBills) {
				WebAppResult saveInvoiceVO = this.saveInvoiceVO(jsonBill, sessionInfo);
				id = (String) saveInvoiceVO.getData();
			}
		}
		return WebAppResult.ok(id);
	}

	@Override
	public WebAppResult unUpproveInvoiceVOs(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			InvoiceHVOExample example = new InvoiceHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<InvoiceHVO> listHVOs = invoiceHVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				for (InvoiceHVO hvo : listHVOs) {
					PojoTools.beforeUnApprove(InvoiceHVO.class, hvo);
					invoiceHVOMapper.updateByPrimaryKey(hvo);
				}
			}
			afterInvoiceUnApproveRule.process(listHVOs);
		}
		return WebAppResult.ok();
	}

	@Override
	public EUDataGridResult queryInvoiceBVOsById4Ref(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			EUDataGridResult result = new EUDataGridResult();

			InvoiceBVOExample example = new InvoiceBVOExample();
			com.fgc.pojo.InvoiceBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			bCriteria.andNastnumGreaterThanNoutnum();

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<InvoiceBVO> listBVOs = invoiceBVOMapper.selectByExample(example);

			PageInfo<InvoiceBVO> info = new PageInfo<>(listBVOs);
			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Override
	public WebAppResult batchDebtInvoice(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			InvoiceHVOExample example = new InvoiceHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<InvoiceHVO> listHVOs = invoiceHVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				for (InvoiceHVO hvo : listHVOs) {
					if (MMStringUtil.isEqual(hvo.getVsrcbilltype(),
							pubInfoService.getValueByCode(PubParam.ORDER_LINGSHOU_BILLTYPE))) {
						throw new RuntimeException("零售不允许欠款！");
					}
					hvo.setIsdebt(1L);
					PojoTools.beforeUpdate(InvoiceHVO.class, hvo);
					invoiceHVOMapper.updateByPrimaryKey(hvo);
				}
			}
			jsonTS.setData(JsonUtils.objectToJson(listHVOs));
			this.approveInvoiceVOs(jsonTS, sessionInfo);
		}
		return WebAppResult.ok();
	}

	@Override
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			InvoiceHVOExample example = new InvoiceHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<InvoiceHVO> listHVOs = invoiceHVOMapper.selectByExample(example);
			for (InvoiceHVO hvo : listHVOs) {
				hvo.setIssync((short) 0);
				PojoTools.beforeUpdate(InvoiceHVO.class, hvo);
				invoiceHVOMapper.updateByPrimaryKey(hvo);
			}
			InvoiceBVOExample bvoExample = new InvoiceBVOExample();
			com.fgc.pojo.InvoiceBVOExample.Criteria bvocriteria = bvoExample.createCriteria();
			bvocriteria.andHidIn(listIds);
			bvocriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<InvoiceBVO> listBVOs = invoiceBVOMapper.selectByExample(bvoExample);

			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (InvoiceBVO invoiceBVO : listBVOs) {
					PojoTools.beforeUpdate(InvoiceBVO.class, invoiceBVO);
					invoiceBVO.setIssync((short) 0);
					invoiceBVOMapper.updateByPrimaryKey(invoiceBVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

}
