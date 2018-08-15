package com.fgc.service.whstrans.impl.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransHVO;
import com.pub.utils.AggVO;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 单据转换工具类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月24日
 *
 *     未来离线需求
 */
@Component
public class WhstransChangeUtils {

	/**
	 * 将VO聚合
	 * 
	 * @param listHVOs
	 * @param listBVOs
	 * @return AggVO<OrderHVO, OrderBVO>
	 */
	public List<AggVO<WhstransHVO, WhstransBVO>> aggVOs(List<WhstransHVO> listHVOs, List<WhstransBVO> listBVOs) {
		List<AggVO<WhstransHVO, WhstransBVO>> listAggVOs = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			AggVO<WhstransHVO, WhstransBVO> aggVO = null;
			for (WhstransHVO hvo : listHVOs) {
				aggVO = new AggVO<>();
				String id = hvo.getId();
				List<WhstransBVO> list = null;
				if (MMCollectionUtil.isNotEmpty(listBVOs)) {
					list = new ArrayList<>();
					for (WhstransBVO bvo : listBVOs) {
						String hid = bvo.getHid();
						if (MMStringUtil.isEqual(id, hid)) {
							list.add(bvo);
						}
					}
				}
				aggVO.setHeadVO(hvo);
				aggVO.setBodyVOs(MMArrayUtil.toArray(list));
				listAggVOs.add(aggVO);
			}
		}
		return listAggVOs;
	}
}
