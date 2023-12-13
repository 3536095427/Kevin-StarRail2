package com.atguigu.logicalmodel.Service;

import com.atguigu.logicalmodel.pojo.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketService {
    List<Ticket> generateRandomTickets(LocalDate startDate, String startStation, String destinationStation,int generateNum);

    Ticket getTicketById(String ticketId);

    int addTicket(Ticket ticket);


}
