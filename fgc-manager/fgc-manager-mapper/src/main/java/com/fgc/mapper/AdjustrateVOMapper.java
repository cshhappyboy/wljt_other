package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.AdjustrateVO;
import com.fgc.pojo.AdjustrateVOExample;

public interface AdjustrateVOMapper {
    int countByExample(AdjustrateVOExample example);

    int deleteByExample(AdjustrateVOExample example);

    int deleteByPrimaryKey(String pkadjustrate);

    int insert(AdjustrateVO record);

    int insertSelective(AdjustrateVO record);

    List<AdjustrateVO> selectByExample(AdjustrateVOExample example);

    AdjustrateVO selectByPrimaryKey(String pkadjustrate);

    int updateByExampleSelective(@Param("record") AdjustrateVO record, @Param("example") AdjustrateVOExample example);

    int updateByExample(@Param("record") AdjustrateVO record, @Param("example") AdjustrateVOExample example);

    int updateByPrimaryKeySelective(AdjustrateVO record);

    int updateByPrimaryKey(AdjustrateVO record);

}