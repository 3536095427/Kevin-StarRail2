package com.atguigu.logicalmodel.Service.Imp;


import com.atguigu.logicalmodel.Mapper.UserBasicMapper;
import com.atguigu.logicalmodel.Mapper.UserDetailMapper;
import com.atguigu.logicalmodel.Service.UserBasicService;
import com.atguigu.logicalmodel.pojo.UserBasic;
import com.atguigu.logicalmodel.pojo.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service("userBasicService")
@Transactional
public class UserBasicServiceImp implements UserBasicService {

    @Autowired
    private UserBasicMapper userBasicMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;


    @Override
    public UserBasic Login(Integer loginID, String password) {
        if (loginID == null) {
            return null;
        }

        //如果根据id无法查询到userBasic
        UserBasic userBasic = userBasicMapper.selectById(loginID);

        //数据库中不存在这个用户，返回null
        if (userBasic == null) {
            return null;
        }

        //获取真实用户的密码
        String passwordGet = userBasic.getPassword();

        //如果密码错误，返回null
        if (!password.equals(passwordGet)) {
            return null;
        }

        return userBasic;
    }

    @Override
    public UserDetail getUserDetailById(Integer id) {
        return userDetailMapper.selectById(id);
    }


};