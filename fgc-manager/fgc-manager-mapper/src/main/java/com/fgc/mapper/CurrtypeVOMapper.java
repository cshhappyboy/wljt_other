package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.CurrtypeVO;
import com.fgc.pojo.CurrtypeVOExample;

public interface CurrtypeVOMapper {
    int countByExample(CurrtypeVOExample example);

    int deleteByExample(CurrtypeVOExample example);

    int deleteByPrimaryKey(String pkcurrtype);

    int insert(CurrtypeVO record);

    int insertSelective(CurrtypeVO record);

    List<CurrtypeVO> selectByExample(CurrtypeVOExample example);

    CurrtypeVO selectByPrimaryKey(String pkcurrtype);

    int updateByExampleSelective(@Param("record") CurrtypeVO record, @Param("example") CurrtypeVOExample example);

    int updateByExample(@Param("record") CurrtypeVO record, @Param("example") CurrtypeVOExample example);

    int updateByPrimaryKeySelective(CurrtypeVO record);

    int updateByPrimaryKey(CurrtypeVO record);
}