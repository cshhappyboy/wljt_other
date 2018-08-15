package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.RoleVO;
import com.fgc.pojo.RoleVOExample;

public interface RoleVOMapper {
    int countByExample(RoleVOExample example);

    int deleteByExample(RoleVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleVO record);

    int insertSelective(RoleVO record);

    List<RoleVO> selectByExample(RoleVOExample example);

    RoleVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleVO record, @Param("example") RoleVOExample example);

    int updateByExample(@Param("record") RoleVO record, @Param("example") RoleVOExample example);

    int updateByPrimaryKeySelective(RoleVO record);

    int updateByPrimaryKey(RoleVO record);
}