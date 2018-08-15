package com.fgc.service.upload.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.UploadBillLogsVOMapper;
import com.fgc.mapper.UploadDocLogsVOMapper;
import com.fgc.pojo.UploadBillLogsVO;
import com.fgc.pojo.UploadBillLogsVOExample;
import com.fgc.pojo.UploadDocLogsVO;
import com.fgc.pojo.UploadDocLogsVOExample;
import com.fgc.service.upload.ILogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pub.utils.EUDataGridResult;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月30日
 *
 *     未来离线需求
 */
@Service
public class LogServiceImpl implements ILogService {

	@Autowired
	private UploadDocLogsVOMapper uploadDocLogsVOMapper;

	@Autowired
	private UploadBillLogsVOMapper uploadBillLogsVOMapper;

	@Override
	public EUDataGridResult queryDocData(int page, int rows) throws Exception {
		UploadDocLogsVOExample example = new UploadDocLogsVOExample();
		example.setOrderByClause("executetime desc");
		PageHelper.startPage(page, rows);

		List<UploadDocLogsVO> listDocVOs = uploadDocLogsVOMapper.selectByExample(example);

		PageInfo<UploadDocLogsVO> info = new PageInfo<>(listDocVOs);

		EUDataGridResult result = new EUDataGridResult();
		result.setRows(info.getList());
		result.setTotal(info.getTotal());

		return result;
	}

	@Override
	public EUDataGridResult queryBillData(int page, int rows) throws Exception {
		UploadBillLogsVOExample example = new UploadBillLogsVOExample();
		example.setOrderByClause("executetime desc,lastuploadtime desc");
		PageHelper.startPage(page, rows);

		List<UploadBillLogsVO> listDocVOs = uploadBillLogsVOMapper.selectByExample(example);

		PageInfo<UploadBillLogsVO> info = new PageInfo<>(listDocVOs);

		EUDataGridResult result = new EUDataGridResult();
		result.setRows(info.getList());
		result.setTotal(info.getTotal());

		return result;
	}

}
