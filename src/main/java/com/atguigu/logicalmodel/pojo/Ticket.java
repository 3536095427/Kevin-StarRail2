package com.atguigu.logicalmodel.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private String ticketId;

    private String startStation;

    private String destinationStation;

    private int distance;

    private int time;

    private int price;

    private String pathInfo;
}
