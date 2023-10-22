package com.atguigu.logicalmodel.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    private Integer id;
    private Integer origin;
    private Integer destination;

    @TableField("time")
    private Integer spendTime;
    private Integer distance;
    private Integer money;

    public Travel(int id) {
        this.id = id;
    }

}
