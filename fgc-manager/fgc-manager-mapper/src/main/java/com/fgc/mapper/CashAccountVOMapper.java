package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.CashAccountVO;
import com.fgc.pojo.CashAccountVOExample;

public interface CashAccountVOMapper {
    int countByExample(CashAccountVOExample example);

    int deleteByExample(CashAccountVOExample example);

    int deleteByPrimaryKey(String pkcashaccount);

    int insert(CashAccountVO record);

    int insertSelective(CashAccountVO record);

    List<CashAccountVO> selectByExample(CashAccountVOExample example);

    CashAccountVO selectByPrimaryKey(String pkcashaccount);

    int updateByExampleSelective(@Param("record") CashAccountVO record, @Param("example") CashAccountVOExample example);

    int updateByExample(@Param("record") CashAccountVO record, @Param("example") CashAccountVOExample example);

    int updateByPrimaryKeySelective(CashAccountVO record);

    int updateByPrimaryKey(CashAccountVO record);
}