package com.fgc.rest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.fgc.mapper.MarBasClassVOMapper;
import com.fgc.mapper.MaterialVOMapper;
import com.fgc.mapper.MeasdocVOMapper;
import com.fgc.pojo.MarBasClassVO;
import com.fgc.pojo.MarBasClassVOExample;
import com.fgc.pojo.MarBasClassVOExample.Criteria;
import com.fgc.pojo.MaterialVO;
import com.fgc.pojo.MaterialVOExample;
import com.fgc.pojo.MeasdocVO;
import com.fgc.pojo.databsase.BaseDataVO;
import com.fgc.rest.service.ICmaterialService;
import com.fgc.rest.service.impl.utils.EffcetBillCodeRule;
import com.pub.model.Local;
import com.pub.model.Tree;
import com.pub.utils.EUDataGridResult;
import com.pub.utils.MMCollectionUtil;
import com.pub.utils.MMStringUtil;
import com.pub.utils.MMValueUtils;
import com.pub.utils.WebAppResult;

/**
 * 实现类
 * 
 * @开发者 ^_^ 张佳宾 *_*<br>
 *
 * @时间 2018年3月1日
 *
 *     未来离线需求
 */
@Service
public class CmaterialServiceImpl implements ICmaterialService {

	@Autowired
	private EffcetBillCodeRule effcetBillCodeRule;

	@Autowired
	private MeasdocVOMapper measdocVOMapper;

	@Autowired
	private MarBasClassVOMapper marBasClassVOMapper;

	@Autowired
	private MaterialVOMapper materialVOMapper;

	@Override
	public List<Tree> queryClassData(String filterData, String id) throws Exception {
		List<Tree> listTree = new ArrayList<Tree>();

		MarBasClassVOExample example = new MarBasClassVOExample();
		example.setOrderByClause("code");
		Criteria criteria = example.createCriteria();
		criteria.andVdef4EqualTo("2");
		if (MMStringUtil.isNotEmpty(id)) {
			criteria.andPkparentEqualTo(id);
		} else {
			criteria.andPkparentIsNull();
		}

		if (MMStringUtil.isNotEmpty(filterData)) {
			criteria.andCodeLike("%" + filterData + "%");

			Criteria createCriteria = example.createCriteria();

			example.or(createCriteria);

			if (MMStringUtil.isNotEmpty(id)) {
				createCriteria.andPkparentEqualTo(id);
			}
			createCriteria.andNameLike("%" + filterData + "%");
		}

		List<MarBasClassVO> listMarBasClassVOs = marBasClassVOMapper.selectByExample(example);
		if (MMCollectionUtil.isNotEmpty(listMarBasClassVOs)) {
			for (MarBasClassVO marBasClassVO : listMarBasClassVOs) {
				Tree tree = new Tree();
				tree.setId(marBasClassVO.getPkmarbasclass());
				if (MMStringUtil.isNotEmpty(marBasClassVO.getPkparent())) {
					tree.setPid(marBasClassVO.getPkparent());
				}
				tree.setState("closed");
				tree.setText(marBasClassVO.getCode() + "  " + marBasClassVO.getName());
				tree.setIconCls("shape_square");

				Map<String, String> attr = new HashMap<>();
				attr.put("name", marBasClassVO.getName());
				tree.setAttributes(attr);
				listTree.add(tree);
			}
		}
		return listTree;
	}

