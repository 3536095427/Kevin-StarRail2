package com.atguigu.logicalmodel.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {

    private String ticketId;

    private String startStation;

    private String destinationStation;

    private LocalDateTime startTime;

    private LocalDateTime arrivalTime;

    private String trainInfo;

    private String seatInfo;

    private int distance;

    private LocalTime time;

    private int price;

    private String pathInfo;

    public Ticket(String startStation, String destinationStation, LocalDateTime startTime, int distance, LocalTime time, int price, String pathInfo,String trainInfo,String seatInfo) {
        this.startStation = startStation;
        this.destinationStation = destinationStation;
        this.startTime = startTime;
        this.distance = distance;
        this.time = time;
        this.price = price;
        this.pathInfo = pathInfo;
        this.seatInfo = seatInfo;
        this.trainInfo = trainInfo;
    }


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
