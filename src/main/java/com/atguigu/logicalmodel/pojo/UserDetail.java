package com.atguigu.logicalmodel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetail {

    private Integer id;
    private String name;
    private String moto;
    private String address;
    private String phone;
    private String img;
}






