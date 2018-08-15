package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.WhstransBVO;
import com.fgc.pojo.WhstransBVOExample;

public interface WhstransBVOMapper {
    int countByExample(WhstransBVOExample example);

    int deleteByExample(WhstransBVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(WhstransBVO record);

    int insertSelective(WhstransBVO record);

    List<WhstransBVO> selectByExample(WhstransBVOExample example);

    WhstransBVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WhstransBVO record, @Param("example") WhstransBVOExample example);

    int updateByExample(@Param("record") WhstransBVO record, @Param("example") WhstransBVOExample example);

    int updateByPrimaryKeySelective(WhstransBVO record);

    int updateByPrimaryKey(WhstransBVO record);
    
    void deleteByHeadPrimaryKeys(@Param("ids")List<String> ids);

}