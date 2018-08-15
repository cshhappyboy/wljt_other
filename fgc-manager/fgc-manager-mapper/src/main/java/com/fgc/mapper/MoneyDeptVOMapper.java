package com.fgc.mapper;

import com.fgc.pojo.MoneyDeptVO;
import com.fgc.pojo.MoneyDeptVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyDeptVOMapper {
    int countByExample(MoneyDeptVOExample example);

    int deleteByExample(MoneyDeptVOExample example);

    int insert(MoneyDeptVO record);

    int insertSelective(MoneyDeptVO record);

    List<MoneyDeptVO> selectByExample(MoneyDeptVOExample example);

    int updateByExampleSelective(@Param("record") MoneyDeptVO record, @Param("example") MoneyDeptVOExample example);

    int updateByExample(@Param("record") MoneyDeptVO record, @Param("example") MoneyDeptVOExample example);
    
    List<MoneyDeptVO> selectDistinctByExample(MoneyDeptVOExample example);
}