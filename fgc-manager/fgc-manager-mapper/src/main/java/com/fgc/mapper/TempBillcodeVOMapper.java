package com.fgc.mapper;

import com.fgc.pojo.TempBillcodeVO;
import com.fgc.pojo.TempBillcodeVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempBillcodeVOMapper {
    int countByExample(TempBillcodeVOExample example);

    int deleteByExample(TempBillcodeVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(TempBillcodeVO record);

    int insertSelective(TempBillcodeVO record);

    List<TempBillcodeVO> selectByExample(TempBillcodeVOExample example);

    TempBillcodeVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TempBillcodeVO record, @Param("example") TempBillcodeVOExample example);

    int updateByExample(@Param("record") TempBillcodeVO record, @Param("example") TempBillcodeVOExample example);

    int updateByPrimaryKeySelective(TempBillcodeVO record);

    int updateByPrimaryKey(TempBillcodeVO record);
}