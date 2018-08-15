package com.fgc.service.finprodin.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.FinprodinBVOMapper;
import com.fgc.mapper.FinprodinHVOMapper;
import com.fgc.pojo.BillTypeFlag;
import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinBVOExample;
import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.FinprodinHVOExample;
import com.fgc.pojo.FinprodinHVOExample.Criteria;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.finprodin.IFinprodinService;
import com.fgc.service.finprodin.impl.rule.AfterFinprodinSaveRule;
import com.fgc.service.finprodin.impl.rule.AfterFinprodinUpdateRule;
import com.fgc.service.finprodin.impl.rule.BeforFinprodinUnSignCheckOnHandRule;
import com.fgc.service.finprodin.impl.rule.BeforeFinprodinBodySaveRule;
import com.fgc.service.finprodin.impl.rule.BeforeFinprodinBodyUpdateRule;
import com.fgc.service.finprodin.impl.rule.BeforeFinprodinDeleteRule;
import com.fgc.service.finprodin.impl.rule.BeforeFinprodinSaveRule;
import com.fgc.service.finprodin.impl.rule.BeforeFinprodinUpdateRule;
import com.fgc.service.finprodin.impl.rule.BeforeSaveOrUpdateFinCheckEffectbillcodeRule;
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
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.PojoTools;
import com.pub.utils.WebAppResult;

/**
 * 产成品入库单实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月1日
 *
 *     未来离线需求
 */
@Service
public class FinprodinServiceImpl implements IFinprodinService {

	@Autowired
	private BeforeSaveOrUpdateFinCheckEffectbillcodeRule beforeSaveOrUpdateFinCheckEffectbillcodeRule;

	@Autowired
	private BeforFinprodinUnSignCheckOnHandRule beforFinprodinUnSignCheckOnHandRule;

	@Autowired
	private BeforeFinprodinBodySaveRule beforeFinprodinBodySaveRule;

	@Autowired
	private BeforeFinprodinBodyUpdateRule beforeFinprodinBodyUpdateRule;

	@Autowired
	private BeforeFinprodinDeleteRule beforeFinprodinDeleteRule;

	@Autowired
	private AfterFinprodinUpdateRule afterFinprodinUpdateRule;

	@Autowired
	private BeforeFinprodinUpdateRule beforeFinprodinUpdateRule;

	@Autowired
	private AfterFinprodinSaveRule afterFinprodinSaveRule;

	@Autowired
	private BeforeFinprodinSaveRule beforeFinprodinSaveRule;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private FinprodinHVOMapper finprodinHVOMapper;

	@Autowired
	private FinprodinBVOMapper finprodinBVOMapper;

	@Override
	public EUDataGridResult queryAllFinprodinVO(int page, int rows, FinprodinHVO hvo, SessionInfo sessionInfo)
			throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		FinprodinHVOExample hExample = new FinprodinHVOExample();
		hExample.setOrderByClause(" dbilldate desc ");
		hExample.setOrderByClause(" vbillcode desc ");
		Criteria hcriteria = hExample.createCriteria();
		hcriteria.andDrEqualTo(MMNCUtils.getDR(0));

		this.getWhereSql(hvo, hcriteria, sessionInfo);

		PageHelper.startPage(page, rows);

		List<FinprodinHVO> listFinprodinH = finprodinHVOMapper.selectByExample(hExample);
		PageInfo<FinprodinHVO> info = new PageInfo<>(listFinprodinH);

