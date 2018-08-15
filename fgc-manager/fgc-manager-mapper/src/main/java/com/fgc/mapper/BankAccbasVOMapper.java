package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.BankAccbasVO;
import com.fgc.pojo.BankAccbasVOExample;

public interface BankAccbasVOMapper {
    int countByExample(BankAccbasVOExample example);

    int deleteByExample(BankAccbasVOExample example);

    int deleteByPrimaryKey(String pkbankaccbas);

    int insert(BankAccbasVO record);

    int insertSelective(BankAccbasVO record);

    List<BankAccbasVO> selectByExample(BankAccbasVOExample example);

    BankAccbasVO selectByPrimaryKey(String pkbankaccbas);

    int updateByExampleSelective(@Param("record") BankAccbasVO record, @Param("example") BankAccbasVOExample example);

    int updateByExample(@Param("record") BankAccbasVO record, @Param("example") BankAccbasVOExample example);

    int updateByPrimaryKeySelective(BankAccbasVO record);

    int updateByPrimaryKey(BankAccbasVO record);
}