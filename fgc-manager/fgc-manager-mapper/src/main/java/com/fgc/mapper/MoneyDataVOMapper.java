package com.fgc.mapper;

import com.fgc.pojo.MoneyDataVO;
import com.fgc.pojo.MoneyDataVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyDataVOMapper {
    int countByExample(MoneyDataVOExample example);

    int deleteByExample(MoneyDataVOExample example);

    int insert(MoneyDataVO record);

    int insertSelective(MoneyDataVO record);

    List<MoneyDataVO> selectByExample(MoneyDataVOExample example);

    int updateByExampleSelective(@Param("record") MoneyDataVO record, @Param("example") MoneyDataVOExample example);

    int updateByExample(@Param("record") MoneyDataVO record, @Param("example") MoneyDataVOExample example);
}