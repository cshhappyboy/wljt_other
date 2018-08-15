package com.fgc.mapper;

import com.fgc.pojo.MoneyVO;
import com.fgc.pojo.MoneyVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyVOMapper {
    int countByExample(MoneyVOExample example);

    int deleteByExample(MoneyVOExample example);

    int insert(MoneyVO record);

    int insertSelective(MoneyVO record);

    List<MoneyVO> selectByExample(MoneyVOExample example);

    int updateByExampleSelective(@Param("record") MoneyVO record, @Param("example") MoneyVOExample example);

    int updateByExample(@Param("record") MoneyVO record, @Param("example") MoneyVOExample example);
}