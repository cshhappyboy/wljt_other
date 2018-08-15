package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.ResVO;
import com.fgc.pojo.ResVOExample;

public interface ResVOMapper {
    int countByExample(ResVOExample example);

    int deleteByExample(ResVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResVO record);

    int insertSelective(ResVO record);

    List<ResVO> selectByExample(ResVOExample example);

    ResVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResVO record, @Param("example") ResVOExample example);

    int updateByExample(@Param("record") ResVO record, @Param("example") ResVOExample example);

    int updateByPrimaryKeySelective(ResVO record);

    int updateByPrimaryKey(ResVO record);
    
    List<String> queryResIDByUserId(@Param("cuserid")String cuserid);
    
}