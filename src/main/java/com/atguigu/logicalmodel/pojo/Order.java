package com.atguigu.logicalmodel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderId;
    private UserBasic owner;
    private String passengerName;
    private String passengerId;
    private LocalDateTime generateTime;
    private int paymentStatus;
    private Ticket ticket;
}
