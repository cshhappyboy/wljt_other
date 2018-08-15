package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.MarBasClassVO;
import com.fgc.pojo.MarBasClassVOExample;

public interface MarBasClassVOMapper {
    int countByExample(MarBasClassVOExample example);

    int deleteByExample(MarBasClassVOExample example);

    int deleteByPrimaryKey(String pkmarbasclass);

    int insert(MarBasClassVO record);

    int insertSelective(MarBasClassVO record);

    List<MarBasClassVO> selectByExample(MarBasClassVOExample example);

    MarBasClassVO selectByPrimaryKey(String pkmarbasclass);

    int updateByExampleSelective(@Param("record") MarBasClassVO record, @Param("example") MarBasClassVOExample example);

    int updateByExample(@Param("record") MarBasClassVO record, @Param("example") MarBasClassVOExample example);

    int updateByPrimaryKeySelective(MarBasClassVO record);

    int updateByPrimaryKey(MarBasClassVO record);
}