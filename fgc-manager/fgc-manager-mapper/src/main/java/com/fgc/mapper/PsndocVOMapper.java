package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.PsndocVO;
import com.fgc.pojo.PsndocVOExample;

public interface PsndocVOMapper {
    int countByExample(PsndocVOExample example);

    int deleteByExample(PsndocVOExample example);

    int deleteByPrimaryKey(String pkpsndoc);

    int insert(PsndocVO record);

    int insertSelective(PsndocVO record);

    List<PsndocVO> selectByExample(PsndocVOExample example);

    PsndocVO selectByPrimaryKey(String pkpsndoc);

    int updateByExampleSelective(@Param("record") PsndocVO record, @Param("example") PsndocVOExample example);

    int updateByExample(@Param("record") PsndocVO record, @Param("example") PsndocVOExample example);

    int updateByPrimaryKeySelective(PsndocVO record);

    int updateByPrimaryKey(PsndocVO record);
}