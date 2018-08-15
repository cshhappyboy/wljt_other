package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.UserDeptVO;
import com.fgc.pojo.UserDeptVOExample;

public interface UserDeptVOMapper {
    int countByExample(UserDeptVOExample example);

    int deleteByExample(UserDeptVOExample example);

    int insert(UserDeptVO record);

    int insertSelective(UserDeptVO record);

    List<UserDeptVO> selectByExample(UserDeptVOExample example);

    int updateByExampleSelective(@Param("record") UserDeptVO record, @Param("example") UserDeptVOExample example);

    int updateByExample(@Param("record") UserDeptVO record, @Param("example") UserDeptVOExample example);
}