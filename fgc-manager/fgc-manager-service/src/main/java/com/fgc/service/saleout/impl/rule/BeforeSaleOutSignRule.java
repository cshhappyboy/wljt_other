package com.fgc.service.saleout.impl.rule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fgc.mapper.SaleOutBVOMapper;
import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutBVOExample;
import com.fgc.pojo.SaleOutBVOExample.Criteria;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;

/**
 * 签字前校验是否有实收
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月4日
 *
 *     未来离线需求
 */
@Component
public class BeforeSaleOutSignRule {

	@Autowired
	private SaleOutBVOMapper saleOutBVOMapper;

	public void process(List<SaleOutHVO> listHVOs) throws Exception {
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			List<String> listMsg = new ArrayList<>();
			for (SaleOutHVO saleOutHVO : listHVOs) {
				String id = saleOutHVO.getId();
				String vbillcode = saleOutHVO.getVbillcode();
				if (MMStringUtil.isNotEmpty(id)) {
					SaleOutBVOExample example = new SaleOutBVOExample();
					Criteria criteria = example.createCriteria();
					criteria.andHidEqualTo(id);
					criteria.andDrEqualTo(MMNCUtils.getDR(0));
					List<SaleOutBVO> listBVOs = saleOutBVOMapper.selectByExample(example);
					if (MMCollectionUtil.isNotEmpty(listBVOs)) {
						for (SaleOutBVO saleOutBVO : listBVOs) {
							BigDecimal nassistnum = saleOutBVO.getNassistnum();
							if (MMValueUtils.isEmpty(nassistnum)) {
								listMsg.add(contractMsg(vbillcode, saleOutBVO.getMaterialcode()));
							}
						}
					}
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}

	/**
	 * 构建报错信息
	 * 
	 * @param vbillcode
	 * @param materialCode
	 * @return String
	 */
	private String contractMsg(String vbillcode, String materialCode) {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append("单据号:【" + vbillcode + "】");
		sBuilder.append("表体行物料编码:【" + materialCode + "】");
		sBuilder.append("实发数量不能为空,签字失败！");
		return sBuilder.toString();
	}

	/**
	 * @param listBVOs
	 * @param nowDate
	 */
	public void processBody(List<SaleOutBVO> listBVOs, String nowDate) {
		if (MMCollectionUtil.isNotEmpty(listBVOs)) {
			List<String> listMsg = new ArrayList<>();
			for (SaleOutBVO saleOutBVO : listBVOs) {
				String dbizdate = saleOutBVO.getDbizdate();
				if (new DateTime(nowDate).isBefore(new DateTime(dbizdate))) {
					throw new RuntimeException("签字日期必须晚于出库日期！");
				}
			}
			if (MMCollectionUtil.isNotEmpty(listMsg)) {
				throw new RuntimeException(listMsg.toString());
			}
		}
	}
}
