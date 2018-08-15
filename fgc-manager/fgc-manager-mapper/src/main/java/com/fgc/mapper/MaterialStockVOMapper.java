package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.MaterialStockVO;
import com.fgc.pojo.MaterialStockVOExample;

public interface MaterialStockVOMapper {
    int countByExample(MaterialStockVOExample example);

    int deleteByExample(MaterialStockVOExample example);

    int deleteByPrimaryKey(String pkmaterialstock);

    int insert(MaterialStockVO record);

    int insertSelective(MaterialStockVO record);

    List<MaterialStockVO> selectByExample(MaterialStockVOExample example);

    MaterialStockVO selectByPrimaryKey(String pkmaterialstock);

    int updateByExampleSelective(@Param("record") MaterialStockVO record, @Param("example") MaterialStockVOExample example);

    int updateByExample(@Param("record") MaterialStockVO record, @Param("example") MaterialStockVOExample example);

    int updateByPrimaryKeySelective(MaterialStockVO record);

    int updateByPrimaryKey(MaterialStockVO record);
}