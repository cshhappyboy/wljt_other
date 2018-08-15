package com.fgc.mapper;

import com.fgc.pojo.UserWarehouseVO;
import com.fgc.pojo.UserWarehouseVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWarehouseVOMapper {
    int countByExample(UserWarehouseVOExample example);

    int deleteByExample(UserWarehouseVOExample example);

    int insert(UserWarehouseVO record);

    int insertSelective(UserWarehouseVO record);

    List<UserWarehouseVO> selectByExample(UserWarehouseVOExample example);

    int updateByExampleSelective(@Param("record") UserWarehouseVO record, @Param("example") UserWarehouseVOExample example);

    int updateByExample(@Param("record") UserWarehouseVO record, @Param("example") UserWarehouseVOExample example);
}