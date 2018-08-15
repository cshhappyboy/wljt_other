package com.fgc.mapper;

import com.fgc.pojo.UploadBillLogsVO;
import com.fgc.pojo.UploadBillLogsVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadBillLogsVOMapper {
    int countByExample(UploadBillLogsVOExample example);

    int deleteByExample(UploadBillLogsVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(UploadBillLogsVO record);

    int insertSelective(UploadBillLogsVO record);

    List<UploadBillLogsVO> selectByExample(UploadBillLogsVOExample example);

    UploadBillLogsVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UploadBillLogsVO record, @Param("example") UploadBillLogsVOExample example);

    int updateByExample(@Param("record") UploadBillLogsVO record, @Param("example") UploadBillLogsVOExample example);

    int updateByPrimaryKeySelective(UploadBillLogsVO record);

    int updateByPrimaryKey(UploadBillLogsVO record);
}