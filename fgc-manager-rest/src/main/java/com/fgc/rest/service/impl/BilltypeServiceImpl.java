package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fgc.mapper.BilltypeVOMapper;
import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.BilltypeVOExample;
import com.fgc.pojo.BilltypeVOExample.Criteria;
import com.fgc.pojo.databsase.Billtype;
import com.fgc.rest.service.IBilltypeService;
import com.pub.model.Local;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.WebAppResult;

/**
 * 单据类型服务实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年2月27日
 *
 *     未来离线需求
 */
@Service
public class BilltypeServiceImpl implements IBilltypeService {

	@Autowired
	private BilltypeVOMapper billtypeVOMapper;

	@Override
	public List<Billtype> queryBilltypeData(String typeCode, String local) throws Exception {
		BilltypeVOExample example = new BilltypeVOExample();
		example.setOrderByClause("pkbilltypecode");
		Criteria criteria = example.createCriteria();
		if (MMStringUtil.isNotEmpty(typeCode) && !MMStringUtil.isEqual("00", typeCode)) {
			criteria.andPkbilltypecodeLike("%" + typeCode + "%");
		}
		List<BilltypeVO> listBilltypeVOs = billtypeVOMapper.selectByExample(example);

		List<Billtype> list = new ArrayList<>();
		if (MMCollectionUtil.isNotEmpty(listBilltypeVOs)) {
			Billtype billtype = null;
			for (BilltypeVO billtypeVO : listBilltypeVOs) {
				String billtypename = "";
				if (MMStringUtil.isEqual(local, Local.CH)) {
					billtypename = billtypeVO.getBilltypename();
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					billtypename = billtypeVO.getVdef10();
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					billtypename = billtypeVO.getVdef11();
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					billtypename = billtypeVO.getVdef12();
				}
				billtype = new Billtype();
				billtype.setBilltype_id(billtypeVO.getPkbilltypeid());
				billtype.setBilltype_name(billtypename);
				list.add(billtype);
			}
		}
		return list;
	}

	@Override
	public WebAppResult queryBilltypeNameById(String id, String local) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			BilltypeVO billtypeVO = billtypeVOMapper.selectByPrimaryKey(id);
			String billtypename = "";
			if (MMStringUtil.isEqual(local, Local.CH)) {
				billtypename = billtypeVO.getBilltypename();
			} else if (MMStringUtil.isEqual(local, Local.EN)) {
				billtypename = billtypeVO.getVdef10();
			} else if (MMStringUtil.isEqual(local, Local.FR)) {
				billtypename = billtypeVO.getVdef11();
			} else if (MMStringUtil.isEqual(local, Local.MJ)) {
				billtypename = billtypeVO.getVdef12();
			}
			return WebAppResult.ok(billtypename);
		}
		return WebAppResult.build(500, "id为空");
	}

}
