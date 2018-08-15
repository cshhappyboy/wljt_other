package com.fgc.service.receipt.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.OrderHVOMapper;
import com.fgc.mapper.ReceiptHVOMapper;
import com.fgc.pojo.BillTypeFlag;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.pojo.ReceiptHVOExample;
import com.fgc.pojo.ReceiptHVOExample.Criteria;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.receipt.IReceiptService;
import com.fgc.service.receipt.impl.rule.AfterReceiptDeleteRule;
import com.fgc.service.receipt.impl.rule.AfterReceiptSaveRule;
import com.fgc.service.receipt.impl.rule.AfterReceiptUpdateRule;
import com.fgc.service.receipt.impl.rule.BeforeReceiptApproveCheckMoneyRule;
import com.fgc.service.receipt.impl.rule.BeforeReceiptSaveRule;
import com.fgc.service.receipt.impl.rule.BeforeReceiptUpdateRule;
import com.fgc.service.receipt.impl.rule.CheckCurrencyCashCountRule;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.model.SessionInfo;
import com.pub.utils.BillStatus;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.IUParamVO;
import com.pub.utils.JsonBill;
import com.pub.utils.JsonTS;
import com.pub.utils.JsonUtils;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;
import com.pub.utils.WebAppResult;

/**
 * 预收款单服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月29日
 *
 *     未来离线需求
 */
@Service
public class ReceiptServiceImpl implements IReceiptService {

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private BeforeReceiptApproveCheckMoneyRule beforeReceiptApproveCheckMoneyRule;

	@Autowired
	private AfterReceiptUpdateRule afterReceiptUpdateRule;

	@Autowired
	private CheckCurrencyCashCountRule checkCurrencyCashCountRule;

	@Autowired
	private AfterReceiptDeleteRule afterReceiptDeleteRule;

	@Autowired
	private AfterReceiptSaveRule afterReceiptSaveRule;

	@Autowired
	private BeforeReceiptUpdateRule beforeReceiptUpdateRule;

	@Autowired
	private BeforeReceiptSaveRule beforeReceiptSaveRule;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private ReceiptHVOMapper receiptHVOMapper;

	@Override
	public EUDataGridResult queryAllReceiptData(int page, int rows, ReceiptHVO hvo, SessionInfo sessionInfo)
			throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		ReceiptHVOExample example = new ReceiptHVOExample();
		example.setOrderByClause(" dbilldate desc ");
		example.setOrderByClause(" vbillcode desc ");
		Criteria criteria = example.createCriteria();
		criteria.andDrEqualTo(MMNCUtils.getDR(0));
		// 创建查询条件
		this.getWhereSql(hvo, criteria, sessionInfo);

		PageHelper.startPage(page, rows);

		List<ReceiptHVO> listReceiptHVO = receiptHVOMapper.selectByExample(example);

		PageInfo<ReceiptHVO> info = new PageInfo<>(listReceiptHVO);

		trans2NameUtils.transHVO(ReceiptHVO.class, info.getList(), sessionInfo.getLocal());

		result.setRows(info.getList());
		result.setTotal(info.getTotal());

