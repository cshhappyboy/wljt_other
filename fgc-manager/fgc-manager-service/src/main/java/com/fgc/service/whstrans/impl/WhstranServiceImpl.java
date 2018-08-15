package com.fgc.service.whstrans.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.WhstransBVOMapper;
import com.fgc.mapper.WhstransHVOMapper;
import com.fgc.pojo.BillTypeFlag;
import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransBVOExample;
import com.fgc.pojo.WhstransHVO;
import com.fgc.pojo.WhstransHVOExample;
import com.fgc.pojo.WhstransHVOExample.Criteria;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.whstrans.IWhstranService;
import com.fgc.service.whstrans.impl.rule.BeforeWhstransBodySaveRule;
import com.fgc.service.whstrans.impl.rule.BeforeWhstransBodyUpdateRule;
import com.fgc.service.whstrans.impl.rule.BeforeWhstransSaveOrUpdateCheckOnHandRule;
import com.fgc.service.whstrans.impl.rule.BeforeWhstransSaveRule;
import com.fgc.service.whstrans.impl.rule.BeforeWhstransUpdateRule;
import com.fgc.service.whstrans.impl.rule.CheckStoreDoceRule;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.model.SessionInfo;
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
 * 转库单服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月5日
 *
 *     未来离线需求
 */
@Service
public class WhstranServiceImpl implements IWhstranService {

	@Autowired
	private BeforeWhstransSaveOrUpdateCheckOnHandRule beforeWhstransSaveOrUpdateCheckRule;

	@Autowired
	private CheckStoreDoceRule checkStoreDoceRule;

	@Autowired
	private BeforeWhstransBodyUpdateRule beforeWhstransBodyUpdateRule;

	@Autowired
	private BeforeWhstransBodySaveRule beforeWhstransBodySaveRule;

	@Autowired
	private BeforeWhstransUpdateRule beforeWhstransUpdateRule;

	@Autowired
	private BeforeWhstransSaveRule beforeWhstransSaveRule;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private IBillCodeService billCodeService;

	@Autowired
	private WhstransHVOMapper whstransHVOMapper;

	@Autowired
	private WhstransBVOMapper whstransBVOMapper;

	@Override
	public EUDataGridResult queryAllWhstransVO(int page, int rows, WhstransHVO hvo, SessionInfo sessionInfo)
			throws Exception {
		EUDataGridResult result = new EUDataGridResult();

		WhstransHVOExample hExample = new WhstransHVOExample();
		hExample.setOrderByClause(" dbilldate desc ");
		hExample.setOrderByClause(" vbillcode desc ");
		Criteria hcriteria = hExample.createCriteria();
		hcriteria.andDrEqualTo(MMNCUtils.getDR(0));

		this.getWhereSql(hvo, hcriteria, sessionInfo);

		PageHelper.startPage(page, rows);

		List<WhstransHVO> listWhstransH = whstransHVOMapper.selectByExample(hExample);
		PageInfo<WhstransHVO> info = new PageInfo<>(listWhstransH);

		trans2NameUtils.transHVO(WhstransHVO.class, info.getList(), sessionInfo.getLocal());

		result.setRows(info.getList());
		result.setTotal(info.getTotal());
		return result;
	}

	/**
	 * @param hvo
	 * @param hcriteria
	 * @param sessionInfo
	 */
	private void getWhereSql(WhstransHVO hvo, Criteria hcriteria, SessionInfo sessionInfo) {
		Short issync = hvo.getIssync();
		if (MMValueUtils.isNotEmpty(issync) && issync != 2) {
			hcriteria.andIssyncEqualTo(issync);
		}

		String cmaterial = hvo.getCmaterial();
		WhstransBVOExample example = new WhstransBVOExample();
		com.fgc.pojo.WhstransBVOExample.Criteria criteria = example.createCriteria();
		if (MMStringUtil.isNotEmpty(cmaterial)) {
			criteria.andCmaterialEqualTo(cmaterial);
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<WhstransBVO> listBVOs = whstransBVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				Set<String> setStr = new HashSet<>();
				for (WhstransBVO bvo : listBVOs) {
					String hid = bvo.getHid();
					setStr.add(hid);
				}
				hcriteria.andIdIn(MMCollectionUtil.toList(setStr));
			} else {
				hcriteria.andIdEqualTo("###");
			}
		}
		
