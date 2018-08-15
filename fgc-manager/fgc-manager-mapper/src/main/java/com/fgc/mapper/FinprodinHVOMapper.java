package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.FinprodinHVO;
import com.fgc.pojo.FinprodinHVOExample;

public interface FinprodinHVOMapper {
    int countByExample(FinprodinHVOExample example);

    int deleteByExample(FinprodinHVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinprodinHVO record);

    int insertSelective(FinprodinHVO record);

    List<FinprodinHVO> selectByExample(FinprodinHVOExample example);

    FinprodinHVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinprodinHVO record, @Param("example") FinprodinHVOExample example);

    int updateByExample(@Param("record") FinprodinHVO record, @Param("example") FinprodinHVOExample example);

    int updateByPrimaryKeySelective(FinprodinHVO record);

    int updateByPrimaryKey(FinprodinHVO record);
    
    void deleteByPrimaryKeys(@Param("ids")List<String> ids);

}