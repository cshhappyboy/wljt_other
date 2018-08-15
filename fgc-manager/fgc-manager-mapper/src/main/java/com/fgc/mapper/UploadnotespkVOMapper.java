package com.fgc.mapper;

import com.fgc.pojo.UploadnotespkVO;
import com.fgc.pojo.UploadnotespkVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadnotespkVOMapper {
    int countByExample(UploadnotespkVOExample example);

    int deleteByExample(UploadnotespkVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UploadnotespkVO record);

    int insertSelective(UploadnotespkVO record);

    List<UploadnotespkVO> selectByExample(UploadnotespkVOExample example);

    UploadnotespkVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UploadnotespkVO record, @Param("example") UploadnotespkVOExample example);

    int updateByExample(@Param("record") UploadnotespkVO record, @Param("example") UploadnotespkVOExample example);

    int updateByPrimaryKeySelective(UploadnotespkVO record);

    int updateByPrimaryKey(UploadnotespkVO record);
}