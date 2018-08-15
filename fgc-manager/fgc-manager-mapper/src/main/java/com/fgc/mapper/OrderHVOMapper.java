package com.fgc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fgc.pojo.OrderHVO;
import com.fgc.pojo.OrderHVOExample;

public interface OrderHVOMapper {
	int countByExample(OrderHVOExample example);

	int deleteByExample(OrderHVOExample example);

	int deleteByPrimaryKey(String id);

	int insert(OrderHVO record);

	int insertSelective(OrderHVO record);

	List<OrderHVO> selectByExample(OrderHVOExample example);

	OrderHVO selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") OrderHVO record, @Param("example") OrderHVOExample example);

	int updateByExample(@Param("record") OrderHVO record, @Param("example") OrderHVOExample example);

	int updateByPrimaryKeySelective(OrderHVO record);

	int updateByPrimaryKey(OrderHVO record);

	void deleteByPrimaryKeys(@Param("ids") List<String> ids);
	
	void blackOutByPrimaryKeys(@Param("ids") List<String> ids);
}