package com.atguigu.logicalmodel.Mapper;

import com.atguigu.logicalmodel.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    int addOrder(Order order);

    List<Order> getOrderByOwnerID(@Param("ownerId") int ownerId);
}
