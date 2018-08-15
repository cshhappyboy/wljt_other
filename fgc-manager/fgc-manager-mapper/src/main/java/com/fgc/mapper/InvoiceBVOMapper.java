package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.InvoiceBVO;
import com.fgc.pojo.InvoiceBVOExample;

public interface InvoiceBVOMapper {
    int countByExample(InvoiceBVOExample example);

    int deleteByExample(InvoiceBVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(InvoiceBVO record);

    int insertSelective(InvoiceBVO record);

    List<InvoiceBVO> selectByExample(InvoiceBVOExample example);

    InvoiceBVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InvoiceBVO record, @Param("example") InvoiceBVOExample example);

    int updateByExample(@Param("record") InvoiceBVO record, @Param("example") InvoiceBVOExample example);

    int updateByPrimaryKeySelective(InvoiceBVO record);

    int updateByPrimaryKey(InvoiceBVO record);
    
    void deleteByHeadPrimaryKeys(@Param("ids")List<String> ids);

}