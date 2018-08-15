package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.InoutBusiClassVO;
import com.fgc.pojo.InoutBusiClassVOExample;

public interface InoutBusiClassVOMapper {
    int countByExample(InoutBusiClassVOExample example);

    int deleteByExample(InoutBusiClassVOExample example);

    int deleteByPrimaryKey(String pkinoutbusiclass);

    int insert(InoutBusiClassVO record);

    int insertSelective(InoutBusiClassVO record);

    List<InoutBusiClassVO> selectByExample(InoutBusiClassVOExample example);

    InoutBusiClassVO selectByPrimaryKey(String pkinoutbusiclass);

    int updateByExampleSelective(@Param("record") InoutBusiClassVO record, @Param("example") InoutBusiClassVOExample example);

    int updateByExample(@Param("record") InoutBusiClassVO record, @Param("example") InoutBusiClassVOExample example);

    int updateByPrimaryKeySelective(InoutBusiClassVO record);

    int updateByPrimaryKey(InoutBusiClassVO record);
}