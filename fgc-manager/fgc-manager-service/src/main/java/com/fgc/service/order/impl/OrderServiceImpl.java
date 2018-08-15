package com.fgc.service.order.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.OrderBVOMapper;
import com.fgc.mapper.OrderHVOMapper;
import com.fgc.pojo.BillTypeFlag;
import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderBVOExample;
import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.OrderHVOExample;
import com.fgc.pojo.OrderHVOExample.Criteria;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.finprodin.IFinprodinService;
import com.fgc.service.order.IOrderService;
import com.fgc.service.order.impl.excel.ImportExcelOldDataUtils;
import com.fgc.service.order.impl.excel.ImportExcelUtils;
import com.fgc.service.order.impl.rule.AfterOrderApproveRule;
import com.fgc.service.order.impl.rule.AfterOrderDeleteRule;
import com.fgc.service.order.impl.rule.AfterOrderSaveRule;
import com.fgc.service.order.impl.rule.BeforeOrderApproveCheckRule;
import com.fgc.service.order.impl.rule.BeforeOrderBodyInfoRule;
import com.fgc.service.order.impl.rule.BeforeOrderBodySaveRule;
import com.fgc.service.order.impl.rule.BeforeOrderBodyUpdateRule;
import com.fgc.service.order.impl.rule.BeforeOrderCheckNpriceRule;
import com.fgc.service.order.impl.rule.BeforeOrderReviseRule;
import com.fgc.service.order.impl.rule.BeforeOrderSaveRule;
import com.fgc.service.order.impl.rule.BeforeOrderUpdateRule;
import com.fgc.service.order.impl.rule.BeforeSaveOrUpdateCheckEffectbillcodeRule;
import com.fgc.service.order.impl.rule.BeforeSaveOrderBillCodeCheckRule;
import com.fgc.service.order.impl.rule.RefreshEffectbillcodeRule;
import com.fgc.service.order.impl.util.OrderChangeUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.model.SessionInfo;
import com.pub.utils.AggVO;
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
 * 销售订单服务
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月22日
 *
 *     未来离线需求
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private RefreshEffectbillcodeRule refreshEffectbillcodeRule;

	@Autowired
	private ImportExcelOldDataUtils importExcelOldDataUtils;

	@Autowired
	private BeforeSaveOrUpdateCheckEffectbillcodeRule beforeSaveOrUpdateCheckEffectbillcodeRule;

	@Autowired
	private BeforeOrderBodyInfoRule beforeOrderBodyInfoRule;

	@Autowired
	private BeforeSaveOrderBillCodeCheckRule beforeSaveOrderBillCodeCheckRule;

	@Autowired
	private BeforeOrderApproveCheckRule beforeOrderApproveCheckRule;

	@Autowired
	private BeforeOrderCheckNpriceRule beforeOrderCheckNpriceRule;

	@Autowired
	private OrderChangeUtils orderChangeUtils;

	@Autowired
	private BeforeOrderBodyUpdateRule beforeOrderBodyUpdateRule;

	@Autowired
	private BeforeOrderBodySaveRule beforeOrderBodySaveRule;

	@Autowired
	private BeforeOrderReviseRule beforeOrderReviseRule;

	@Autowired
	private BeforeOrderUpdateRule beforeOrderUpdateRule;

	@Autowired
	private AfterOrderApproveRule afterOrderApproveRule;

	@Autowired
	private AfterOrderDeleteRule afterOrderDeleteRule;

	@Autowired
	private BeforeOrderSaveRule beforeOrderSaveRule;

	@Autowired
	private AfterOrderSaveRule afterOrderSaveRule;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private IFinprodinService finprodinService;

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private OrderHVOMapper orderHVOMapper;

	@Autowired
	private OrderBVOMapper orderBVOMapper;

	@Override
	public EUDataGridResult queryAllOrder(int page, int rows, OrderHVO hvo, SessionInfo sessionInfo) throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		OrderHVOExample hExample = new OrderHVOExample();
		hExample.setOrderByClause(" dbilldate desc ");
		hExample.setOrderByClause(" vbillcode desc ");
		Criteria hcriteria = hExample.createCriteria();
		hcriteria.andDrEqualTo(MMNCUtils.getDR(0));

		this.whereSql(hvo, hcriteria, sessionInfo);

		PageHelper.startPage(page, rows);

		List<OrderHVO> listOrderH = orderHVOMapper.selectByExample(hExample);
		PageInfo<OrderHVO> info = new PageInfo<>(listOrderH);

		trans2NameUtils.transHVO(OrderHVO.class, info.getList(), sessionInfo.getLocal());

		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * 拼接查询条件
	 * 
	 * @param hvo
	 * @param hcriteria
	 * @param or
	 * @param sessionInfo
	 */
	private void whereSql(OrderHVO hvo, Criteria hcriteria, SessionInfo sessionInfo) {
		Short issync = hvo.getIssync();
		if (MMValueUtils.isNotEmpty(issync) && issync != 2) {
			hcriteria.andIssyncEqualTo(issync);
		}
		String cmaterial = hvo.getCmaterial();
		String delwarehouse = hvo.getDelwarehouse();
		OrderBVOExample example = new OrderBVOExample();
		com.fgc.pojo.OrderBVOExample.Criteria criteria = example.createCriteria();
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
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				Set<String> setStr = new HashSet<>();
				for (OrderBVO bvo : listBVOs) {
					String hid = bvo.getHid();
					setStr.add(hid);
				}
				hcriteria.andIdIn(MMCollectionUtil.toList(setStr));
			} else {
				hcriteria.andIdEqualTo("###");
			}
		}

		// 订单类型、
		String cbilltype = hvo.getCbilltype();
		if (MMStringUtil.isNotEmpty(cbilltype)) {
			hcriteria.andCbilltypeEqualTo(cbilltype);
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
		String vbillcode = hvo.getVbillcode();
		if (MMStringUtil.isNotEmpty(vbillcode)) {
			hcriteria.andVbillcodeLike("%" + vbillcode + "%");
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
				}
			}
		} else {
			hcriteria.andEffectbillcodeIsNull();
		}
		// 累积收款金额、
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
		} else {
			hcriteria.andVbillstatusNotEqualTo(BillStatus.SIGN);
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
			hcriteria.andClientLike("%" + client + "%");
		}
		// 地址、
		String address = hvo.getAddress();
		if (MMStringUtil.isNotEmpty(address)) {
			hcriteria.andAddressLike("%" + address + "%");
		}
		// 电话、
		String tel = hvo.getTel();
		if (MMStringUtil.isNotEmpty(tel)) {
			hcriteria.andTelLike("%" + tel + "%");
		}
		// 备注、
		String memo = hvo.getMemo();
		if (MMStringUtil.isNotEmpty(memo)) {
			hcriteria.andMemoLike("%" + memo + "%");
		}
		// 拉单查询条件
		String reftype = hvo.getReftype();
		if (MMStringUtil.isNotEmpty(reftype) && reftype.equals("I")) {
			hcriteria.andNtotalnumGreaterThanNtotalInvoicenum();
			hcriteria.andEffectbillcodeIsNotNull();
		} else if (MMStringUtil.isNotEmpty(reftype) && reftype.equals("F")) {
			hcriteria.andNtotalnumGreaterThanNtotalinnum();
			hcriteria.andEffectbillcodeIsNotNull();
		}

	}

	@Override
	public WebAppResult saveOrder(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			// 获取表头json
			String head = jsonBill.getHead();
			// 获取表体json
			String bodys = jsonBill.getInsertBodys();

			// 将表头json、表体json转为对应的VO
			OrderHVO hvo = JsonUtils.jsonToPojo(head, OrderHVO.class);

			List<OrderBVO> listBVOs = JsonUtils.jsonToList(bodys, OrderBVO.class);

			// 保存前规则
			beforeOrderSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
			beforeSaveOrUpdateCheckEffectbillcodeRule.process(hvo, MMArrayUtil.toArray(listBVOs));

			beforeOrderCheckNpriceRule.process(MMArrayUtil.toArray(listBVOs));
			/**
			 * 保存vo
			 */
			// 获取单据号
			String vbillcode = billCodeService.generateBillCode(BillTypeFlag.ORDER_TYPE, BillTypeFlag.ORDER_FLAG);
			IUParamVO paramVO = new IUParamVO();
			paramVO.setVbillcode(vbillcode);
			paramVO.setCuserid(sessionInfo.getId());
			PojoTools.beforeInsert(OrderHVO.class, hvo, paramVO);
			String hid = hvo.getId();

			beforeSaveOrderBillCodeCheckRule.process(hvo);

			orderHVOMapper.insert(hvo);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (OrderBVO bvo : listBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(OrderBVO.class, bvo);
					orderBVOMapper.insert(bvo);
				}
			}
			// 保存后规则
			afterOrderSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));

			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "销售订单保存报错");
	}

	@Override
	public WebAppResult updateOrder(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
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
			OrderHVO hvo = null;
			List<OrderBVO> insertListBVOs = null;
			List<OrderBVO> updateListBVOs = null;
			List<OrderBVO> deleteListBVOs = null;
			List<OrderBVO> realyListBVOs = new ArrayList<>();
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, OrderHVO.class);
			}
			if (MMStringUtil.isNotEmpty(insertBodys)) {
				insertListBVOs = JsonUtils.jsonToList(insertBodys, OrderBVO.class);
			}
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, OrderBVO.class);
			}
			if (MMStringUtil.isNotEmpty(deleteBodys)) {
				deleteListBVOs = JsonUtils.jsonToList(deleteBodys, OrderBVO.class);
			}
			if (MMStringUtil.isNotEmpty(realyBodys)) {
				realyListBVOs = JsonUtils.jsonToList(realyBodys, OrderBVO.class);
			}
			// 在UI删除表体数据的时候，选中行删除，UI会把选中的数据同时当做修改和删除的数据使用，
			// 为了解决这个问题，在后台修改保存的时候在修改VO集合中把状态为删除的记录清除
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs) && MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (OrderBVO dbvo : deleteListBVOs) {
					Iterator<OrderBVO> iterator = updateListBVOs.iterator();
					while (iterator.hasNext()) {
						OrderBVO ubvo = iterator.next();
						if (MMStringUtil.isEqual(dbvo.getId(), ubvo.getId())) {
							iterator.remove();
						}
					}
				}
			}
			// 保存前规则
			beforeSaveOrUpdateCheckEffectbillcodeRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeOrderUpdateRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeOrderBodySaveRule.process(hvo, MMArrayUtil.toArray(insertListBVOs));

			beforeOrderBodyUpdateRule.process(hvo, MMArrayUtil.toArray(updateListBVOs));

			/**
			 * 修改保存vo
			 */
			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());

			String hid = hvo.getId();
			OrderHVO dbHVO = orderHVOMapper.selectByPrimaryKey(hid);
			if (PojoTools.canBeforeUpdate(hvo.getTs(), dbHVO.getTs())) {
				PojoTools.beforeUpdate(OrderHVO.class, hvo, paramVO);
				orderHVOMapper.updateByPrimaryKey(hvo);
			}
			if (MMCollectionUtil.isNotEmpty(insertListBVOs)) {
				for (OrderBVO bvo : insertListBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(OrderBVO.class, bvo);
					orderBVOMapper.insert(bvo);
				}
			}
			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (OrderBVO bvo : updateListBVOs) {
					OrderBVO dbBvo = orderBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeUpdate(OrderBVO.class, bvo);
						orderBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs)) {
				for (OrderBVO bvo : deleteListBVOs) {
					OrderBVO dbBvo = orderBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeDelete(OrderBVO.class, bvo);
						orderBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "销售订单保存报错");

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
			List<OrderHVO> listPojoTs = JsonUtils.jsonToList(data, OrderHVO.class);
			if (listPojoTs.size() > 1000) {
				throw new RuntimeException("每次只能操作1000条数据，请检查!");
			}
			if (MMCollectionUtil.isNotEmpty(listPojoTs)) {

				for (OrderHVO jspHVO : listPojoTs) {
					String id = jspHVO.getId();
					String jspts = jspHVO.getTs();

					OrderHVO dbHVO = orderHVOMapper.selectByPrimaryKey(id);
					if (PojoTools.canBeforeUpdate(jspts, dbHVO.getTs())) {
						listIds.add(id);
					}
				}
			}
		}
		return listIds;
	}

	@Override
	public WebAppResult deleteOrder(JsonTS jsonTS) throws Exception {
		List<String> listIds = checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			// 删除hvo
			orderHVOMapper.deleteByPrimaryKeys(listIds);
			// 删除bvos
			orderBVOMapper.deleteByHeadPrimaryKeys(listIds);

			afterOrderDeleteRule.process(listIds);

			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public OrderHVO queryOrderHVOById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			// 查询hvo
			OrderHVOExample hExample = new OrderHVOExample();
			Criteria hcriteria = hExample.createCriteria();
			hcriteria.andIdEqualTo(id);
			hcriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderHVO> listHVOs = orderHVOMapper.selectByExample(hExample);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				return listHVOs.get(0);
			}
		}
		return null;
	}

	@Override
	public EUDataGridResult queryOrderBVOsById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			EUDataGridResult result = new EUDataGridResult();

			OrderBVOExample example = new OrderBVOExample();

			com.fgc.pojo.OrderBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);

			PageInfo<OrderBVO> info = new PageInfo<>(listBVOs);

			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Override
	public WebAppResult approveOrderVOs(JsonTS jsonTS, SessionInfo sessionInfo, boolean flag) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			OrderHVOExample example = new OrderHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<OrderHVO> listHVOs = orderHVOMapper.selectByExample(example);
			OrderBVOExample bvoExample = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria bvocriteria = bvoExample.createCriteria();
			bvocriteria.andHidIn(listIds);
			bvocriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(bvoExample);

			List<AggVO<OrderHVO, OrderBVO>> listAggVOs = orderChangeUtils.aggVOs(listHVOs, listBVOs);

			beforeOrderApproveCheckRule.process(listAggVOs);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				for (OrderHVO hvo : listHVOs) {
					IUParamVO paramVO = new IUParamVO();
					paramVO.setCuserid(sessionInfo.getId());
					paramVO.setYeDate(sessionInfo.getNowDate());
					PojoTools.beforeApprove(OrderHVO.class, hvo, paramVO);
					orderHVOMapper.updateByPrimaryKey(hvo);
				}
			}

			/**
			 * 2、零售订单审核之后自动生成发票
			 */
			afterOrderApproveRule.process(listAggVOs, sessionInfo);

			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public JsonBill pushReceiptVO(String id, SessionInfo sessionInfo) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(id);
			ReceiptHVO receiptHVO = orderChangeUtils.changeVO2ReceiptVO(orderHVO, sessionInfo.getNowDate());
			JsonBill jsonBill = new JsonBill();
			jsonBill.setHead(JsonUtils.objectToJson(receiptHVO));
			return jsonBill;
		}
		return null;
	}

	@Override
	public JsonBill orderChange2InvoiceById(String id, String bids, SessionInfo sessionInfo) throws Exception {
		if (MMStringUtil.isNotEmpty(id) && MMStringUtil.isNotEmpty(bids)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(id);

			OrderBVOExample example = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria criteria = example.createCriteria();

			String[] arrayBids = bids.split(",");
			criteria.andIdIn(MMArrayUtil.toList(String.class, arrayBids));
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);

			List<AggVO<OrderHVO, OrderBVO>> listAggVOs = orderChangeUtils
					.aggVOs(MMArrayUtil.toList(OrderHVO.class, orderHVO), listBVOs);
			List<JsonBill> listJsonBills = orderChangeUtils.changeVO2InvoiceVO(listAggVOs, sessionInfo.getNowDate());// 返回一条已经转换好的发票VO

			return listJsonBills.get(0);
		}
		return null;
	}

	@Override
	public JsonBill orderChange2FinprodinById(String id, String bids, SessionInfo sessionInfo) throws Exception {
		if (MMStringUtil.isNotEmpty(id) && MMStringUtil.isNotEmpty(bids)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(id);
			OrderBVOExample example = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria criteria = example.createCriteria();

			String[] arrayBids = bids.split(",");
			criteria.andIdIn(MMArrayUtil.toList(String.class, arrayBids));
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);

			List<AggVO<OrderHVO, OrderBVO>> listAggVOs = orderChangeUtils
					.aggVOs(MMArrayUtil.toList(OrderHVO.class, orderHVO), listBVOs);
			List<JsonBill> listJsonBills = orderChangeUtils.changeVO2Finprodin(listAggVOs, sessionInfo.getNowDate());// 返回一条已经转换好的VO

			return listJsonBills.get(0);
		}
		return null;
	}

	@Override
	public JsonBill orderReturnById(String id, SessionInfo sessionInfo) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(id);
			OrderBVOExample example = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria criteria = example.createCriteria();
			criteria.andHidEqualTo(id);
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);

			// 数量金额全部置负数
			JsonBill jsonBill = orderChangeUtils.changeOrderSelf(orderHVO, listBVOs, sessionInfo.getNowDate());
			return jsonBill;
		}
		return null;
	}

	@Override
	public WebAppResult orderBatchPush2Finprodin(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			OrderHVOExample example = new OrderHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderHVO> listHVOs = orderHVOMapper.selectByExample(example);

			OrderBVOExample orderBVOExample = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria createCriteria = orderBVOExample.createCriteria();
			createCriteria.andHidIn(listIds);
			createCriteria.andDrEqualTo(MMNCUtils.getDR(0));

			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(orderBVOExample);

			List<AggVO<OrderHVO, OrderBVO>> listAggVOs = orderChangeUtils.aggVOs(listHVOs, listBVOs);
			List<JsonBill> listJsonBills = orderChangeUtils.changeVO2FinprodinBatch(listAggVOs,
					sessionInfo.getNowDate());// 返回已经转换好的产成品入库VO

			return finprodinService.batchSaveFinprodinVOs(listJsonBills, sessionInfo);
		}
		return null;
	}

	@Override
	public WebAppResult unApproveOrderVOs(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 销售订单弃审 1、已同步、已退货、已生产入库、已开具发票、已修订订单不允许反审核 2、需要将订单状态变为自由态
			 */
			OrderHVOExample example = new OrderHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderHVO> listHVOs = orderHVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				for (OrderHVO hvo : listHVOs) {
					PojoTools.beforeUnApprove(OrderHVO.class, hvo);
					orderHVOMapper.updateByPrimaryKey(hvo);
				}
			}
		}
		return WebAppResult.ok();
	}

	@Override
	public EUDataGridResult queryOrderBVOsById4Ref(OrderHVO hvo) throws Exception {
		String id = hvo.getId();
		String reftype = hvo.getReftype();
		if (MMStringUtil.isNotEmpty(hvo.getId())) {
			EUDataGridResult result = new EUDataGridResult();

			OrderBVOExample example = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			if ("I".equals(reftype)) {
				bCriteria.andSalenumGreaterThanNinvoicesalenum();
			} else if ("F".equals(reftype)) {
				bCriteria.andNastnumGreaterThanNinastnum();
				bCriteria.andDelwarehouseEqualTo(hvo.getDelwarehouse());
			}

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);

			PageInfo<OrderBVO> info = new PageInfo<>(listBVOs);

			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Autowired
	private ImportExcelUtils importExcelUtils;

	@Override
	public WebAppResult importExcel(InputStream inputStream, SessionInfo sessionInfo) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelUtils.importExcel(sheet, sessionInfo);
	}

	public WebAppResult reviseOrder(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
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
			OrderHVO hvo = null;
			List<OrderBVO> insertListBVOs = null;
			List<OrderBVO> updateListBVOs = null;
			List<OrderBVO> deleteListBVOs = null;
			List<OrderBVO> realyListBVOs = new ArrayList<>();
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, OrderHVO.class);
			}
			if (MMStringUtil.isNotEmpty(insertBodys)) {
				insertListBVOs = JsonUtils.jsonToList(insertBodys, OrderBVO.class);
			}
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, OrderBVO.class);
			}
			if (MMStringUtil.isNotEmpty(deleteBodys)) {
				deleteListBVOs = JsonUtils.jsonToList(deleteBodys, OrderBVO.class);
			}
			if (MMStringUtil.isNotEmpty(realyBodys)) {
				realyListBVOs = JsonUtils.jsonToList(realyBodys, OrderBVO.class);
			}
			// 在UI删除表体数据的时候，选中行删除，UI会把选中的数据同时当做修改和删除的数据使用，
			// 为了解决这个问题，在后台修改保存的时候在修改VO集合中把状态为删除的记录清除
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs) && MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (OrderBVO dbvo : deleteListBVOs) {
					Iterator<OrderBVO> iterator = updateListBVOs.iterator();
					while (iterator.hasNext()) {
						OrderBVO ubvo = iterator.next();
						if (MMStringUtil.isEqual(dbvo.getId(), ubvo.getId())) {
							iterator.remove();
						}
					}
				}
			}

			// 保存前规则
			beforeOrderReviseRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeOrderBodySaveRule.process(hvo, MMArrayUtil.toArray(insertListBVOs));

			beforeOrderBodyUpdateRule.process(hvo, MMArrayUtil.toArray(updateListBVOs));
			/**
			 * 修改保存vo
			 */
			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			String hid = hvo.getId();
			OrderHVO dbHVO = orderHVOMapper.selectByPrimaryKey(hid);
			if (PojoTools.canBeforeUpdate(hvo.getTs(), dbHVO.getTs())) {
				PojoTools.beforeRevise(OrderHVO.class, hvo, paramVO);
				orderHVOMapper.updateByPrimaryKey(hvo);
			}
			if (MMCollectionUtil.isNotEmpty(insertListBVOs)) {
				for (OrderBVO bvo : insertListBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(OrderBVO.class, bvo);
					orderBVOMapper.insert(bvo);
				}
			}
			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (OrderBVO bvo : updateListBVOs) {
					OrderBVO dbBvo = orderBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeBodyRevise(OrderBVO.class, bvo);
						orderBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs)) {
				for (OrderBVO bvo : deleteListBVOs) {
					OrderBVO dbBvo = orderBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeDelete(OrderBVO.class, bvo);
						orderBVOMapper.updateByPrimaryKey(bvo);
					}

				}
			}
			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "销售订单修订报错");
	}

	@Override
	public WebAppResult infoOrder(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 销售订单通知生产
			 */
			OrderBVOExample bvoExample = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria bvocriteria = bvoExample.createCriteria();
			bvocriteria.andHidIn(listIds);
			bvocriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(bvoExample);

			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (OrderBVO orderBVO : listBVOs) {
					Long services = orderBVO.getServices();
					if (services != 1L) {
						orderBVO.setNinfonum(orderBVO.getNastnum());
						orderBVO.setNthisinfonum(orderBVO.getNastnum());
						PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
						orderBVOMapper.updateByPrimaryKey(orderBVO);
					}
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult singleInfo(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			// 获取修改表体json
			String updataBodys = jsonBill.getUpdateBodys();

			List<OrderBVO> updateListBVOs = null;
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, OrderBVO.class);
			}
			// 保存前规则
			beforeOrderBodyInfoRule.process(updateListBVOs);

			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (OrderBVO bvo : updateListBVOs) {
					OrderBVO dbBvo = orderBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeUpdate(OrderBVO.class, bvo);
						orderBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "销售订单保存报错");
	}

	@Override
	public void saveOrder(List<JsonBill> jsonBills, SessionInfo sessionInfo) throws Exception {
		List<String> listMsg = new ArrayList<>();
		for (JsonBill jsonBill : jsonBills) {
			try {
				this.saveOrder(jsonBill, sessionInfo);
			} catch (Exception e) {
				listMsg.add(e.getMessage());
			}
		}
		if (MMCollectionUtil.isNotEmpty(listMsg)) {
			throw new RuntimeException(listMsg.toString());
		}
	}

	@Override
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			OrderHVOExample example = new OrderHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<OrderHVO> listHVOs = orderHVOMapper.selectByExample(example);
			for (OrderHVO hvo : listHVOs) {
				PojoTools.beforeUpdate(OrderHVO.class, hvo);
				hvo.setIssync((short) 0);
				hvo.setVdef1(null);
				orderHVOMapper.updateByPrimaryKey(hvo);
			}
			OrderBVOExample bvoExample = new OrderBVOExample();
			com.fgc.pojo.OrderBVOExample.Criteria bvocriteria = bvoExample.createCriteria();
			bvocriteria.andHidIn(listIds);
			bvocriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(bvoExample);

			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (OrderBVO orderBVO : listBVOs) {
					PojoTools.beforeUpdate(OrderBVO.class, orderBVO);
					orderBVO.setIssync((short) 0);
					orderBVOMapper.updateByPrimaryKey(orderBVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult importOldDataExcel(InputStream inputStream) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		return importExcelOldDataUtils.importOldExcel(sheet);
	}

	@Override
	public void saveOldOrder(JsonBill jsonBill) throws Exception {
		if (MMValueUtils.isNotEmpty(jsonBill)) {
			// 获取表头json
			String head = jsonBill.getHead();
			// 获取表体json
			String bodys = jsonBill.getInsertBodys();

			// 将表头json、表体json转为对应的VO
			OrderHVO hvo = JsonUtils.jsonToPojo(head, OrderHVO.class);

			List<OrderBVO> listBVOs = JsonUtils.jsonToList(bodys, OrderBVO.class);

			BigDecimal sumMny = BigDecimal.ZERO;
			BigDecimal sumNum = BigDecimal.ZERO;
			for (OrderBVO bvo : listBVOs) {
				sumNum = MMNumberUtil.add(sumNum, bvo.getNinvoicenastnum());
				sumMny = MMNumberUtil.add(sumMny, bvo.getNinvoicemny());
			}
			hvo.setNtotalinvoicemny(sumMny);
			hvo.setNtotalinvoicenum(sumNum);

			// 保存前规则
			beforeOrderSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
			/**
			 * 保存vo
			 */
			orderHVOMapper.insert(hvo);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (OrderBVO bvo : listBVOs) {
					orderBVOMapper.insert(bvo);
				}
			}
			// 保存后规则
			afterOrderSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		}
	}

	@Override
	public WebAppResult batchBlackout(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			orderHVOMapper.blackOutByPrimaryKeys(listIds);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult refreshEffectbillcode(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			for (String id : listIds) {
				OrderHVO orderHVO = orderHVOMapper.selectByPrimaryKey(id);
				String effectbillcode = orderHVO.getEffectbillcode();
				OrderBVOExample example = new OrderBVOExample();
				com.fgc.pojo.OrderBVOExample.Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(id);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<OrderBVO> listBVOs = orderBVOMapper.selectByExample(example);

				refreshEffectbillcodeRule.process(listBVOs, effectbillcode);
			}
		}
		return WebAppResult.ok();
	}
}
