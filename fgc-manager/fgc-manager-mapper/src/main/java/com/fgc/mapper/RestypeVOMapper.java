package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.RestypeVO;
import com.fgc.pojo.RestypeVOExample;

public interface RestypeVOMapper {
    int countByExample(RestypeVOExample example);

    int deleteByExample(RestypeVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(RestypeVO record);

    int insertSelective(RestypeVO record);

    List<RestypeVO> selectByExample(RestypeVOExample example);

    RestypeVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RestypeVO record, @Param("example") RestypeVOExample example);

    int updateByExample(@Param("record") RestypeVO record, @Param("example") RestypeVOExample example);

    int updateByPrimaryKeySelective(RestypeVO record);

    int updateByPrimaryKey(RestypeVO record);
}