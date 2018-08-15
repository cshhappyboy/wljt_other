package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.OnhandNumVO;
import com.fgc.pojo.OnhandNumVOExample;

public interface OnhandNumVOMapper {
    int countByExample(OnhandNumVOExample example);

    int deleteByExample(OnhandNumVOExample example);

    int deleteByPrimaryKey(String pkonhandnum);

    int insert(OnhandNumVO record);

    int insertSelective(OnhandNumVO record);

    List<OnhandNumVO> selectByExample(OnhandNumVOExample example);

    OnhandNumVO selectByPrimaryKey(String pkonhandnum);

    int updateByExampleSelective(@Param("record") OnhandNumVO record, @Param("example") OnhandNumVOExample example);

    int updateByExample(@Param("record") OnhandNumVO record, @Param("example") OnhandNumVOExample example);

    int updateByPrimaryKeySelective(OnhandNumVO record);

    int updateByPrimaryKey(OnhandNumVO record);
}