package com.fgc.service.billcode.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.BillCodeVOMapper;
import com.fgc.mapper.DeptVOMapper;
import com.fgc.mapper.TempBillcodeVOMapper;
import com.fgc.mapper.TempEffectBillcodeVOMapper;
import com.fgc.pojo.BillCodeVO;
import com.fgc.pojo.BillCodeVOExample;
import com.fgc.pojo.BillCodeVOExample.Criteria;
import com.fgc.pojo.DeptVO;
import com.fgc.pojo.TempBillcodeVO;
import com.fgc.pojo.TempEffectBillcodeVO;
import com.fgc.service.billcode.IBillCodeService;
import com.fgc.service.pub.IPubInfoService;
import com.pub.utils.IDUtils;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 单据号规则实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月24日
 *
 *     未来离线需求
 */
@Service
public class BillCodeServiceImpl implements IBillCodeService {

	@Autowired
	private IPubInfoService pubInfoService;

	private String LOCK_FLAG = "lock";

	@Autowired
	private BillCodeVOMapper billCodeVOMapper;

	@Autowired
	private TempBillcodeVOMapper tempBillcodeVOMapper;

	@Autowired
	private TempEffectBillcodeVOMapper tempEffectBillcodeVOMapper;

	@Override
	public synchronized List<String> generateBillCode(String billtype, String billflag, int size) throws Exception {
		String pb = pubInfoService.getValueByCode("PREFIX_BILLCODE");
		if (pb.length() != 2) {
			throw new RuntimeException("单据号前缀组织编码只能2位数！");
		}
		BillCodeVOExample example = new BillCodeVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andBillflagEqualTo(billflag);

		List<BillCodeVO> listBillCodes = billCodeVOMapper.selectByExample(example);

		String nowDate = MMNCUtils.getNowDate();
		Long maxFlow = 0L;
		List<String> listBillcodes = new ArrayList<>();
		StringBuffer sBuffer = null;

		if (MMCollectionUtil.isEmpty(listBillCodes)) {
			for (int i = 0; i < size; i++) {
				maxFlow++;
				sBuffer = new StringBuffer();
				sBuffer.append(pubInfoService.getValueByCode("PREFIX_BILLCODE"));
				sBuffer.append(billtype);
				sBuffer.append(MMNCUtils.getShortNowDate());
				sBuffer.append(getFourLengthCode(maxFlow));

				TempBillcodeVO tempBillcodeVO = new TempBillcodeVO();
				tempBillcodeVO.setId(IDUtils.genId());
				tempBillcodeVO.setTs(MMNCUtils.getNowTime());
				tempBillcodeVO.setVbillcode(sBuffer.toString());
				tempBillcodeVOMapper.insert(tempBillcodeVO);

				listBillcodes.add(sBuffer.toString());
			}
			BillCodeVO billCodeVO = new BillCodeVO();
			billCodeVO.setId(IDUtils.genId());
			billCodeVO.setBillflag(billflag);
			billCodeVO.setDt(nowDate);
			billCodeVO.setFlow(maxFlow);

			billCodeVOMapper.insert(billCodeVO);
		} else {
			BillCodeVO billCodeVO = listBillCodes.get(0);
			String dt = billCodeVO.getDt();
			if (MMStringUtil.isEqual(nowDate, dt)) {
				maxFlow = billCodeVO.getFlow();
			}
			for (int i = 0; i < size; i++) {
				maxFlow++;
				sBuffer = new StringBuffer();
				sBuffer.append(pb);
				sBuffer.append(billtype);
				sBuffer.append(MMNCUtils.getShortNowDate());
				sBuffer.append(getFourLengthCode(maxFlow));

				TempBillcodeVO tempBillcodeVO = new TempBillcodeVO();
				tempBillcodeVO.setId(IDUtils.genId());
				tempBillcodeVO.setTs(MMNCUtils.getNowTime());
				tempBillcodeVO.setVbillcode(sBuffer.toString());
				tempBillcodeVOMapper.insert(tempBillcodeVO);

				listBillcodes.add(sBuffer.toString());
			}
			billCodeVO.setDt(nowDate);
			billCodeVO.setFlow(maxFlow);

			billCodeVOMapper.updateByPrimaryKey(billCodeVO);
		}
		return listBillcodes;
	}

	@Override
	public String generateBillCode(String billtype, String billflag) throws Exception {
		List<String> listBillcodes = this.generateBillCode(billtype, billflag, 1);
		return listBillcodes.get(0);
	}

	@Autowired
	private DeptVOMapper deptVOMapper;

	private Map<String, String> mapDeptData = new HashMap<>();

	private static String EFFECT_BILLCODE_FLAG = "EFFECTBILLCODE";

	@Override
	public synchronized String generateEffectBillCode(String cdept) throws Exception {
		String pb = pubInfoService.getValueByCode("PREFIX_BILLCODE");
		String year = MMNCUtils.getYear();
		String deptMark = null;
		DeptVO deptVO = deptVOMapper.selectByPrimaryKey(cdept);
		if (MMValueUtils.isNotEmpty(deptVO)) {
			deptMark = deptVO.getVdef1();
			mapDeptData.put(deptVO.getPkdept(), deptVO.getVdef1());
		}

		BillCodeVOExample example = new BillCodeVOExample();
		Criteria criteria = example.createCriteria();
		criteria.andBillflagEqualTo(EFFECT_BILLCODE_FLAG);

		List<BillCodeVO> listBillCodes = billCodeVOMapper.selectByExample(example);
		Long flow = 0L;
		if (MMCollectionUtil.isEmpty(listBillCodes)) {
			flow++;
			BillCodeVO billCodeVO = new BillCodeVO();
			billCodeVO.setId(IDUtils.genId());
			billCodeVO.setBillflag(EFFECT_BILLCODE_FLAG);
			billCodeVO.setDt(MMNCUtils.getShortNowDate());
			billCodeVO.setFlow(flow);
			billCodeVOMapper.insert(billCodeVO);

			String effectbillcode = pb + year + deptMark + this.getSixLengthCode(flow);

			TempEffectBillcodeVO tempEffectBillcodeVO = new TempEffectBillcodeVO();
			tempEffectBillcodeVO.setId(IDUtils.genId());
			tempEffectBillcodeVO.setTs(MMNCUtils.getNowTime());
			tempEffectBillcodeVO.setEffectbillcode(effectbillcode);
			tempEffectBillcodeVOMapper.insert(tempEffectBillcodeVO);

			return effectbillcode;
		} else {
			BillCodeVO billCodeVO = listBillCodes.get(0);
			Long maxflow = billCodeVO.getFlow();
			maxflow++;
			billCodeVO.setFlow(maxflow);
			billCodeVOMapper.updateByPrimaryKey(billCodeVO);
			String effectbillcode = pb + year + deptMark + this.getSixLengthCode(maxflow);

			TempEffectBillcodeVO tempEffectBillcodeVO = new TempEffectBillcodeVO();
			tempEffectBillcodeVO.setId(IDUtils.genId());
			tempEffectBillcodeVO.setTs(MMNCUtils.getNowTime());
			tempEffectBillcodeVO.setEffectbillcode(effectbillcode);
			tempEffectBillcodeVOMapper.insert(tempEffectBillcodeVO);

			return effectbillcode;
		}
	}

	private String getSixLengthCode(Long value) {
		String flowCode = String.format("%06d", value);
		return flowCode;
	}

	private String getFourLengthCode(Long value) {
		String flowCode = String.format("%04d", value);
		return flowCode;
	}

}
