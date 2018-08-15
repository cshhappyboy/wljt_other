package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.CustomerVO;
import com.fgc.pojo.CustomerVOExample;

public interface CustomerVOMapper {
    int countByExample(CustomerVOExample example);

    int deleteByExample(CustomerVOExample example);

    int deleteByPrimaryKey(String pkcustomer);

    int insert(CustomerVO record);

    int insertSelective(CustomerVO record);

    List<CustomerVO> selectByExample(CustomerVOExample example);

    CustomerVO selectByPrimaryKey(String pkcustomer);

    int updateByExampleSelective(@Param("record") CustomerVO record, @Param("example") CustomerVOExample example);

    int updateByExample(@Param("record") CustomerVO record, @Param("example") CustomerVOExample example);

    int updateByPrimaryKeySelective(CustomerVO record);

    int updateByPrimaryKey(CustomerVO record);
}