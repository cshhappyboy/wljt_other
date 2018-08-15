package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.MaterialVO;
import com.fgc.pojo.MaterialVOExample;

public interface MaterialVOMapper {
    int countByExample(MaterialVOExample example);

    int deleteByExample(MaterialVOExample example);

    int deleteByPrimaryKey(String pkmaterial);

    int insert(MaterialVO record);

    int insertSelective(MaterialVO record);

    List<MaterialVO> selectByExample(MaterialVOExample example);

    MaterialVO selectByPrimaryKey(String pkmaterial);

    int updateByExampleSelective(@Param("record") MaterialVO record, @Param("example") MaterialVOExample example);

    int updateByExample(@Param("record") MaterialVO record, @Param("example") MaterialVOExample example);

    int updateByPrimaryKeySelective(MaterialVO record);

    int updateByPrimaryKey(MaterialVO record);
}