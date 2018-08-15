package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.MeasdocVO;
import com.fgc.pojo.MeasdocVOExample;

public interface MeasdocVOMapper {
    int countByExample(MeasdocVOExample example);

    int deleteByExample(MeasdocVOExample example);

    int deleteByPrimaryKey(String pkmeasdoc);

    int insert(MeasdocVO record);

    int insertSelective(MeasdocVO record);

    List<MeasdocVO> selectByExample(MeasdocVOExample example);

    MeasdocVO selectByPrimaryKey(String pkmeasdoc);

    int updateByExampleSelective(@Param("record") MeasdocVO record, @Param("example") MeasdocVOExample example);

    int updateByExample(@Param("record") MeasdocVO record, @Param("example") MeasdocVOExample example);

    int updateByPrimaryKeySelective(MeasdocVO record);

    int updateByPrimaryKey(MeasdocVO record);
}