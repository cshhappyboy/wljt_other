package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.SaleOutBVO;
import com.fgc.pojo.SaleOutBVOExample;

public interface SaleOutBVOMapper {
    int countByExample(SaleOutBVOExample example);

    int deleteByExample(SaleOutBVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(SaleOutBVO record);

    int insertSelective(SaleOutBVO record);

    List<SaleOutBVO> selectByExample(SaleOutBVOExample example);

    SaleOutBVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SaleOutBVO record, @Param("example") SaleOutBVOExample example);

    int updateByExample(@Param("record") SaleOutBVO record, @Param("example") SaleOutBVOExample example);

    int updateByPrimaryKeySelective(SaleOutBVO record);

    int updateByPrimaryKey(SaleOutBVO record);
    
    void deleteByHeadPrimaryKeys(@Param("ids")List<String> ids);

}