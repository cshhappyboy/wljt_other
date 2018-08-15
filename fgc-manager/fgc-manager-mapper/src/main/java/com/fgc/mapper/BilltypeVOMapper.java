package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.BilltypeVO;
import com.fgc.pojo.BilltypeVOExample;

public interface BilltypeVOMapper {
    int countByExample(BilltypeVOExample example);

    int deleteByExample(BilltypeVOExample example);

    int deleteByPrimaryKey(String pkbilltypeid);

    int insert(BilltypeVO record);

    int insertSelective(BilltypeVO record);

    List<BilltypeVO> selectByExample(BilltypeVOExample example);

    BilltypeVO selectByPrimaryKey(String pkbilltypeid);

    int updateByExampleSelective(@Param("record") BilltypeVO record, @Param("example") BilltypeVOExample example);

    int updateByExample(@Param("record") BilltypeVO record, @Param("example") BilltypeVOExample example);

    int updateByPrimaryKeySelective(BilltypeVO record);

    int updateByPrimaryKey(BilltypeVO record);
}