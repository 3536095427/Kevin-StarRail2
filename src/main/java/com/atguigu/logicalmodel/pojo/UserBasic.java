package com.atguigu.logicalmodel.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBasic {
    private Integer id;
    private String name;
    private String password;

    @TableField(exist = false)
    private UserDetail userDetail;

    public UserBasic(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

}
