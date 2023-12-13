package com.atguigu.logicalmodel.Mapper;

import com.atguigu.logicalmodel.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    int addOrder(Order order);

    Order getOrderByOwnerID(@Param("ownerId") String ownerId);
}
