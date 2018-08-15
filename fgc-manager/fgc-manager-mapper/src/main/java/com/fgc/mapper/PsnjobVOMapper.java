package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.PsnjobVO;
import com.fgc.pojo.PsnjobVOExample;

public interface PsnjobVOMapper {
    int countByExample(PsnjobVOExample example);

    int deleteByExample(PsnjobVOExample example);

    int deleteByPrimaryKey(String pkpsnjob);

    int insert(PsnjobVO record);

    int insertSelective(PsnjobVO record);

    List<PsnjobVO> selectByExample(PsnjobVOExample example);

    PsnjobVO selectByPrimaryKey(String pkpsnjob);

    int updateByExampleSelective(@Param("record") PsnjobVO record, @Param("example") PsnjobVOExample example);

    int updateByExample(@Param("record") PsnjobVO record, @Param("example") PsnjobVOExample example);

    int updateByPrimaryKeySelective(PsnjobVO record);

    int updateByPrimaryKey(PsnjobVO record);
}