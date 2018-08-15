package com.fgc.service.saleout.impl.util;

import java.util.ArrayList;
import java.util.List;

import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutHVO;
import com.pub.utils.AggVO;
import com.pub.utils.MMArrayUtil;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;

/**
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年4月2日
 *
 *     未来离线需求
 */

public class SaleOutChangeUtils {
	/**
	 * @param list
	 * @param listBVOs
	 * @return
	 */
	public static List<AggVO<SaleOutHVO, SaleOutBVO>> aggVOs(List<SaleOutHVO> listHVOs, List<SaleOutBVO> listBVOs) {
		List<AggVO<SaleOutHVO, SaleOutBVO>> listAggVOs = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listHVOs)) {
			AggVO<SaleOutHVO, SaleOutBVO> aggVO = null;
			for (SaleOutHVO hvo : listHVOs) {
				aggVO = new AggVO<>();
				String id = hvo.getId();
				List<SaleOutBVO> list = null;
				if (MMCollectionUtil.isNotEmpty(listBVOs)) {
					list = new ArrayList<>();
					for (SaleOutBVO bvo : listBVOs) {
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
