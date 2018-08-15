package com.fgc.mapper;

import com.fgc.pojo.PubParamVO;
import com.fgc.pojo.PubParamVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PubParamVOMapper {
    int countByExample(PubParamVOExample example);

    int deleteByExample(PubParamVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(PubParamVO record);

    int insertSelective(PubParamVO record);

    List<PubParamVO> selectByExample(PubParamVOExample example);

    PubParamVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PubParamVO record, @Param("example") PubParamVOExample example);

    int updateByExample(@Param("record") PubParamVO record, @Param("example") PubParamVOExample example);

    int updateByPrimaryKeySelective(PubParamVO record);

    int updateByPrimaryKey(PubParamVO record);
}