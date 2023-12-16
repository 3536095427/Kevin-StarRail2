package com.atguigu.logicalmodel.Mapper;

import com.atguigu.logicalmodel.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {

    int addOrder(Order order);

    List<Order> getOrderByOwnerId(@Param("ownerId") int ownerId);

    @Delete("delete from `order` where order_id = #{orderId};")
    int deleteOrderByOrderId(@Param("orderId")String orderId);

    @Update("update `order` set payment_status = 1 where order_id = #{orderId};")
    int payOrder(@Param("orderId")String orderId);
}
