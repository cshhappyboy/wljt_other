package com.fgc.service.saleout.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.SaleOutBVOMapper;
import com.fgc.mapper.SaleOutHVOMapper;
import com.fgc.pojo.BillTypeFlag;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutBVOExample;
import com.fgc.pojo.SaleOutHVO;
import com.fgc.pojo.SaleOutHVOExample;
import com.fgc.pojo.SaleOutHVOExample.Criteria;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.pub.IPubInfoService;
import com.fgc.service.saleout.ISaleOutService;
import com.fgc.service.saleout.impl.rule.AfterSaleOutBatchOutRule;
import com.fgc.service.saleout.impl.rule.AfterSaleOutSaveRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutBatchOutRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutBodySaveRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutBodyUpdateRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutDeleteRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutSaveRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutSignRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutUnSignRule;
import com.fgc.service.saleout.impl.rule.BeforeSaleOutUpdateRule;
import com.fgc.service.saleout.impl.rule.SaleOutCheckOnhandnumRule;
import com.fgc.service.saleout.impl.rule.SaleOutRefreshEffectBillcodeRule;
import com.fgc.service.saleout.impl.util.SaleOutChangeUtils;
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
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年1月31日
 *
 *     未来离线需求
 */
@Service
public class SaleOutServiceImpl implements ISaleOutService {

	@Autowired
	private SaleOutRefreshEffectBillcodeRule saleOutRefreshEffectBillcodeRule;

	@Autowired
	private AfterSaleOutSaveRule afterSaleOutSaveRule;

	@Autowired
	private AfterSaleOutBatchOutRule afterSaleOutBatchOutRule;

	@Autowired
	private BeforeSaleOutBatchOutRule beforeSaleOutBatchOutRule;

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private BeforeSaleOutSignRule beforeSaleOutSignRule;

	@Autowired
	private SaleOutCheckOnhandnumRule saleOutCheckOnhandnumRule;

	@Autowired
	private BeforeSaleOutBodySaveRule beforeSaleOutBodySaveRule;

	@Autowired
	private BeforeSaleOutBodyUpdateRule beforeSaleOutBodyUpdateRule;

	@Autowired
	private BeforeSaleOutUpdateRule beforeSaleOutUpdateRule;

	@Autowired
	private BeforeSaleOutUnSignRule beforeSaleOutUnSignRule;

	@Autowired
	private BeforeSaleOutDeleteRule beforeSaleOutDeleteRule;

	@Autowired
	private BeforeSaleOutSaveRule beforeSaleOutSaveRule;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private SaleOutHVOMapper outHVOMapper;

	@Autowired
	private SaleOutBVOMapper outBVOMapper;

	@Override
	public EUDataGridResult queryAllSaleOutVO(int page, int rows, SaleOutHVO hvo, SessionInfo sessionInfo)
			throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		SaleOutHVOExample hExample = new SaleOutHVOExample();
		hExample.setOrderByClause(" dbilldate desc ");
		hExample.setOrderByClause(" vbillcode desc ");
		Criteria hcriteria = hExample.createCriteria();
		hcriteria.andDrEqualTo(MMNCUtils.getDR(0));

		this.getWhereSql(hvo, hcriteria, sessionInfo);

		PageHelper.startPage(page, rows);

		List<SaleOutHVO> listSaleOutH = outHVOMapper.selectByExample(hExample);
		PageInfo<SaleOutHVO> info = new PageInfo<>(listSaleOutH);

