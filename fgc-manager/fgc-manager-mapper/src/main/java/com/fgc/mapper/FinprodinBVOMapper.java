package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.FinprodinBVO;
import com.fgc.pojo.FinprodinBVOExample;

public interface FinprodinBVOMapper {
    int countByExample(FinprodinBVOExample example);

    int deleteByExample(FinprodinBVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(FinprodinBVO record);

    int insertSelective(FinprodinBVO record);

    List<FinprodinBVO> selectByExample(FinprodinBVOExample example);

    FinprodinBVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FinprodinBVO record, @Param("example") FinprodinBVOExample example);

    int updateByExample(@Param("record") FinprodinBVO record, @Param("example") FinprodinBVOExample example);

    int updateByPrimaryKeySelective(FinprodinBVO record);

    int updateByPrimaryKey(FinprodinBVO record);
    
    void deleteByHeadPrimaryKeys(@Param("ids")List<String> ids);

}