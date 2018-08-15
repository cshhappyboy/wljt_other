package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.MaterialSaleVO;
import com.fgc.pojo.MaterialSaleVOExample;

public interface MaterialSaleVOMapper {
    int countByExample(MaterialSaleVOExample example);

    int deleteByExample(MaterialSaleVOExample example);

    int deleteByPrimaryKey(String pkmaterialsale);

    int insert(MaterialSaleVO record);

    int insertSelective(MaterialSaleVO record);

    List<MaterialSaleVO> selectByExample(MaterialSaleVOExample example);

    MaterialSaleVO selectByPrimaryKey(String pkmaterialsale);

    int updateByExampleSelective(@Param("record") MaterialSaleVO record, @Param("example") MaterialSaleVOExample example);

    int updateByExample(@Param("record") MaterialSaleVO record, @Param("example") MaterialSaleVOExample example);

    int updateByPrimaryKeySelective(MaterialSaleVO record);

    int updateByPrimaryKey(MaterialSaleVO record);
}