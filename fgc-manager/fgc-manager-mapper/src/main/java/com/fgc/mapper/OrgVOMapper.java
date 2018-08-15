package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.OrgVO;
import com.fgc.pojo.OrgVOExample;

public interface OrgVOMapper {
    int countByExample(OrgVOExample example);

    int deleteByExample(OrgVOExample example);

    int deleteByPrimaryKey(String pkorg);

    int insert(OrgVO record);

    int insertSelective(OrgVO record);

    List<OrgVO> selectByExample(OrgVOExample example);

    OrgVO selectByPrimaryKey(String pkorg);

    int updateByExampleSelective(@Param("record") OrgVO record, @Param("example") OrgVOExample example);

    int updateByExample(@Param("record") OrgVO record, @Param("example") OrgVOExample example);

    int updateByPrimaryKeySelective(OrgVO record);

    int updateByPrimaryKey(OrgVO record);
}