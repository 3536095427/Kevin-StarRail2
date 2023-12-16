package com.atguigu.logicalmodel.Service.Imp;

import cn.hutool.core.util.RandomUtil;
import com.atguigu.logicalmodel.Mapper.TicketMapper;
import com.atguigu.logicalmodel.Service.TicketService;
import com.atguigu.logicalmodel.Service.TravelService;
import com.atguigu.logicalmodel.Utils.TicketUtils;
import com.atguigu.logicalmodel.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    private TravelService travelService;

    @Autowired
    private TicketMapper ticketMapper;

    public List<Ticket> generateRandomTickets(LocalDate startDate, String startStation, String destinationStation,int generateNum){
        List<Ticket> ticketFactors = travelService.getTicketFactor(startDate, startStation, destinationStation);

        return TicketUtils.getRandomTicketsByFactor(ticketFactors, generateNum);
    }

    @Override
    public Ticket getTicketById(String ticketId) {
        return ticketMapper.getTicketById(ticketId);
    }

    @Override
    public int addTicket(Ticket ticket) {
        // 重新生成车票Id，防止无法二次购买同一车次的的车票
        ticket.setTicketId(RandomUtil.randomNumbers(8));
        return ticketMapper.addTicket(ticket);
    }
}
