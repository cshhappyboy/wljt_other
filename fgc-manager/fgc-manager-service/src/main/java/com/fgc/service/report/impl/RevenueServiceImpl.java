package com.fgc.service.report.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.MoneyDataVOMapper;
import com.fgc.mapper.MoneyDeptVOMapper;
import com.fgc.pojo.MoneyDataVO;
import com.fgc.pojo.MoneyDataVOExample;
import com.fgc.pojo.MoneyDeptVO;
import com.fgc.pojo.MoneyDeptVOExample;
import com.fgc.pojo.MoneyDeptVOExample.Criteria;
import com.fgc.pojo.util.Money;
import com.fgc.service.report.IRevenueService;
import com.pub.model.SessionInfo;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNumberUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月9日
 *
 *     未来离线需求
 */
@Service
public class RevenueServiceImpl implements IRevenueService {

	@Autowired
	private MoneyDeptVOMapper moneyDeptVOMapper;

	@Autowired
	private MoneyDataVOMapper moneyDataVOMapper;

	@Override
	public List<Money> queryData(String year, String month, SessionInfo sessionInfo) throws Exception {
		List<Money> listMoney = new ArrayList<>();
		MoneyDeptVOExample example = new MoneyDeptVOExample();
		Criteria criteria = example.createCriteria();
		String yearMonth = year + "-" + String.format("%02d", Long.valueOf(month));
		criteria.andDbilldateBetween(yearMonth + "-01", yearMonth + "-31");
		
		List<String> dataDept = sessionInfo.getDataDept();
		if(MMCollectionUtil.isNotEmpty(dataDept)){
			criteria.andIdIn(dataDept);
		}else{
			criteria.andIdEqualTo("###");
		}
		List<MoneyDeptVO> listDeptVOs = moneyDeptVOMapper.selectDistinctByExample(example);
		BigDecimal totalZongji = BigDecimal.ZERO;
		BigDecimal totalXianjin = BigDecimal.ZERO;
		BigDecimal totalZhipiao = BigDecimal.ZERO;

		Money moneyTotalData = new Money();
		moneyTotalData.setName("总计");
		if (MMCollectionUtil.isNotEmpty(listDeptVOs)) {
			for (MoneyDeptVO moneyDeptVO : listDeptVOs) {
				Money moneyData = new Money();
				moneyData.setName(moneyDeptVO.getName());
				for (int i = 0; i < 32; i++) {
					String date = yearMonth + "-" + String.format("%02d", i);
					contractRowData4Date(moneyDeptVO, date, moneyData, i, moneyTotalData);
				}
				totalZongji = MMNumberUtil.add(totalZongji, moneyData.getRowzongji());
				totalXianjin = MMNumberUtil.add(totalXianjin, moneyData.getRowxianjinheji());
				totalZhipiao = MMNumberUtil.add(totalZhipiao, moneyData.getRowzhipiaoheji());
				listMoney.add(moneyData);
			}
			moneyTotalData.setRowzongji(totalZongji);
			moneyTotalData.setRowxianjinheji(totalXianjin);
			moneyTotalData.setRowzhipiaoheji(totalZhipiao);
			listMoney.add(moneyTotalData);
		}
		return listMoney;
	}

	/**
	 * @param listMoney
	 * @param yearMonth
	 * @param sumRowXianjin
	 * @param sumRowZhipiao
	 * @param sumRowZongji
	 * @param date
	 * @param moneyData
	 * @param i
	 * @param moneyTotalData
	 * @param id
	 * @param moneyDate
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	private void contractRowData4Date(MoneyDeptVO moneyDeptVO, String date, Money moneyData, int i,
			Money moneyTotalData) throws NoSuchMethodException, SecurityException, IllegalAccessException,
					IllegalArgumentException, InvocationTargetException {
		BigDecimal sumRowXianjin = moneyData.getRowxianjinheji();
		BigDecimal sumRowZhipiao = moneyData.getRowzhipiaoheji();
		BigDecimal sumRowZongji = moneyData.getRowzongji();

		MoneyDataVOExample moneyDataVOExample = new MoneyDataVOExample();
		com.fgc.pojo.MoneyDataVOExample.Criteria createCriteria = moneyDataVOExample.createCriteria();
		createCriteria.andPidEqualTo(moneyDeptVO.getId());
		createCriteria.andDbilldateEqualTo(date);
		List<MoneyDataVO> listDataVOs = moneyDataVOMapper.selectByExample(moneyDataVOExample);
		if (MMCollectionUtil.isNotEmpty(listDataVOs)) {
			MoneyDataVO moneyDataVO = listDataVOs.get(0);
			Class<? extends Money> clazz = moneyData.getClass();

			Method methodXianjin = clazz.getMethod("setXianjin" + i, BigDecimal.class);
			methodXianjin.invoke(moneyData, moneyDataVO.getXianjin());

			Method methodGetXianjin = clazz.getMethod("getXianjin" + i);
			BigDecimal xianjin = (BigDecimal) methodGetXianjin.invoke(moneyTotalData);
			methodXianjin.invoke(moneyTotalData, MMNumberUtil.add(xianjin, moneyDataVO.getXianjin()));

			Method methodZhipiao = clazz.getMethod("setZhipiao" + i, BigDecimal.class);
			methodZhipiao.invoke(moneyData, moneyDataVO.getZhipiao());

			Method methodGetZhipiao = clazz.getMethod("getZhipiao" + i);
			BigDecimal zhipiao = (BigDecimal) methodGetZhipiao.invoke(moneyTotalData);
			methodZhipiao.invoke(moneyTotalData, MMNumberUtil.add(zhipiao, moneyDataVO.getZhipiao()));

			Method methodXiaoji = clazz.getMethod("setXiaoji" + i, BigDecimal.class);
			methodXiaoji.invoke(moneyData, moneyDataVO.getXiaoji());

			Method methodGetXiaoji = clazz.getMethod("getXiaoji" + i);
			BigDecimal xiaoji = (BigDecimal) methodGetXiaoji.invoke(moneyTotalData);
			methodXiaoji.invoke(moneyTotalData, MMNumberUtil.add(xiaoji, moneyDataVO.getXiaoji()));

			sumRowXianjin = MMNumberUtil.add(sumRowXianjin, moneyDataVO.getXianjin());
			sumRowZhipiao = MMNumberUtil.add(sumRowZhipiao, moneyDataVO.getZhipiao());
			sumRowZongji = MMNumberUtil.add(sumRowZongji, moneyDataVO.getXiaoji());
		}
		moneyData.setRowzongji(sumRowZongji);
		moneyData.setRowxianjinheji(sumRowXianjin);
		moneyData.setRowzhipiaoheji(sumRowZhipiao);
	}
}
