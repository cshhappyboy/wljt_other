package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.BalaTypeVO;
import com.fgc.pojo.BalaTypeVOExample;

public interface BalaTypeVOMapper {
    int countByExample(BalaTypeVOExample example);

    int deleteByExample(BalaTypeVOExample example);

    int deleteByPrimaryKey(String pkbalatype);

    int insert(BalaTypeVO record);

    int insertSelective(BalaTypeVO record);

    List<BalaTypeVO> selectByExample(BalaTypeVOExample example);

    BalaTypeVO selectByPrimaryKey(String pkbalatype);

    int updateByExampleSelective(@Param("record") BalaTypeVO record, @Param("example") BalaTypeVOExample example);

    int updateByExample(@Param("record") BalaTypeVO record, @Param("example") BalaTypeVOExample example);

    int updateByPrimaryKeySelective(BalaTypeVO record);

    int updateByPrimaryKey(BalaTypeVO record);
}