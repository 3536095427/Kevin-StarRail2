package com.atguigu.logicalmodel.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private String ticketId;

    private String startStation;

    private String destinationStation;

    private LocalDateTime startTime;

    private LocalDateTime arrivalTime;

    private int distance;

    private LocalTime time;

    private int price;

    private String pathInfo;

    public Ticket(String startStation, String destinationStation, LocalDateTime startTime, int distance, LocalTime time, int price, String pathInfo) {
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.startTime = startTime;
        this.distance = distance;
        this.time = time;
        this.price = price;
        this.pathInfo = pathInfo;
    }
}
