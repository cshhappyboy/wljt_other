package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.OrderBVO;
import com.fgc.pojo.OrderBVOExample;

public interface OrderBVOMapper {
    int countByExample(OrderBVOExample example);

    int deleteByExample(OrderBVOExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderBVO record);

    int insertSelective(OrderBVO record);

    List<OrderBVO> selectByExample(OrderBVOExample example);

    OrderBVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderBVO record, @Param("example") OrderBVOExample example);

    int updateByExample(@Param("record") OrderBVO record, @Param("example") OrderBVOExample example);

    int updateByPrimaryKeySelective(OrderBVO record);

    int updateByPrimaryKey(OrderBVO record);
    
    void deleteByHeadPrimaryKeys(@Param("ids")List<String> ids);
    
}