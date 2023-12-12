package com.atguigu.logicalmodel.Service;


import com.atguigu.logicalmodel.pojo.UserBasic;
import com.atguigu.logicalmodel.pojo.UserDetail;

public interface UserBasicService {
    UserBasic Login(Integer loginID, String password);

    UserDetail getUserDetailById(Integer id);


}