		String vbatchcode = hvo.getVbatchcode();
		if(MMStringUtil.isNotEmpty(vbatchcode)){
			criteria.andVbatchcodeEqualTo(vbatchcode);
			criteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<WhstransBVO> listBVOs = whstransBVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				Set<String> setStr = new HashSet<>();
				for (WhstransBVO bvo : listBVOs) {
					String hid = bvo.getHid();
					setStr.add(hid);
				}
				hcriteria.andIdIn(MMCollectionUtil.toList(setStr));
			} else {
				hcriteria.andIdEqualTo("###");
			}
		}
		

		String cbilltype = hvo.getCbilltype();
		if (MMStringUtil.isNotEmpty(cbilltype)) {
			hcriteria.andCbilltypeEqualTo(cbilltype);
		}
		String vbillcode = hvo.getVbillcode();
		if (MMStringUtil.isNotEmpty(vbillcode)) {
			hcriteria.andVbillcodeLike("%" + vbillcode + "%");
		}
		String dbilldatestart = hvo.getDbilldatestart();
		String dbilldateend = hvo.getDbilldateend();
		if (MMStringUtil.isNotEmpty(dbilldatestart) && MMStringUtil.isNotEmpty(dbilldateend)) {
			hcriteria.andDbilldateBetween(dbilldatestart, dbilldateend);
		}
		String cotherbizid = hvo.getCotherbizid();
		if (MMStringUtil.isNotEmpty(cotherbizid)) {
			hcriteria.andCotherbizidEqualTo(cotherbizid);
		}
		String coutwarehouseid = hvo.getCoutwarehouseid();
		if (MMStringUtil.isNotEmpty(coutwarehouseid)) {
			hcriteria.andCoutwarehouseidEqualTo(coutwarehouseid);
		}
		String cbizid = hvo.getCbizid();
		if (MMStringUtil.isNotEmpty(cbizid)) {
			hcriteria.andCbizidEqualTo(cbizid);
		}
		String cotherwhid = hvo.getCotherwhid();
		if (MMStringUtil.isNotEmpty(cotherwhid)) {
			hcriteria.andCotherwhidEqualTo(cotherwhid);
		}
		Long vbillstatus = hvo.getVbillstatus();
		if (MMValueUtils.isNotEmpty(vbillstatus)) {
			hcriteria.andVbillstatusEqualTo(vbillstatus);
		}

		String approver = hvo.getApprover();
		if (MMStringUtil.isNotEmpty(approver)) {
			hcriteria.andApproverEqualTo(approver);
		}
		String billmaker = hvo.getBillmaker();
		if (MMStringUtil.isNotEmpty(billmaker)) {
			hcriteria.andBillmakerEqualTo(billmaker);
		}

	}

	@Override
	public EUDataGridResult queryWhstransBVOs(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			EUDataGridResult result = new EUDataGridResult();

			WhstransBVOExample example = new WhstransBVOExample();
			example.setOrderByClause(" id asc ");
			com.fgc.pojo.WhstransBVOExample.Criteria bCriteria = example.createCriteria();
			bCriteria.andHidEqualTo(id);
			bCriteria.andDrEqualTo(MMNCUtils.getDR(0));

			PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

			List<WhstransBVO> listBVOs = whstransBVOMapper.selectByExample(example);

			PageInfo<WhstransBVO> info = new PageInfo<>(listBVOs);
			result.setTotal(info.getTotal());
			result.setRows(info.getList());
			return result;
		}
		return null;
	}

	@Override
	public WebAppResult saveWhstransVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
		// 获取表头json
		String head = jsonBill.getHead();
		// 获取表体json
		String bodys = jsonBill.getInsertBodys();

		// 将表头json、表体json转为对应的VO
		WhstransHVO hvo = JsonUtils.jsonToPojo(head, WhstransHVO.class);
		List<WhstransBVO> listBVOs = JsonUtils.jsonToList(bodys, WhstransBVO.class);

		// 保存前规则
		beforeWhstransSaveRule.process(hvo, MMArrayUtil.toArray(listBVOs));
		checkStoreDoceRule.process(hvo);

		beforeWhstransSaveOrUpdateCheckRule.process(hvo, MMArrayUtil.toArray(listBVOs));

		/**
		 * 保存vo
		 */
		String vbillcode = billCodeService.generateBillCode(BillTypeFlag.WHSTRANS_TYPE, BillTypeFlag.WHSTRANS_FLAG);
		IUParamVO paramVO = new IUParamVO();
		paramVO.setVbillcode(vbillcode);
		paramVO.setCuserid(sessionInfo.getId());
		PojoTools.beforeInsert(WhstransHVO.class, hvo, paramVO);
		String hid = hvo.getId();
		whstransHVOMapper.insert(hvo);
		if (MMCollectionUtil.isNotEmpty(listBVOs)) {
			for (WhstransBVO bvo : listBVOs) {
				bvo.setHid(hid);
				PojoTools.beforeInsert(WhstransBVO.class, bvo);
				whstransBVOMapper.insert(bvo);
			}
		}

		return WebAppResult.ok(hid);
	}

	@Override
	public WhstransHVO queryWhstransHVOById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			// 查询hvo
			WhstransHVOExample hExample = new WhstransHVOExample();
			Criteria hcriteria = hExample.createCriteria();
			hcriteria.andIdEqualTo(id);
			hcriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<WhstransHVO> listHVOs = whstransHVOMapper.selectByExample(hExample);
			if (MMCollectionUtil.isNotEmpty(listHVOs)) {
				return listHVOs.get(0);
			}
		}
		return null;
	}

	@Override
	public WebAppResult updateWhstransVO(JsonBill jsonBill, SessionInfo sessionInfo) throws Exception {
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
			WhstransHVO hvo = null;
			List<WhstransBVO> insertListBVOs = null;
			List<WhstransBVO> updateListBVOs = null;
			List<WhstransBVO> deleteListBVOs = null;
			List<WhstransBVO> realyListBVOs = new ArrayList<>();
			if (MMStringUtil.isNotEmpty(head)) {
				hvo = JsonUtils.jsonToPojo(head, WhstransHVO.class);
			}
			if (MMStringUtil.isNotEmpty(insertBodys)) {
				insertListBVOs = JsonUtils.jsonToList(insertBodys, WhstransBVO.class);
			}
			if (MMStringUtil.isNotEmpty(updataBodys)) {
				updateListBVOs = JsonUtils.jsonToList(updataBodys, WhstransBVO.class);
			}
			if (MMStringUtil.isNotEmpty(deleteBodys)) {
				deleteListBVOs = JsonUtils.jsonToList(deleteBodys, WhstransBVO.class);
			}
			if (MMStringUtil.isNotEmpty(realyBodys)) {
				realyListBVOs = JsonUtils.jsonToList(realyBodys, WhstransBVO.class);
			}

			// 在UI删除表体数据的时候，选中行删除，UI会把选中的数据同时当做修改和删除的数据使用，
			// 为了解决这个问题，在后台修改保存的时候在修改VO集合中把状态为删除的记录清除
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs) && MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (WhstransBVO dbvo : deleteListBVOs) {
					Iterator<WhstransBVO> iterator = updateListBVOs.iterator();
					while (iterator.hasNext()) {
						WhstransBVO ubvo = iterator.next();
						if (MMStringUtil.isEqual(dbvo.getId(), ubvo.getId())) {
							iterator.remove();
						}
					}
				}
			}

			// 保存前规则
			beforeWhstransUpdateRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));
			checkStoreDoceRule.process(hvo);

			beforeWhstransSaveOrUpdateCheckRule.process(hvo, MMArrayUtil.toArray(realyListBVOs));

			beforeWhstransBodySaveRule.process(hvo, MMArrayUtil.toArray(insertListBVOs));

			beforeWhstransBodyUpdateRule.process(hvo, MMArrayUtil.toArray(updateListBVOs));

			/**
			 * 修改保存vo
			 */
			IUParamVO paramVO = new IUParamVO();
			paramVO.setCuserid(sessionInfo.getId());
			String hid = hvo.getId();
			WhstransHVO dbHVO = whstransHVOMapper.selectByPrimaryKey(hid);
			if (PojoTools.canBeforeUpdate(hvo.getTs(), dbHVO.getTs())) {
				PojoTools.beforeUpdate(WhstransHVO.class, hvo, paramVO);
				whstransHVOMapper.updateByPrimaryKey(hvo);
			}

			if (MMCollectionUtil.isNotEmpty(insertListBVOs)) {
				for (WhstransBVO bvo : insertListBVOs) {
					bvo.setHid(hid);
					PojoTools.beforeInsert(WhstransBVO.class, bvo);
					whstransBVOMapper.insert(bvo);
				}
			}
			if (MMCollectionUtil.isNotEmpty(updateListBVOs)) {
				for (WhstransBVO bvo : updateListBVOs) {
					WhstransBVO dbBvo = whstransBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeUpdate(WhstransBVO.class, bvo);
						whstransBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(deleteListBVOs)) {
				for (WhstransBVO bvo : deleteListBVOs) {
					WhstransBVO dbBvo = whstransBVOMapper.selectByPrimaryKey(bvo.getId());
					if (PojoTools.canBeforeUpdate(bvo.getTs(), dbBvo.getTs())) {
						PojoTools.beforeDelete(WhstransBVO.class, bvo);
						whstransBVOMapper.updateByPrimaryKey(bvo);
					}
				}
			}
			return WebAppResult.ok(hid);
		}
		return WebAppResult.build(500, "转库单修改保存报错");
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
			List<WhstransHVO> listPojoTs = JsonUtils.jsonToList(data, WhstransHVO.class);
			if (listPojoTs.size() > 1000) {
				throw new RuntimeException("每次只能操作1000条数据，请检查!");
			}
			if (MMCollectionUtil.isNotEmpty(listPojoTs)) {

				for (WhstransHVO jspHVO : listPojoTs) {
					String id = jspHVO.getId();
					String jspts = jspHVO.getTs();

					WhstransHVO dbHVO = whstransHVOMapper.selectByPrimaryKey(id);
					if (PojoTools.canBeforeUpdate(jspts, dbHVO.getTs())) {
						listIds.add(id);
					}
				}
			}
		}
		return listIds;
	}

	@Override
	public WebAppResult deleteWhstransVOs(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			// 删除hvo
			whstransHVOMapper.deleteByPrimaryKeys(listIds);
			// 删除bvos
			whstransBVOMapper.deleteByHeadPrimaryKeys(listIds);
			return WebAppResult.ok();
		}
		return WebAppResult.build(500, "删除失败！");
	}

	@Override
	public WebAppResult batchApprove(JsonTS jsonTS, SessionInfo sessionInfo) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 转库单审批 需要将订单状态变为审批态
			 */
			WhstransHVOExample example = new WhstransHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<WhstransHVO> listWhstransHVOs = whstransHVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listWhstransHVOs)) {
				for (WhstransHVO whstransHVO : listWhstransHVOs) {
					IUParamVO paramVO = new IUParamVO();
					paramVO.setCuserid(sessionInfo.getId());
					paramVO.setYeDate(sessionInfo.getNowDate());
					PojoTools.beforeApprove(WhstransHVO.class, whstransHVO, paramVO);
					whstransHVOMapper.updateByPrimaryKey(whstransHVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult unBatchApprove(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			/**
			 * 转库单弃审 需要将订单状态变自由态
			 */
			WhstransHVOExample example = new WhstransHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<WhstransHVO> listWhstransHVOs = whstransHVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listWhstransHVOs)) {
				for (WhstransHVO whstransHVO : listWhstransHVOs) {
					PojoTools.beforeUnApprove(WhstransHVO.class, whstransHVO);
					whstransHVOMapper.updateByPrimaryKey(whstransHVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

	@Override
	public WebAppResult unSyncData(JsonTS jsonTS) throws Exception {
		List<String> listIds = this.checkTs(jsonTS);
		if (MMCollectionUtil.isNotEmpty(listIds)) {
			WhstransHVOExample example = new WhstransHVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdIn(listIds);
			List<WhstransHVO> listHVOs = whstransHVOMapper.selectByExample(example);
			for (WhstransHVO hvo : listHVOs) {
				hvo.setIssync((short) 0);
				whstransHVOMapper.updateByPrimaryKey(hvo);
			}
			WhstransBVOExample bvoExample = new WhstransBVOExample();
			com.fgc.pojo.WhstransBVOExample.Criteria bvocriteria = bvoExample.createCriteria();
			bvocriteria.andHidIn(listIds);
			bvocriteria.andDrEqualTo(MMNCUtils.getDR(0));
			List<WhstransBVO> listBVOs = whstransBVOMapper.selectByExample(bvoExample);

			if (MMCollectionUtil.isNotEmpty(listBVOs)) {
				for (WhstransBVO whstransBVO : listBVOs) {
					whstransBVO.setIssync((short) 0);
					whstransBVOMapper.updateByPrimaryKey(whstransBVO);
				}
			}
			return WebAppResult.ok();
		}
		return null;
	}

}