	@Override
	public EUDataGridResult queryCmaterilaData(String filterData, String classId, String local) throws Exception {
		MaterialVOExample example = new MaterialVOExample();
		example.setOrderByClause("code");
		com.fgc.pojo.MaterialVOExample.Criteria mCriteria = example.createCriteria();
		mCriteria.andVdef4EqualTo("2");
		if (MMStringUtil.isNotEmpty(classId)) {
			mCriteria.andPkmarbasclassEqualTo(classId);
		}
		if (MMStringUtil.isNotEmpty(filterData)) {
			mCriteria.andCodeLike("%" + filterData + "%");

			com.fgc.pojo.MaterialVOExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andNameLike("%" + filterData + "%");
			if (MMStringUtil.isNotEmpty(classId)) {
				createCriteria.andVdef4EqualTo("2");
				createCriteria.andPkmarbasclassEqualTo(classId);
			}
			example.or(createCriteria);
		}
		List<MaterialVO> listCustomers = materialVOMapper.selectByExample(example);

		List<BaseDataVO> listBDs = new ArrayList<>();

		if (MMCollectionUtil.isNotEmpty(listCustomers)) {
			BaseDataVO bd = null;
			for (MaterialVO materialVO : listCustomers) {
				bd = new BaseDataVO();
				bd.setId(materialVO.getPkmaterial());
				bd.setCode(materialVO.getCode());
				String mName = null;
				if (MMStringUtil.isEqual(local, Local.CH)) {
					mName = materialVO.getName();
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					mName = materialVO.getEname();
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					mName = materialVO.getMaterialshortname();
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					mName = materialVO.getMaterialmnecode();
				}
				bd.setName(mName);
				bd.setSpec(materialVO.getVdef20());
				bd.setType(materialVO.getMaterialtype());
				bd.setVunitratio(materialVO.getVdef2() == null ? "1/1" : materialVO.getVdef2());
				bd.setMeasrate(materialVO.getMeasrate());
				bd.setFumeasdoc(materialVO.getFumeasdoc());
				bd.setZhumeasdoc(materialVO.getZhumeasdoc());
				String funame = transMeasdocById(materialVO.getFumeasdoc());
				bd.setFumeasdocname(funame);
				String zhuname = transMeasdocById(materialVO.getZhumeasdoc());
				bd.setZhumeasdocname(zhuname);
				bd.setXiaoshoumeasdoc(
						materialVO.getVdef1() == null ? materialVO.getFumeasdoc() : materialVO.getVdef1());
				String xiaoshoumeasdocname = transMeasdocById(
						materialVO.getVdef1() == null ? materialVO.getFumeasdoc() : materialVO.getVdef1());
				bd.setXiaoshoumeasdocname(xiaoshoumeasdocname);
				bd.setFee(materialVO.getFee().equals("N") ? "0" : "1");

				if (effcetBillCodeRule.isCan(materialVO.getPkmaterial())) {
					bd.setIsBatch("1");
				} else {
					bd.setIsBatch("0");
				}
				listBDs.add(bd);
			}
		}
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(listBDs);
		result.setTotal(listBDs.size());
		return result;
	}

	@Override
	public WebAppResult transCmaterialCodeById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MaterialVO materialVO = materialVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(materialVO)) {
				String mcode = materialVO.getCode();
				return WebAppResult.ok(mcode);
			}
		}
		return null;
	}

	@Override
	public WebAppResult transCmaterialNameById(String id, String local) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MaterialVO materialVO = materialVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(materialVO)) {
				String mName = null;
				if (MMStringUtil.isEqual(local, Local.CH)) {
					mName = materialVO.getName();
				} else if (MMStringUtil.isEqual(local, Local.EN)) {
					mName = materialVO.getEname();
				} else if (MMStringUtil.isEqual(local, Local.FR)) {
					mName = materialVO.getMaterialshortname();
				} else if (MMStringUtil.isEqual(local, Local.MJ)) {
					mName = materialVO.getMaterialmnecode();
				}
				return WebAppResult.ok(mName);
			}
		}
		return null;
	}

	@Override
	public WebAppResult transCmaterialSpecById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MaterialVO materialVO = materialVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(materialVO)) {
				String value = materialVO.getVdef20();
				return WebAppResult.ok(value);
			}
		}
		return null;
	}

	@Override
	public WebAppResult transCmaterialTypeById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MaterialVO materialVO = materialVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(materialVO)) {
				String value = materialVO.getMaterialtype();
				return WebAppResult.ok(value);
			}
		}
		return null;
	}

	@Override
	public WebAppResult transCmaterialMeasdocById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MaterialVO materialVO = materialVOMapper.selectByPrimaryKey(id);
			if (MMValueUtils.isNotEmpty(materialVO)) {
				String value = materialVO.getFumeasdoc();

				MeasdocVO measdocVO = measdocVOMapper.selectByPrimaryKey(value);
				String mname = measdocVO.getName();

				JSONObject json = new JSONObject();
				json.put("id", value);
				json.put("name", mname);
				return WebAppResult.ok(JSONUtils.toJSONString(json));
			}
		}
		return null;
	}

	private String transMeasdocById(String id) throws Exception {
		if (MMStringUtil.isNotEmpty(id)) {
			MeasdocVO measdocVO = measdocVOMapper.selectByPrimaryKey(id);
			String mname = measdocVO.getName();
			return mname;
		}
		return null;
	}

}
