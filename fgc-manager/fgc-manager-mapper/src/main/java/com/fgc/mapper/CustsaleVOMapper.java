package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.CustsaleVO;
import com.fgc.pojo.CustsaleVOExample;

public interface CustsaleVOMapper {
    int countByExample(CustsaleVOExample example);

    int deleteByExample(CustsaleVOExample example);

    int deleteByPrimaryKey(String pkcustsale);

    int insert(CustsaleVO record);

    int insertSelective(CustsaleVO record);

    List<CustsaleVO> selectByExample(CustsaleVOExample example);

    CustsaleVO selectByPrimaryKey(String pkcustsale);

    int updateByExampleSelective(@Param("record") CustsaleVO record, @Param("example") CustsaleVOExample example);

    int updateByExample(@Param("record") CustsaleVO record, @Param("example") CustsaleVOExample example);

    int updateByPrimaryKeySelective(CustsaleVO record);

    int updateByPrimaryKey(CustsaleVO record);
}