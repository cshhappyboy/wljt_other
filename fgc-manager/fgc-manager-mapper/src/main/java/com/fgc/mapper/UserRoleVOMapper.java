package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.UserRoleVO;
import com.fgc.pojo.UserRoleVOExample;

public interface UserRoleVOMapper {
    int countByExample(UserRoleVOExample example);

    int deleteByExample(UserRoleVOExample example);

    int insert(UserRoleVO record);

    int insertSelective(UserRoleVO record);

    List<UserRoleVO> selectByExample(UserRoleVOExample example);

    int updateByExampleSelective(@Param("record") UserRoleVO record, @Param("example") UserRoleVOExample example);

    int updateByExample(@Param("record") UserRoleVO record, @Param("example") UserRoleVOExample example);
}