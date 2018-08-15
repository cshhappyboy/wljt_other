package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.ReceiptHVO;
import com.fgc.pojo.ReceiptHVOExample;

public interface ReceiptHVOMapper {
    int countByExample(ReceiptHVOExample example);

    int deleteByExample(ReceiptHVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ReceiptHVO record);

    int insertSelective(ReceiptHVO record);

    List<ReceiptHVO> selectByExample(ReceiptHVOExample example);

    ReceiptHVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ReceiptHVO record, @Param("example") ReceiptHVOExample example);

    int updateByExample(@Param("record") ReceiptHVO record, @Param("example") ReceiptHVOExample example);

    int updateByPrimaryKeySelective(ReceiptHVO record);

    int updateByPrimaryKey(ReceiptHVO record);
    
    void deleteByPrimaryKeys(@Param("ids")List<String> ids);

}