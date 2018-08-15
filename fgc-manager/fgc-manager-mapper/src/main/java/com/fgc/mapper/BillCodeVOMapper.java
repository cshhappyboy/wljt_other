package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.BillCodeVO;
import com.fgc.pojo.BillCodeVOExample;

public interface BillCodeVOMapper {
    int countByExample(BillCodeVOExample example);

    int deleteByExample(BillCodeVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(BillCodeVO record);

    int insertSelective(BillCodeVO record);

    List<BillCodeVO> selectByExample(BillCodeVOExample example);

    BillCodeVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BillCodeVO record, @Param("example") BillCodeVOExample example);

    int updateByExample(@Param("record") BillCodeVO record, @Param("example") BillCodeVOExample example);

    int updateByPrimaryKeySelective(BillCodeVO record);

    int updateByPrimaryKey(BillCodeVO record);
    
}