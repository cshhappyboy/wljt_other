package com.fgc.service.report.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.MoneyDetailVOMapper;
import com.fgc.mapper.ReceiptHVOMapper;
import com.fgc.pojo.MoneyDetailVO;
import com.fgc.pojo.MoneyDetailVOExample;
import com.fgc.pojo.MoneyDetailVOExample.Criteria;
import com.fgc.pojo.ReceiptHVO;
import com.fgc.pojo.ReceiptHVOExample;
import com.fgc.service.bd.utils.IDTrans2NameUtils;
import com.fgc.service.report.IReceiptPortService;
import com.pub.model.Local;
import com.pub.model.SessionInfo;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMNCUtils;
import com.pub.utils.MMNumberUtil;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月10日
 *
 *     未来离线需求
 */
@Service
public class ReceiptPortServiceImpl implements IReceiptPortService {

	@Autowired
	private MoneyDetailVOMapper moneyDetailVOMapper;

	@Autowired
	private IDTrans2NameUtils trans2NameUtils;

	@Autowired
	private ReceiptHVOMapper receiptHVOMapper;

	@Override
	public List<MoneyDetailVO> queryDetailVO(MoneyDetailVO moneyDetailVO, SessionInfo sessionInfo) throws Exception {
		List<MoneyDetailVO> listDetailVOs = new ArrayList<>();
		if (MMStringUtil.isNotEmpty(moneyDetailVO.getDbilldate())
				&& MMStringUtil.isNotEmpty(moneyDetailVO.getCdept())) {
			MoneyDetailVOExample example = new MoneyDetailVOExample();
			Criteria criteria = example.createCriteria();
			criteria.andDbilldateEqualTo(moneyDetailVO.getDbilldate());
			// 部门、
			String cdept = moneyDetailVO.getCdept();
			List<String> dataDept = sessionInfo.getDataDept();
			if (MMCollectionUtil.isNotEmpty(dataDept)) {
				if (MMStringUtil.isNotEmpty(cdept)) {
					if (dataDept.contains(cdept)) {
						criteria.andCdeptEqualTo(cdept);
					} else {
						criteria.andCdeptEqualTo("###");
					}
				} else {
					criteria.andCdeptIn(dataDept);
				}
			} else {
				criteria.andCdeptEqualTo("###");
			}
			if (MMStringUtil.isNotEmpty(moneyDetailVO.getBillmaker())) {
				criteria.andBillmakerLike("%"+moneyDetailVO.getBillmaker()+"%");
			}
			if (MMStringUtil.isNotEmpty(moneyDetailVO.getSohbillmaker())) {
				criteria.andSohbillmakerLike("%"+moneyDetailVO.getSohbillmaker()+"%");
			}
			listDetailVOs = moneyDetailVOMapper.selectByExample(example);
			if (MMCollectionUtil.isNotEmpty(listDetailVOs)) {
				MoneyDetailVO total = new MoneyDetailVO();
				BigDecimal yushou = BigDecimal.ZERO;
				BigDecimal fapiao = BigDecimal.ZERO;
				BigDecimal fapiaoTotal = BigDecimal.ZERO;
				for (MoneyDetailVO mDetailVO : listDetailVOs) {
					String ddh = mDetailVO.getDdh();
					if (MMStringUtil.isNotEmpty(ddh)) {
						ReceiptHVOExample receiptHVOExample = new ReceiptHVOExample();
						com.fgc.pojo.ReceiptHVOExample.Criteria createCriteria = receiptHVOExample.createCriteria();
						createCriteria.andVorderbillcodeEqualTo(ddh);
						createCriteria.andDrEqualTo(MMNCUtils.getDR(0));

						List<ReceiptHVO> listReceiptHVO = receiptHVOMapper.selectByExample(receiptHVOExample);
						if (MMCollectionUtil.isNotEmpty(listReceiptHVO)) {
							BigDecimal sumTotal = BigDecimal.ZERO;
							String effectbillcode = null;
							for (ReceiptHVO hvo : listReceiptHVO) {
								sumTotal = MMNumberUtil.add(sumTotal, hvo.getTotal());
								effectbillcode = hvo.getEffectbillcode();
							}
							mDetailVO.setRnreceivedmny(sumTotal);
							mDetailVO.setBah(effectbillcode);
						}
					}

					yushou = MMNumberUtil.add(yushou, mDetailVO.getSkje());
					fapiao = MMNumberUtil.add(fapiao, mDetailVO.getWk());
					fapiaoTotal = MMNumberUtil.add(fapiaoTotal, mDetailVO.getFpzje());
				}
				total.setDbilldate("总计");
				total.setFpzje(fapiaoTotal);
				total.setSkje(yushou);
				total.setWk(fapiao);
				total.setFph(MMNumberUtil.add(yushou, fapiao).toString());
				listDetailVOs.add(total);
			}
			
			trans2NameUtils.transHVO(MoneyDetailVO.class, listDetailVOs, Local.CH);
			
		}
		return listDetailVOs;
	}

}
