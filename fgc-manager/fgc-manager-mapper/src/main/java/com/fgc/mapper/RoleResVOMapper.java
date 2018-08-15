package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.RoleResVO;
import com.fgc.pojo.RoleResVOExample;

public interface RoleResVOMapper {
    int countByExample(RoleResVOExample example);

    int deleteByExample(RoleResVOExample example);

    int insert(RoleResVO record);

    int insertSelective(RoleResVO record);

    List<RoleResVO> selectByExample(RoleResVOExample example);

    int updateByExampleSelective(@Param("record") RoleResVO record, @Param("example") RoleResVOExample example);

    int updateByExample(@Param("record") RoleResVO record, @Param("example") RoleResVOExample example);
}