		return result;
	}

	/**
	 * @param hvo
	 * @param sessionInfo
	 * @param criteria
	 */
	private void getWhereSql(ReceiptHVO hvo, Criteria hcriteria, SessionInfo sessionInfo) {
		String iszero = hvo.getIszero();
		if (MMStringUtil.isEqual("1", iszero)) {
			hcriteria.andTotalGreaterThan(BigDecimal.ZERO);
		} else if (MMStringUtil.isEqual("2", iszero)) {
			hcriteria.andTotalEqualTo(BigDecimal.ZERO);
		}

		Short issync = hvo.getIssync();
		if (MMValueUtils.isNotEmpty(issync) && issync != 2) {
			hcriteria.andIssyncEqualTo(issync);
		}
		// 收款单号
		String vbillcode = hvo.getVbillcode();
		if (MMStringUtil.isNotEmpty(vbillcode)) {
			hcriteria.andVbillcodeLike("%" + vbillcode + "%");
		}
		// 销售类型
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
		// 收款金额（为零或空值查询）、
		BigDecimal nreceivedmny = hvo.getNreceivedmny();
		if (MMValueUtils.isNotEmpty(nreceivedmny)) {
			hcriteria.andNreceivedmnyEqualTo(nreceivedmny);
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
		// 收款业务类型、
		String typecollect = hvo.getTypecollect();
		if (MMStringUtil.isNotEmpty(typecollect)) {
			hcriteria.andTypecollectEqualTo(typecollect);
		}
		// 结算方式、
		String cbalatype = hvo.getCbalatype();
		if (MMStringUtil.isNotEmpty(cbalatype)) {
			hcriteria.andCbalatypeEqualTo(cbalatype);
		}
		// 现金账户、
		String cashaccount = hvo.getCashaccount();
		if (MMStringUtil.isNotEmpty(cashaccount)) {
			hcriteria.andCashaccountEqualTo(cashaccount);
		}
		// 银行账户
		String cbankid = hvo.getCbankid();
		if (MMStringUtil.isNotEmpty(cbankid)) {
			hcriteria.andCbankidEqualTo(cbankid);
		}
	}

	@Override
	public WebAppResult saveReceiptVO(JsonBill bill, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(bill)) {
			String head = bill.getHead();
			if (MMStringUtil.isNotEmpty(head)) {
				ReceiptHVO hvo = JsonUtils.jsonToPojo(head, ReceiptHVO.class);

				beforeReceiptSaveRule.process(hvo);
				checkCurrencyCashCountRule.process(hvo);
				// 获取单据号
				String vbillcode = billCodeService.generateBillCode(BillTypeFlag.RECEIPT_TYPE,
						BillTypeFlag.RECEIPT_TYPE);
				IUParamVO paramVO = new IUParamVO();
				paramVO.setVbillcode(vbillcode);
				paramVO.setCuserid(sessionInfo.getId());
				PojoTools.beforeInsert(ReceiptHVO.class, hvo, paramVO);

				receiptHVOMapper.insert(hvo);

				afterReceiptSaveRule.process(hvo);

				if (MMStringUtil.isEqual(hvo.getVdef9(), "Y")) {
					JsonTS newJsonTs = new JsonTS();
					newJsonTs.setData(JsonUtils.objectToJson(MMArrayUtil.toList(ReceiptHVO.class, hvo)));
					this.approveReceiptVOs(newJsonTs, sessionInfo, true);
				}

				return WebAppResult.ok(hvo);
			}
		}
		return null;
	}

	@Override
	public ReceiptHVO queryReceiptHVOById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			// 查询hvo
			ReceiptHVOExample hExample = new ReceiptHVOExample();
			Criteria hcriteria = hExample.createCriteria();
			hcriteria.andIdEqualTo(id);
			hcriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<ReceiptHVO> listHVOs = receiptHVOMapper.selectByExample(hExample);
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
			List<ReceiptHVO> listPojoTs = JsonUtils.jsonToList(data, ReceiptHVO.class);
			if (listPojoTs.size() > 1000) {
				throw new RuntimeException("每次只能操作1000条数据，请检查!");
			}
			if (MMCollectionUtil.isNotEmpty(listPojoTs)) {

				for (ReceiptHVO jspHVO : listPojoTs) {
					String id = jspHVO.getId();
					String jspts = jspHVO.getTs();

					ReceiptHVO dbHVO = receiptHVOMapper.selectByPrimaryKey(id);
					if (PojoTools.canBeforeUpdate(jspts, dbHVO.getTs())) {
						listIds.add(id);
					}
				}
			}
		}
		return listIds;
	}

	@Override
	public WebAppResult deleteReceiptVO(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			receiptHVOMapper.deleteByPrimaryKeys(listIds);
			afterReceiptDeleteRule.process(listIds);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult updateReceiptVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			// 获取表头json
			String head = jsonBill.getHead();

			// 将表头json、表体json转为对应的VO
			ReceiptHVO hvo = null;
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, ReceiptHVO.class);
			}

			String id = hvo.getId();

			ReceiptHVO oldReceiptHVO = receiptHVOMapper.selectByPrimaryKey(id);
			/**
			 * 修改保存vo
			 */
			beforeReceiptUpdateRule.process(hvo);
			checkCurrencyCashCountRule.process(hvo);

			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());

			if (PojoTools.canBeforeUpdate(hvo.getTs(), oldReceiptHVO.getTs())) {
				PojoTools.beforeUpdate(ReceiptHVO.class, hvo, paramVO);
				receiptHVOMapper.updateByPrimaryKey(hvo);
			}
			afterReceiptUpdateRule.process(hvo, oldReceiptHVO);

			return WebAppResult.ok(id);
		}
		return WebAppResult.build(500, "销售订单保存报错");
	}

	@Override
	public WebAppResult approveReceiptVOs(JsonTS jsonTS, SessionInfo sessionInfo, boolean flag) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 1、需要将状态变为审批态
			 */
			ReceiptHVOExample example = new ReceiptHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<ReceiptHVO> listHVOs = receiptHVOMapper.selectByExample(example);

			if (!flag) {
				beforeReceiptApproveCheckMoneyRule.process(listHVOs);
			}
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				for (ReceiptHVO hvo : listHVOs) {
					IUParamVO paramVO = new IUParamVO();
					paramVO.setCuserid(sessionInfo.getId());
					paramVO.setYeDate(sessionInfo.getNowDate());
					PojoTools.beforeApprove(ReceiptHVO.class, hvo, paramVO);
					if (MMNumberUtil.isEqualZero(hvo.getTotal())) {
						hvo.setIssync((short) 1);
					}
					receiptHVOMapper.updateByPrimaryKey(hvo);
				}
			}
		}
		return WebAppResult.ok();
	}

	@Override
	public WebAppResult unApproveReceiptVOs(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 1、需要将状态变为自由态
			 */
			ReceiptHVOExample example = new ReceiptHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<ReceiptHVO> listHVOs = receiptHVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				for (ReceiptHVO hvo : listHVOs) {
					PojoTools.beforeUnApprove(ReceiptHVO.class, hvo);
					receiptHVOMapper.updateByPrimaryKey(hvo);
				}
			}
		}
		return WebAppResult.ok();
	}

	@Override
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			ReceiptHVOExample example = new ReceiptHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<ReceiptHVO> listHVOs = receiptHVOMapper.selectByExample(example);
			for (ReceiptHVO hvo : listHVOs) {
				PojoTools.beforeUpdate(ReceiptHVO.class, hvo);
				hvo.setIssync((short) 0);
				receiptHVOMapper.updateByPrimaryKey(hvo);
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public ReceiptHVO hongchongReceiptVO(String id, SessionInfo sessionInfo) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			ReceiptHVO receiptHVO = receiptHVOMapper.selectByPrimaryKey(id);
			String vsrcbillcode = receiptHVO.getVbillcode();
			receiptHVO.setCashaccount(null);
			receiptHVO.setCbankid(null);
			receiptHVO.setDbilldate(MMNCUtils.getNowDate());
			receiptHVO.setVbillstatus(BillStatus.FREE);
			receiptHVO.setMaxtotal(BigDecimal.ZERO);
			receiptHVO.setVdef9("Y");
			receiptHVO.setId(null);
			receiptHVO.setBillmaker(null);
			receiptHVO.setBillmaketime(null);
			receiptHVO.setApprover(null);
			receiptHVO.setApprovetime(null);
			receiptHVO.setVbillcode(null);
			String vsrcid = receiptHVO.getVsrcid();
			if (MMStringUtil.isNotEmpty(vsrcid)) {
				OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(vsrcid);
				receiptHVO.setNreceivedmny(orderHVO.getNreceivedmny());
				if (MMStringUtil.isNotEmpty(vsrcbillcode)) {
					ReceiptHVOExample example = new ReceiptHVOExample();
					Criteria criteria = example.createCriteria();
					criteria.andVsrccodeEqualTo(vsrcbillcode);
					criteria.andDrEqualTo(MMNCUtils.getDR(0));
					List<ReceiptHVO> listReceipt = receiptHVOMapper.selectByExample(example);
					if (MMCollectionUtil.isNotEmpty(listReceipt)) {
						BigDecimal sumTotal = BigDecimal.ZERO;
						for (ReceiptHVO hvo : listReceipt) {
							sumTotal = MMNumberUtil.add(sumTotal, hvo.getTotal());
						}
						receiptHVO.setMintotal(MMNumberUtil
								.subtract(MMNumberUtil.subtract(BigDecimal.ZERO, receiptHVO.getTotal()), sumTotal));
						receiptHVO.setTotal(MMNumberUtil
								.subtract(MMNumberUtil.subtract(BigDecimal.ZERO, receiptHVO.getTotal()), sumTotal));
					} else {
						receiptHVO.setMintotal(MMNumberUtil.subtract(BigDecimal.ZERO, receiptHVO.getTotal()));
						receiptHVO.setTotal(MMNumberUtil.subtract(BigDecimal.ZERO, receiptHVO.getTotal()));
					}
				}
			}
			receiptHVO.setVsrccode(vsrcbillcode);
			receiptHVO.setVsrcid(receiptHVO.getVsrcid());
			return receiptHVO;
		}
		return null;
	}

}
