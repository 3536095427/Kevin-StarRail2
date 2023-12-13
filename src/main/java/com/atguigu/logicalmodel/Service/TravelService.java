package com.atguigu.logicalmodel.Service;

import com.atguigu.logicalmodel.pojo.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TravelService {


    int[] getPathArray(String type, String beginStation, String destinationStation);

    int[] getPathByArray(int[] front, Integer start, Integer destination);

    int getTotalLenByPath(int[] pathArray);

    int getTotalMoneyByPath(int[] pathArray);

    int getTotalTimeByPath(int[] pathArray);

    String getPathStationInfo(int[] pathArray);

    List<Ticket> getTicketFactor(LocalDate startDate, String startStation, String destinationStation);
}
