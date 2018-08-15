package com.fgc.mapper;

import com.fgc.pojo.ManualVO;
import com.fgc.pojo.ManualVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManualVOMapper {
    int countByExample(ManualVOExample example);

    int deleteByExample(ManualVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ManualVO record);

    int insertSelective(ManualVO record);

    List<ManualVO> selectByExample(ManualVOExample example);

    ManualVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ManualVO record, @Param("example") ManualVOExample example);

    int updateByExample(@Param("record") ManualVO record, @Param("example") ManualVOExample example);

    int updateByPrimaryKeySelective(ManualVO record);

    int updateByPrimaryKey(ManualVO record);
}