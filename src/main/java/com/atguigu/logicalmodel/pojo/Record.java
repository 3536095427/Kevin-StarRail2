package com.atguigu.logicalmodel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {

    private Integer id;
    private String start;
    private String end;
    private Integer distance;
    private Integer time;
    private Integer money;

}
