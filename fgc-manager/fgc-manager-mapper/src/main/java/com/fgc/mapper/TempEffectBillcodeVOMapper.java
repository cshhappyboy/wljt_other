package com.fgc.mapper;

import com.fgc.pojo.TempEffectBillcodeVO;
import com.fgc.pojo.TempEffectBillcodeVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TempEffectBillcodeVOMapper {
    int countByExample(TempEffectBillcodeVOExample example);

    int deleteByExample(TempEffectBillcodeVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(TempEffectBillcodeVO record);

    int insertSelective(TempEffectBillcodeVO record);

    List<TempEffectBillcodeVO> selectByExample(TempEffectBillcodeVOExample example);

    TempEffectBillcodeVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TempEffectBillcodeVO record, @Param("example") TempEffectBillcodeVOExample example);

    int updateByExample(@Param("record") TempEffectBillcodeVO record, @Param("example") TempEffectBillcodeVOExample example);

    int updateByPrimaryKeySelective(TempEffectBillcodeVO record);

    int updateByPrimaryKey(TempEffectBillcodeVO record);
}