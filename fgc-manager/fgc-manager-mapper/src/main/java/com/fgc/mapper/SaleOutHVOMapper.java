package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.SaleOutHVO;
import com.fgc.pojo.SaleOutHVOExample;

public interface SaleOutHVOMapper {
    int countByExample(SaleOutHVOExample example);

    int deleteByExample(SaleOutHVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(SaleOutHVO record);

    int insertSelective(SaleOutHVO record);

    List<SaleOutHVO> selectByExample(SaleOutHVOExample example);

    SaleOutHVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SaleOutHVO record, @Param("example") SaleOutHVOExample example);

    int updateByExample(@Param("record") SaleOutHVO record, @Param("example") SaleOutHVOExample example);

    int updateByPrimaryKeySelective(SaleOutHVO record);

    int updateByPrimaryKey(SaleOutHVO record);
    
    void deleteByPrimaryKeys(@Param("ids")List<String> ids);

}