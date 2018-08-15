package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.BatchcodeVO;
import com.fgc.pojo.BatchcodeVOExample;

public interface BatchcodeVOMapper {
    int countByExample(BatchcodeVOExample example);

    int deleteByExample(BatchcodeVOExample example);

    int deleteByPrimaryKey(String pkbatchcode);

    int insert(BatchcodeVO record);

    int insertSelective(BatchcodeVO record);

    List<BatchcodeVO> selectByExample(BatchcodeVOExample example);

    BatchcodeVO selectByPrimaryKey(String pkbatchcode);

    int updateByExampleSelective(@Param("record") BatchcodeVO record, @Param("example") BatchcodeVOExample example);

    int updateByExample(@Param("record") BatchcodeVO record, @Param("example") BatchcodeVOExample example);

    int updateByPrimaryKeySelective(BatchcodeVO record);

    int updateByPrimaryKey(BatchcodeVO record);
}