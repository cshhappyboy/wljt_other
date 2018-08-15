package com.fgc.service.manaul.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.ManualVOMapper;
import com.fgc.pojo.ManualVO;
import com.fgc.pojo.ManualVOExample;
import com.fgc.service.manaul.IManualService;
import com.fgc.service.pub.IPubInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.HttpClientUtil;
import com.pub.utils.IDUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.WebAppResult;

/**
 * 服务实现
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月13日
 *
 *     未来离线需求
 */
@Service
public class ManualServiceImpl implements IManualService {

	@Autowired
	private IPubInfoService pubInfoService;

	@Autowired
	private ManualVOMapper manualVOMapper;

	@Override
	public EUDataGridResult queryData() throws Exception {
		ManualVOExample example = new ManualVOExample();
		example.setOrderByClause("name asc");
		PageHelper.startPage(EUDataGridResult.E_U_STARTPAGE, EUDataGridResult.E_U_PAGESIZE);

		List<ManualVO> listVOs = manualVOMapper.selectByExample(example);

		PageInfo<ManualVO> info = new PageInfo<>(listVOs);

		EUDataGridResult result = new EUDataGridResult();
		result.setRows(info.getList());
		result.setTotal(info.getTotal());

		return result;
	}

	@Override
	public WebAppResult saveData(ManualVO manualVO) throws Exception {
		manualVO.setId(IDUtils.genId());
		manualVOMapper.insert(manualVO);
		return WebAppResult.ok();
	}

	@Override
	public WebAppResult updateData(ManualVO manualVO) throws Exception {
		manualVOMapper.updateByPrimaryKey(manualVO);
		return WebAppResult.ok();
	}

	@Override
	public WebAppResult deleteData(String id) throws Exception {
		manualVOMapper.deleteByPrimaryKey(id);
		return WebAppResult.ok();
	}

	@Override
	public ManualVO queryDataById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			ManualVO manualVO = manualVOMapper.selectByPrimaryKey(id);
			return manualVO;
		}
		return null;
	}

	private String[] PKS = { "10011523682683891355", "10011523682864102107", "10011523683764668246",
			"10011523685267068755", "10011523685319085902", "10152647363428089300" };

	@Override
	public WebAppResult syncManual(ManualVO manualVO) throws Exception {
		String id = manualVO.getId();
		for (String pk : PKS) {
			if (MMStringUtil.isEqual(pk, id)) {
				String value = pubInfoService.getValueByCode("TIMING_TASK_LOCK");
				if (MMStringUtil.isEqual("Y", value)) {
					throw new RuntimeException("提示:定时任务已经开启,请先关闭再手动同步!");
				}
			}
		}

		String url = manualVO.getUrl();
		String urlPath = pubInfoService.getValueByCode("SYNC_MODEL_URL") + url;
		String beginDate = manualVO.getBeginDate();
		String endDate = manualVO.getEndDate();

		Map<String, String> param = new HashMap<>();
		if (MMStringUtil.isNotEmpty(beginDate) && MMStringUtil.isNotEmpty(endDate)) {
			param.put("begintime", beginDate);
			param.put("endtime", endDate);
		}
		String result = HttpClientUtil.doGet(urlPath, param);
		return WebAppResult.build(200, result);
	}

}
