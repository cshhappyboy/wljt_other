package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.DeptVO;
import com.fgc.pojo.DeptVOExample;

public interface DeptVOMapper {
    int countByExample(DeptVOExample example);

    int deleteByExample(DeptVOExample example);

    int deleteByPrimaryKey(String pkdept);

    int insert(DeptVO record);

    int insertSelective(DeptVO record);

    List<DeptVO> selectByExample(DeptVOExample example);

    DeptVO selectByPrimaryKey(String pkdept);

    int updateByExampleSelective(@Param("record") DeptVO record, @Param("example") DeptVOExample example);

    int updateByExample(@Param("record") DeptVO record, @Param("example") DeptVOExample example);

    int updateByPrimaryKeySelective(DeptVO record);

    int updateByPrimaryKey(DeptVO record);
}