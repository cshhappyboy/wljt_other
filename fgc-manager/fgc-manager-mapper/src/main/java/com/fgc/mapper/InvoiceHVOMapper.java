package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.InvoiceHVO;
import com.fgc.pojo.InvoiceHVOExample;

public interface InvoiceHVOMapper {
    int countByExample(InvoiceHVOExample example);

    int deleteByExample(InvoiceHVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(InvoiceHVO record);

    int insertSelective(InvoiceHVO record);

    List<InvoiceHVO> selectByExample(InvoiceHVOExample example);

    InvoiceHVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InvoiceHVO record, @Param("example") InvoiceHVOExample example);

    int updateByExample(@Param("record") InvoiceHVO record, @Param("example") InvoiceHVOExample example);

    int updateByPrimaryKeySelective(InvoiceHVO record);

    int updateByPrimaryKey(InvoiceHVO record);
    
    void deleteByPrimaryKeys(@Param("ids")List<String> ids);

}