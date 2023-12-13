package com.atguigu.logicalmodel.Mapper;

import com.atguigu.logicalmodel.pojo.Ticket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketMapper {
    Ticket getTicketById(String id);

    int addTicket(Ticket ticket);
}
