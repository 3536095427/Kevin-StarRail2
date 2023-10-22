package com.atguigu.logicalmodel.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Station {

    private Integer id;
    private String name;

    @TableField(exist = false)
    private List<Travel> travels;

    public Station(Integer id) {
        this.id = id;
    }

}