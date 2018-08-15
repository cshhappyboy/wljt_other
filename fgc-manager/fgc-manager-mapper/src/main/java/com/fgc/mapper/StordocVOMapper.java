package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.StordocVO;
import com.fgc.pojo.StordocVOExample;

public interface StordocVOMapper {
    int countByExample(StordocVOExample example);

    int deleteByExample(StordocVOExample example);

    int deleteByPrimaryKey(String pkstordoc);

    int insert(StordocVO record);

    int insertSelective(StordocVO record);

    List<StordocVO> selectByExample(StordocVOExample example);

    StordocVO selectByPrimaryKey(String pkstordoc);

    int updateByExampleSelective(@Param("record") StordocVO record, @Param("example") StordocVOExample example);

    int updateByExample(@Param("record") StordocVO record, @Param("example") StordocVOExample example);

    int updateByPrimaryKeySelective(StordocVO record);

    int updateByPrimaryKey(StordocVO record);
}