		trans2NameUtils.transHVO(FinprodinHVO.class, info.getList(), sessionInfo.getLocal());

		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * @param hvo
	 * @param hcriteria
	 * @param sessionInfo
	 */
	private void getWhereSql(FinprodinHVO hvo, Criteria hcriteria, SessionInfo sessionInfo) {
		Short issync = hvo.getIssync();
		if (MMValueUtils.isNotEmpty(issync) && issync != 2) {
			hcriteria.andIssyncEqualTo(issync);
		}
		// 产成品入库号、
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
		// 物料
		String cmaterial = hvo.getCmaterial();
		FinprodinBVOExample example = new FinprodinBVOExample();
		com.fgc.pojo.FinprodinBVOExample.Criteria criteria = example.createCriteria();
		if (MMStringUtil.isNotEmpty(cmaterial)) {
			if (MMStringUtil.isNotEmpty(cmaterial)) {
				criteria.andCmaterialEqualTo(cmaterial);
				criteria.andDrEqualTo(MMNCUtils.getDR(0));
			}
			List<FinprodinBVO> listBVOs = finprodinBVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				Set<String> setStr = new HashSet<>();
				for (FinprodinBVO bvo : listBVOs) {
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
	public EUDataGridResult queryFinprodinBVOs(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			EUDataGridResult result = new EUDataGridResult();

			FinprodinBVOExample example = new FinprodinBVOExample();
			example.setOrderByClause(" id asc ");
			com.fgc.pojo.FinprodinBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<FinprodinBVO> listBVOs = finprodinBVOMapper.selectByExample(example);

			PageInfo<FinprodinBVO> info = new PageInfo<>(listBVOs);
			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Override
	public WebAppResult saveFinprodinVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		// 获取表头json
		String head = jsonBill.getHead();
		// 获取表体json
		String bodys = jsonBill.getInsertBodys();

		if (MMStringUtil.isEmpty(bodys)) {
			throw new RuntimeException("入库单表体不能为空！");
		}

		// 将表头json、表体json转为对应的VO
		FinprodinHVO hvo = JsonUtils.jsonToPojo(head, FinprodinHVO.class);
		List<FinprodinBVO> listBVOs = JsonUtils.jsonToList(bodys, FinprodinBVO.class);

		// 保存前规则
		beforeFinprodinSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));

		beforeSaveOrUpdateFinCheckEffectbillcodeRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		/**
		 * 保存vo
		 */
		String vbillcode = billCodeService.generateBillCode(BillTypeFlag.FINPRODIN_TYPE, BillTypeFlag.FINPRODIN_FLAG);
		IUParamVO paramVO = new IUParamVO();
		paramVO.setVbillcode(vbillcode);
		paramVO.setCuserid(sessionInfo.getId());
		PojoTools.beforeInsert(FinprodinHVO.class, hvo, paramVO);
		String hid = hvo.getId();
		finprodinHVOMapper.insert(hvo);
		if (MMCollectionUtil.isNotEmpty(listBVOs)) {
			for (FinprodinBVO bvo : listBVOs) {
				bvo.setHid(hid);
				PojoTools.beforeInsert(FinprodinBVO.class, bvo, paramVO);
				finprodinBVOMapper.insert(bvo);
			}
		}
		// 保存后规则
		afterFinprodinSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));

