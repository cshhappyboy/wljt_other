package com.fgc.mapper;

import com.fgc.pojo.UploadDocLogsVO;
import com.fgc.pojo.UploadDocLogsVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadDocLogsVOMapper {
    int countByExample(UploadDocLogsVOExample example);

    int deleteByExample(UploadDocLogsVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UploadDocLogsVO record);

    int insertSelective(UploadDocLogsVO record);

    List<UploadDocLogsVO> selectByExample(UploadDocLogsVOExample example);

    UploadDocLogsVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UploadDocLogsVO record, @Param("example") UploadDocLogsVOExample example);

    int updateByExample(@Param("record") UploadDocLogsVO record, @Param("example") UploadDocLogsVOExample example);

    int updateByPrimaryKeySelective(UploadDocLogsVO record);

    int updateByPrimaryKey(UploadDocLogsVO record);
}