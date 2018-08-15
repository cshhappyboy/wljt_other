package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.HandNumVO;
import com.fgc.pojo.HandNumVOExample;

public interface HandNumVOMapper {
    int countByExample(HandNumVOExample example);

    int deleteByExample(HandNumVOExample example);

    int insert(HandNumVO record);

    int insertSelective(HandNumVO record);

    List<HandNumVO> selectByExample(HandNumVOExample example);

    int updateByExampleSelective(@Param("record") HandNumVO record, @Param("example") HandNumVOExample example);

    int updateByExample(@Param("record") HandNumVO record, @Param("example") HandNumVOExample example);
}