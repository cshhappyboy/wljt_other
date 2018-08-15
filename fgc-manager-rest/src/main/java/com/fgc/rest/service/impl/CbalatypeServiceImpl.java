package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.BalaTypeVOMapper;
import com.fgc.pojo.BalaTypeVO;
import com.fgc.pojo.BalaTypeVOExample;
import com.fgc.pojo.databsase.Billtype;
import com.fgc.rest.service.ICbalatypeService;
import com.pub.model.Local;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Service
public class CbalatypeServiceImpl implements ICbalatypeService {

	@Autowired
	private BalaTypeVOMapper balaTypeVOMapper;

	@Override
	public List<Billtype> queryData(String local) throws Exception {
		List<BalaTypeVO> listData = balaTypeVOMapper.selectByExample(new BalaTypeVOExample());

		List<Billtype> list = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listData)) {
			Billtype billtype = null;
			for (BalaTypeVO balaTypeVO : listData) {
				billtype = new Billtype();
				billtype.setBilltype_id(balaTypeVO.getPkbalatype());
				String name = "";
				if (MMStringUtil.isEqual(local, Local.CH)) {
					name = balaTypeVO.getName();
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					name = balaTypeVO.getVdef10();
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					name = balaTypeVO.getVdef11();
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					name = balaTypeVO.getVdef12();
				}
				billtype.setBilltype_name(name);
				list.add(billtype);
			}
		}
		return list;
	}

	@Override
	public WebAppResult queryNameById(String id, String local) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			BalaTypeVO balaTypeVO = balaTypeVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(balaTypeVO)) {
				String name = null;
				if (MMStringUtil.isEqual(local, Local.CH)) {
					name = balaTypeVO.getName();
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					name = balaTypeVO.getVdef10();
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					name = balaTypeVO.getVdef11();
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					name = balaTypeVO.getVdef12();
				}
				return WebAppResult.ok(name);
			}
		}
		return null;
	}

}
