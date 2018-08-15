package com.fgc.mapper;

import com.fgc.pojo.MoneyDetailVO;
import com.fgc.pojo.MoneyDetailVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyDetailVOMapper {
    int countByExample(MoneyDetailVOExample example);

    int deleteByExample(MoneyDetailVOExample example);

    int insert(MoneyDetailVO record);

    int insertSelective(MoneyDetailVO record);

    List<MoneyDetailVO> selectByExample(MoneyDetailVOExample example);

    int updateByExampleSelective(@Param("record") MoneyDetailVO record, @Param("example") MoneyDetailVOExample example);

    int updateByExample(@Param("record") MoneyDetailVO record, @Param("example") MoneyDetailVOExample example);
}