		trans2NameUtils.transHVO(SaleOutHVO.class, info.getList(), sessionInfo.getLocal());

		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * @param hvo
	 * @param hcriteria
	 * @param sessionInfo
	 */
	private void getWhereSql(SaleOutHVO hvo, Criteria hcriteria, SessionInfo sessionInfo) {
		Short issync = hvo.getIssync();
		if (MMValueUtils.isNotEmpty(issync) && issync != 2) {
			hcriteria.andIssyncEqualTo(issync);
		}
		// 销售出库号、
		String vbillcode = hvo.getVbillcode();
		if (MMStringUtil.isNotEmpty(vbillcode)) {
			hcriteria.andVbillcodeLike("%" + vbillcode + "%");
		}
		// 销售订单类型、
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

		// 有效订单号（支持批量输入、execl表拷贝）、
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
		// 单据日期、
		String dbilldatestart = hvo.getDbilldatestart();
		String dbilldateend = hvo.getDbilldateend();
		if (MMStringUtil.isNotEmpty(dbilldatestart) && MMStringUtil.isNotEmpty(dbilldateend)) {
			hcriteria.andDbilldateBetween(dbilldatestart, dbilldateend);
		}
		//签字时间
		String dsigndatestart = hvo.getDsigndatestart();
		String dsigndateend = hvo.getDsigndateend();
		if (MMStringUtil.isNotEmpty(dsigndatestart) && MMStringUtil.isNotEmpty(dsigndateend)) {
			hcriteria.andApprovetimeBetween(dsigndatestart, dsigndateend);
		}
		// 客户、
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
		// 仓库、
		String cwarehouseid = hvo.getCwarehouseid();
		if (MMStringUtil.isNotEmpty(cwarehouseid)) {
			hcriteria.andCwarehouseidEqualTo(cwarehouseid);
		}
		String vdef10 = hvo.getVdef10();
		if (MMStringUtil.isNotEmpty(vdef10)) {
			hcriteria.andVdef10EqualTo(vdef10);
		}
		// 物料
		String cmaterial = hvo.getCmaterial();
		SaleOutBVOExample example = new SaleOutBVOExample();
		com.fgc.pojo.SaleOutBVOExample.Criteria criteria = example.createCriteria();
		if (MMStringUtil.isNotEmpty(cmaterial)) {
			if (MMStringUtil.isNotEmpty(cmaterial)) {
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				criteria.andCmaterialEqualTo(cmaterial);
			}
			List<SaleOutBVO> listBVOs = outBVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				Set<String> setStr = new HashSet<>();
				for (SaleOutBVO bvo : listBVOs) {
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
	public EUDataGridResult querySaleOutBVOs(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			EUDataGridResult result = new EUDataGridResult();

			SaleOutBVOExample example = new SaleOutBVOExample();
			example.setOrderByClause(" id asc ");
			com.fgc.pojo.SaleOutBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<SaleOutBVO> listBVOs = outBVOMapper.selectByExample(example);

			PageInfo<SaleOutBVO> info = new PageInfo<>(listBVOs);
			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Override
	public WebAppResult saveSaleOutVO4Invoice(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		// 获取表头json
		String head = jsonBill.getHead();
		// 获取表体json
		String bodys = jsonBill.getInsertBodys();

		// 将表头json、表体json转为对应的VO
		SaleOutHVO hvo = JsonUtils.jsonToPojo(head, SaleOutHVO.class);
		List<SaleOutBVO> listBVOs = JsonUtils.jsonToList(bodys, SaleOutBVO.class);

		// 保存前规则
		beforeSaleOutSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		/**
		 * 保存vo
		 */
		String vbillcode = billCodeService.generateBillCode(BillTypeFlag.SALEOUT_TYPE, BillTypeFlag.SALEOUT_FLAG);
		IUParamVO paramVO = new IUParamVO();
		paramVO.setVbillcode(vbillcode);
		paramVO.setCuserid(sessionInfo.getId());
		PojoTools.beforeInsert(SaleOutHVO.class, hvo, paramVO);
		String hid = hvo.getId();
		// 销售出库零售类单据保存/修改时单据时同步标识为已同步
		outHVOMapper.insert(hvo);
		if (MMCollectionUtil.isNotEmpty(listBVOs)) {
			for (SaleOutBVO bvo : listBVOs) {
				bvo.setHid(hid);
				PojoTools.beforeInsert(SaleOutBVO.class, bvo);
				outBVOMapper.insert(bvo);
			}
		}
		afterSaleOutSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		if (MMStringUtil.isEqual(hvo.getVdef10(), pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"))
				|| MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"), hvo.getVdef10())) {
			JsonTS jsonTS = new JsonTS();
			List<SaleOutHVO> listHVOs = new ArrayList<>();
			listHVOs.add(hvo);
			jsonTS.setData(JsonUtils.objectToJson(listHVOs));
			this.signSaleOutVOs(jsonTS, sessionInfo);
		}
		return WebAppResult.ok(hid);
	}

	@Override
	public SaleOutHVO querySaleOutHVOById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			// 查询hvo
			SaleOutHVOExample hExample = new SaleOutHVOExample();
			Criteria hcriteria = hExample.createCriteria();
			hcriteria.andIdEqualTo(id);
			hcriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<SaleOutHVO> listHVOs = outHVOMapper.selectByExample(hExample);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				return listHVOs.get(0);
			}
		}
		return null;
	}

	@Override
	public WebAppResult updateSaleOutVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
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
			SaleOutHVO hvo = null;
			List<SaleOutBVO> insertListBVOs = null;
			List<SaleOutBVO> updateListBVOs = null;
			List<SaleOutBVO> deleteListBVOs = null;
			List<SaleOutBVO> realyListBVOs = new ArrayList<>();
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, SaleOutHVO.class);
			}
			if (MMStringUtil.isNotEmpty(insertBodys)) {
				insertListBVOs = JsonUtils.jsonToList(insertBodys, SaleOutBVO.class);
			}
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, SaleOutBVO.class);
			}
			if (MMStringUtil.isNotEmpty(deleteBodys)) {
				deleteListBVOs = JsonUtils.jsonToList(deleteBodys, SaleOutBVO.class);
			}
			if (MMStringUtil.isNotEmpty(realyBodys)) {
				realyListBVOs = JsonUtils.jsonToList(realyBodys, SaleOutBVO.class);
			}
			// 在UI删除表体数据的时候，选中行删除，UI会把选中的数据同时当做修改和删除的数据使用，
			// 为了解决这个问题，在后台修改保存的时候在修改VO集合中把状态为删除的记录清除
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs) && MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (SaleOutBVO dbvo : deleteListBVOs) {
					Iterator<SaleOutBVO> iterator = updateListBVOs.iterator();
					while (iterator.hasNext()) {
						SaleOutBVO ubvo = iterator.next();
						if (MMStringUtil.isEqual(dbvo.getId(), ubvo.getId())) {
							iterator.remove();
						}
					}
				}
			}
			// 保存前规则
			beforeSaleOutUpdateRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeSaleOutBodySaveRule.process(hvo, MMArrayUtil.toArray(insertListBVOs));

			beforeSaleOutBodyUpdateRule.process(hvo, MMArrayUtil.toArray(updateListBVOs), sessionInfo.getNowDate());

			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			String hid = hvo.getId();

			SaleOutHVO dbHVO = outHVOMapper.selectByPrimaryKey(hid);
			if (PojoTools.canBeforeUpdate(hvo.getTs(), dbHVO.getTs())) {
				// 销售出库零售类单据保存/修改时单据时同步标识为已同步
				PojoTools.beforeUpdate(SaleOutHVO.class, hvo, paramVO);
				outHVOMapper.updateByPrimaryKey(hvo);
			}

			if (MMCollectionUtil.isNotEmpty(insertListBVOs)) {
				for (SaleOutBVO bvo : insertListBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(SaleOutBVO.class, bvo);
					outBVOMapper.insert(bvo);
				}
			}
			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (SaleOutBVO bvo : updateListBVOs) {
					SaleOutBVO dbBvo = outBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeUpdate(SaleOutBVO.class, bvo);
						outBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs)) {
				for (SaleOutBVO bvo : deleteListBVOs) {
					SaleOutBVO dbBvo = outBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeDelete(SaleOutBVO.class, bvo);
						outBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "销售出库修改保存报错");
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
			List<SaleOutHVO> listPojoTs = JsonUtils.jsonToList(data, SaleOutHVO.class);
			if (listPojoTs.size() > 1000) {
				throw new RuntimeException("每次只能操作1000条数据，请检查!");
			}
			if (MMCollectionUtil.isNotEmpty(listPojoTs)) {

				for (SaleOutHVO jspHVO : listPojoTs) {
					String id = jspHVO.getId();
					String jspts = jspHVO.getTs();

					SaleOutHVO dbHVO = outHVOMapper.selectByPrimaryKey(id);
					if (PojoTools.canBeforeUpdate(jspts, dbHVO.getTs())) {
						listIds.add(id);
					}
				}
			}
		}
		return listIds;
	}

	@Override
	public WebAppResult deleteSaleOut(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			beforeSaleOutDeleteRule.process(listIds);
			// 删除hvo
			outHVOMapper.deleteByPrimaryKeys(listIds);
			// 删除bvos
			outBVOMapper.deleteByHeadPrimaryKeys(listIds);

			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "删除失败！");
	}

	@Override
	public WebAppResult signSaleOutVOs(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 1、需要将状态变为签字态
			 */
			SaleOutHVOExample example = new SaleOutHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<SaleOutHVO> listHVOs = outHVOMapper.selectByExample(example);

			SaleOutBVOExample bvoExample = new SaleOutBVOExample();
			com.fgc.pojo.SaleOutBVOExample.Criteria createCriteria = bvoExample.createCriteria();
			createCriteria.andHidIn(listIds);
			createCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<SaleOutBVO> listBVOs = outBVOMapper.selectByExample(bvoExample);

			beforeSaleOutSignRule.process(listHVOs);
			
			beforeSaleOutSignRule.processBody(listBVOs,sessionInfo.getNowDate());

			List<AggVO<SaleOutHVO, SaleOutBVO>> aggVOs = SaleOutChangeUtils.aggVOs(listHVOs, listBVOs);
			saleOutCheckOnhandnumRule.process(aggVOs, sessionInfo);
			// 保存后规则
			afterSaleOutBatchOutRule.process(aggVOs);
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult saveSaleOutVOBatch(List<JsonBill> listJsonBill, SessionInfo sessionInfo) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listJsonBill)) {
			List<String> listMsg = new ArrayList<>();

			List<String> listBillcode = billCodeService.generateBillCode(BillTypeFlag.SALEOUT_TYPE,
					BillTypeFlag.SALEOUT_FLAG, listJsonBill.size());
			for (int i = 0; i < listJsonBill.size(); i++) {
				try {
					this.saleOutVO4Invoice2Save(listJsonBill.get(i), sessionInfo, listBillcode.get(i));
				} catch (Exception e) {
					listMsg.add(e.getMessage());
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "批量保存失败！");
	}

	private void saleOutVO4Invoice2Save(JsonBill jsonBill, SessionInfo sessionInfo, String vbillcode) throws Exception {
		// 获取表头json
		String head = jsonBill.getHead();
		// 获取表体json
		String bodys = jsonBill.getInsertBodys();

		// 将表头json、表体json转为对应的VO
		SaleOutHVO hvo = JsonUtils.jsonToPojo(head, SaleOutHVO.class);
		List<SaleOutBVO> listBVOs = JsonUtils.jsonToList(bodys, SaleOutBVO.class);

		// 保存前规则
		beforeSaleOutSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		/**
		 * 保存vo
		 */
		IUParamVO paramVO = new IUParamVO();
		paramVO.setVbillcode(vbillcode);
		paramVO.setCuserid(sessionInfo.getId());
		PojoTools.beforeInsert(SaleOutHVO.class, hvo, paramVO);
		String hid = hvo.getId();
		// 销售出库零售类单据保存/修改时单据时同步标识为已同步
		outHVOMapper.insert(hvo);
		if (MMCollectionUtil.isNotEmpty(listBVOs)) {
			for (SaleOutBVO bvo : listBVOs) {
				bvo.setHid(hid);
				PojoTools.beforeInsert(SaleOutBVO.class, bvo);
				outBVOMapper.insert(bvo);
			}
		}
		afterSaleOutSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		if (MMStringUtil.isEqual(hvo.getVdef10(), pubInfoService.getValueByCode("ORDER_LINGSHOU_BILLTYPE"))
				|| MMStringUtil.isEqual(pubInfoService.getValueByCode("ORDER_RETURNSALE_BILLTYPE"), hvo.getVdef10())) {
			JsonTS jsonTS = new JsonTS();
			List<SaleOutHVO> listHVOs = new ArrayList<>();
			listHVOs.add(hvo);
			jsonTS.setData(JsonUtils.objectToJson(listHVOs));
			this.signSaleOutVOs(jsonTS, sessionInfo);
		}
	}

	@Override
	public WebAppResult unSignSaleOutVOs(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			beforeSaleOutUnSignRule.process(listIds);
			/**
			 * 1、需要将状态变为自由态
			 */
			SaleOutHVOExample example = new SaleOutHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<SaleOutHVO> listHVOs = outHVOMapper.selectByExample(example);
			for (SaleOutHVO hvo : listHVOs) {
				PojoTools.beforeUnSign(SaleOutHVO.class, hvo);
				outHVOMapper.updateByPrimaryKey(hvo);
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult batchSaleout(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			SaleOutHVOExample saleOutHVOExample = new SaleOutHVOExample();
			Criteria criteria = saleOutHVOExample.createCriteria();
			criteria.andIdIn(listIds);
			List<SaleOutHVO> listHVOs = outHVOMapper.selectByExample(saleOutHVOExample);

			SaleOutBVOExample saleOutBVOExample = new SaleOutBVOExample();
			com.fgc.pojo.SaleOutBVOExample.Criteria createCriteria = saleOutBVOExample.createCriteria();
			createCriteria.andHidIn(listIds);
			createCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<SaleOutBVO> listSaleOutBVOs = outBVOMapper.selectByExample(saleOutBVOExample);

			List<AggVO<SaleOutHVO, SaleOutBVO>> aggVOs = SaleOutChangeUtils.aggVOs(listHVOs, listSaleOutBVOs);

			beforeSaleOutBatchOutRule.process(aggVOs,sessionInfo.getNowDate());

			for (SaleOutHVO hvo : listHVOs) {
				PojoTools.beforeUpdate(SaleOutHVO.class, hvo);
				outHVOMapper.updateByPrimaryKey(hvo);
			}

			for (SaleOutBVO saleOutBVO : listSaleOutBVOs) {
				PojoTools.beforeUpdate(SaleOutBVO.class, saleOutBVO);
				outBVOMapper.updateByPrimaryKey(saleOutBVO);
			}

			JsonTS newJsonTs = new JsonTS();
			newJsonTs.setData(JsonUtils.objectToJson(listHVOs));
			return this.signSaleOutVOs(newJsonTs, sessionInfo);
		}
		return null;
	}

	@Override
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			SaleOutHVOExample example = new SaleOutHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<SaleOutHVO> listHVOs = outHVOMapper.selectByExample(example);
			for (SaleOutHVO hvo : listHVOs) {
				hvo.setIssync((short) 0);
				PojoTools.beforeUpdate(SaleOutHVO.class, hvo);
				outHVOMapper.updateByPrimaryKey(hvo);
			}
			SaleOutBVOExample bvoExample = new SaleOutBVOExample();
			com.fgc.pojo.SaleOutBVOExample.Criteria bvocriteria = bvoExample.createCriteria();
			bvocriteria.andHidIn(listIds);
			bvocriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<SaleOutBVO> listBVOs = outBVOMapper.selectByExample(bvoExample);

			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (SaleOutBVO saleOutBVO : listBVOs) {
					saleOutBVO.setIssync((short) 0);
					PojoTools.beforeUpdate(SaleOutBVO.class, saleOutBVO);
					outBVOMapper.updateByPrimaryKey(saleOutBVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult refreshEffectbillcode(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			for (String id : listIds) {
				SaleOutHVO saleOutHVO = outHVOMapper.selectByPrimaryKey(id);
				String effectbillcode = saleOutHVO.getEffectbillcode();
				SaleOutBVOExample example = new SaleOutBVOExample();
				com.fgc.pojo.SaleOutBVOExample.Criteria criteria = example.createCriteria();
				criteria.andHidEqualTo(id);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
				List<SaleOutBVO> listBVOs = outBVOMapper.selectByExample(example);

				saleOutRefreshEffectBillcodeRule.process(listBVOs, effectbillcode);
			}
		}
		return WebAppResult.ok();
	}

}
