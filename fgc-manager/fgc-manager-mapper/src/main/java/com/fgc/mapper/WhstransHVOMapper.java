package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.WhstransHVO;
import com.fgc.pojo.WhstransHVOExample;

public interface WhstransHVOMapper {
    int countByExample(WhstransHVOExample example);

    int deleteByExample(WhstransHVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(WhstransHVO record);

    int insertSelective(WhstransHVO record);

    List<WhstransHVO> selectByExample(WhstransHVOExample example);

    WhstransHVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WhstransHVO record, @Param("example") WhstransHVOExample example);

    int updateByExample(@Param("record") WhstransHVO record, @Param("example") WhstransHVOExample example);

    int updateByPrimaryKeySelective(WhstransHVO record);

    int updateByPrimaryKey(WhstransHVO record);
    
    void deleteByPrimaryKeys(@Param("ids")List<String> ids);
}