		return WebAppResult.ok(hid);
	}

	@Override
	public FinprodinHVO queryFinprodinHVOById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			// 查询hvo
			FinprodinHVOExample hExample = new FinprodinHVOExample();
			Criteria hcriteria = hExample.createCriteria();
			hcriteria.andIdEqualTo(id);
			hcriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<FinprodinHVO> listHVOs = finprodinHVOMapper.selectByExample(hExample);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				return listHVOs.get(0);
			}
		}
		return null;
	}

	@Override
	public WebAppResult updateFinprodinVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
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
			FinprodinHVO hvo = null;
			List<FinprodinBVO> insertListBVOs = null;
			List<FinprodinBVO> updateListBVOs = null;
			List<FinprodinBVO> deleteListBVOs = null;
			List<FinprodinBVO> realyListBVOs = new ArrayList<>();
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, FinprodinHVO.class);
			}
			if (MMStringUtil.isNotEmpty(insertBodys)) {
				insertListBVOs = JsonUtils.jsonToList(insertBodys, FinprodinBVO.class);
				realyListBVOs.addAll(insertListBVOs);
			}
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, FinprodinBVO.class);
				realyListBVOs.addAll(updateListBVOs);
			}
			if (MMStringUtil.isNotEmpty(deleteBodys)) {
				deleteListBVOs = JsonUtils.jsonToList(deleteBodys, FinprodinBVO.class);
			}
			if (MMStringUtil.isNotEmpty(realyBodys)) {
				realyListBVOs = JsonUtils.jsonToList(realyBodys, FinprodinBVO.class);
			}

			// 在UI删除表体数据的时候，选中行删除，UI会把选中的数据同时当做修改和删除的数据使用，
			// 为了解决这个问题，在后台修改保存的时候在修改VO集合中把状态为删除的记录清除
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs) && MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (FinprodinBVO dbvo : deleteListBVOs) {
					Iterator<FinprodinBVO> iterator = updateListBVOs.iterator();
					while (iterator.hasNext()) {
						FinprodinBVO ubvo = iterator.next();
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
			JsonBill oldJsonBill = this.queryOldFinprodinData(hvo.getId());
			// 保存前规则
			beforeFinprodinUpdateRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeSaveOrUpdateFinCheckEffectbillcodeRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeFinprodinBodySaveRule.process(hvo, MMArrayUtil.toArray(insertListBVOs));

			beforeFinprodinBodyUpdateRule.process(hvo, MMArrayUtil.toArray(updateListBVOs));

			JsonBill newJsonBill = new JsonBill();
			newJsonBill.setHead(JsonUtils.objectToJson(hvo));
			newJsonBill.setInsertBodys(JsonUtils.objectToJson(MMArrayUtil.toArray(insertListBVOs)));
			newJsonBill.setUpdateBodys(JsonUtils.objectToJson(MMArrayUtil.toArray(updateListBVOs)));
			newJsonBill.setDeleteBodys(JsonUtils.objectToJson(MMArrayUtil.toArray(deleteListBVOs)));

			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			String hid = hvo.getId();
			FinprodinHVO dbHVO = finprodinHVOMapper.selectByPrimaryKey(hid);
			if (PojoTools.canBeforeUpdate(hvo.getTs(), dbHVO.getTs())) {
				PojoTools.beforeUpdate(FinprodinHVO.class, hvo, paramVO);
				finprodinHVOMapper.updateByPrimaryKey(hvo);
			}
			if (MMCollectionUtil.isNotEmpty(insertListBVOs)) {
				for (FinprodinBVO bvo : insertListBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(FinprodinBVO.class, bvo);
					finprodinBVOMapper.insert(bvo);
				}
			}
			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (FinprodinBVO bvo : updateListBVOs) {
					FinprodinBVO dbBvo = finprodinBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeUpdate(FinprodinBVO.class, bvo);
						finprodinBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs)) {
				for (FinprodinBVO bvo : deleteListBVOs) {
					FinprodinBVO dbBvo = finprodinBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeDelete(FinprodinBVO.class, bvo);
						finprodinBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			// 保存后规则
			afterFinprodinUpdateRule.process(newJsonBill, oldJsonBill);
			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "产成品入库单修改保存报错");
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private JsonBill queryOldFinprodinData(String id) throws Exception {
		FinprodinHVO oldfinprodinHVO = this.queryFinprodinHVOById(id);
		EUDataGridResult olDataGridResult = this.queryFinprodinBVOs(id);
		List<?> listBVOs = olDataGridResult.getRows();

		JsonBill jsonBill = new JsonBill();
		jsonBill.setHead(JsonUtils.objectToJson(oldfinprodinHVO));
		jsonBill.setRealyBodys(JsonUtils.objectToJson(listBVOs));
		return jsonBill;
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
			List<FinprodinHVO> listPojoTs = JsonUtils.jsonToList(data, FinprodinHVO.class);
			if (listPojoTs.size() > 1000) {
				throw new RuntimeException("每次只能操作1000条数据，请检查!");
			}
			if (MMCollectionUtil.isNotEmpty(listPojoTs)) {

				for (FinprodinHVO jspHVO : listPojoTs) {
					String id = jspHVO.getId();
					String jspts = jspHVO.getTs();

					FinprodinHVO dbHVO = finprodinHVOMapper.selectByPrimaryKey(id);
					if (PojoTools.canBeforeUpdate(jspts, dbHVO.getTs())) {
						listIds.add(id);
					}
				}
			}
		}
		return listIds;
	}

	@Override
	public WebAppResult deleteFinprodinVOs(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			beforeFinprodinDeleteRule.process(listIds);
			// 删除hvo
			finprodinHVOMapper.deleteByPrimaryKeys(listIds);
			// 删除bvos
			finprodinBVOMapper.deleteByHeadPrimaryKeys(listIds);

			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "请选择数据！");
	}

	@Override
	public WebAppResult batchSaveFinprodinVOs(List<JsonBill> listJsonBills, SessionInfo sessionInfo) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listJsonBills)) {
			List<String> listBillcode = billCodeService.generateBillCode(BillTypeFlag.FINPRODIN_TYPE,
					BillTypeFlag.FINPRODIN_FLAG, listJsonBills.size());
			for (int i = 0; i < listJsonBills.size(); i++) {
				finprodinVO4BatchSave(listJsonBills.get(i), sessionInfo, listBillcode.get(i));
			}
			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "传过来的数据为空");
	}

	private void finprodinVO4BatchSave(JsonBill jsonBill, SessionInfo sessionInfo, String vbillcode) throws Exception {
		// 获取表头json
		String head = jsonBill.getHead();
		// 获取表体json
		String bodys = jsonBill.getInsertBodys();

		if (MMStringUtil.isEmpty(bodys)) {
			throw new RuntimeException("入库单表体不能为空！");
		}

		// 将表头json、表体json转为对应的VO
		FinprodinHVO hvo = JsonUtils.jsonToPojo(head, FinprodinHVO.class);
		List<FinprodinBVO> listBVOs = JsonUtils.jsonToList(bodys, FinprodinBVO.class);

		// 保存前规则
		beforeFinprodinSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));

		beforeSaveOrUpdateFinCheckEffectbillcodeRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		/**
		 * 保存vo
		 */
		IUParamVO paramVO = new IUParamVO();
		paramVO.setVbillcode(vbillcode);
		paramVO.setCuserid(sessionInfo.getId());
		PojoTools.beforeInsert(FinprodinHVO.class, hvo, paramVO);
		String hid = hvo.getId();
		finprodinHVOMapper.insert(hvo);
		if (MMCollectionUtil.isNotEmpty(listBVOs)) {
			for (FinprodinBVO bvo : listBVOs) {
				bvo.setHid(hid);
				PojoTools.beforeInsert(FinprodinBVO.class, bvo, paramVO);
				finprodinBVOMapper.insert(bvo);
			}
		}
		// 保存后规则
		afterFinprodinSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
	}

	@Override
	public WebAppResult signBatch(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 1、需要将状态变为签字态
			 */
			FinprodinHVOExample example = new FinprodinHVOExample();
			com.fgc.pojo.FinprodinHVOExample.Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<FinprodinHVO> listHVOs = finprodinHVOMapper.selectByExample(example);
			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			paramVO.setYeDate(sessionInfo.getNowDate());
			for (FinprodinHVO hvo : listHVOs) {
				if (new DateTime(sessionInfo.getNowDate()).isBefore(new DateTime(hvo.getDbilldate()))) {
					throw new RuntimeException("签字时间不能早于单据时间！");
				}
				PojoTools.beforeSign(FinprodinHVO.class, hvo, paramVO);
				finprodinHVOMapper.updateByPrimaryKey(hvo);
			}

			FinprodinBVOExample finprodinBVOExample = new FinprodinBVOExample();
			com.fgc.pojo.FinprodinBVOExample.Criteria createCriteria = finprodinBVOExample.createCriteria();
			createCriteria.andHidIn(listIds);
			createCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<FinprodinBVO> listBVOs = finprodinBVOMapper.selectByExample(finprodinBVOExample);
			for (FinprodinBVO bvo : listBVOs) {
				if (new DateTime(sessionInfo.getNowDate()).isBefore(new DateTime(bvo.getDbizindate()))) {
					throw new RuntimeException("签字时间不能出入库日期！");
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult unSignBatch(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 1、需要将状态变为自由态
			 */
			FinprodinHVOExample example = new FinprodinHVOExample();
			com.fgc.pojo.FinprodinHVOExample.Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<FinprodinHVO> listHVOs = finprodinHVOMapper.selectByExample(example);

			beforFinprodinUnSignCheckOnHandRule.process(listIds);

			for (FinprodinHVO hvo : listHVOs) {
				PojoTools.beforeUpdate(FinprodinHVO.class, hvo);
				hvo.setVbillstatus(BillStatus.FREE);
				finprodinHVOMapper.updateByPrimaryKey(hvo);
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			FinprodinHVOExample example = new FinprodinHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<FinprodinHVO> listHVOs = finprodinHVOMapper.selectByExample(example);
			for (FinprodinHVO hvo : listHVOs) {
				hvo.setIssync((short) 0);
				PojoTools.beforeUpdate(FinprodinHVO.class, hvo);
				finprodinHVOMapper.updateByPrimaryKey(hvo);
			}
			FinprodinBVOExample bvoExample = new FinprodinBVOExample();
			com.fgc.pojo.FinprodinBVOExample.Criteria createCriteria = bvoExample.createCriteria();
			createCriteria.andHidIn(listIds);
			createCriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<FinprodinBVO> listBVOs = finprodinBVOMapper.selectByExample(bvoExample);

			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (FinprodinBVO finprodinBVO : listBVOs) {
					PojoTools.beforeUpdate(FinprodinBVO.class, finprodinBVO);
					finprodinBVO.setIssync((short) 0);
					finprodinBVOMapper.updateByPrimaryKey(finprodinBVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

}
