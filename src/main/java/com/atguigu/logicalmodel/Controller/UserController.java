package com.atguigu.logicalmodel.Controller;


import com.atguigu.logicalmodel.Service.UserBasicService;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userBasicService")
    private UserBasicService userBasicService;







    @GetMapping(value = {"/", "/index"})
    public String login() {
        return "login";
    }


    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("loginId") Integer loginId,
                              @RequestParam("password") String password,
                              ModelAndView mav,
                              HttpSession session) {
        UserBasic userBasic = userBasicService.Login(loginId, password);

        System.out.println("哈哈哈，成功进入登录方法");

        if (userBasic == null) {
            System.out.println("登陆失败");
            mav.setViewName("login");
            return mav;
        } else {

            //将用户的具体信息从数据库导入
            userBasic.setUserDetail(userBasicService.getUserDetailById(userBasic.getId()));


            session.setAttribute("userBasic", userBasic);
            System.out.println("登陆成功");
            mav.setViewName("consult");
            return mav;
        }
    }

    @RequestMapping("/userInfo")
    public String userInfo() {
        return "Info";
    }


}
