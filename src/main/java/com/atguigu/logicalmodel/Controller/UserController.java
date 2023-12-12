package com.atguigu.logicalmodel.Controller;


import com.atguigu.logicalmodel.Service.UserBasicService;
import com.atguigu.logicalmodel.pojo.UserBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

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
    public String login(@RequestParam("loginId") Integer loginId,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        UserBasic userBasic = userBasicService.Login(loginId, password);

        System.out.println("哈哈哈，成功进入登录方法");

        if (userBasic == null) {
            System.out.println("登陆失败");
            return "login";
        } else {

            //将用户的具体信息从数据库导入
            userBasic.setUserDetail(userBasicService.getUserDetailById(userBasic.getId()));

            request.getSession().setAttribute("userBasic", userBasic);
            System.out.println("登陆成功");
            return "consult";
        }
    }

    @RequestMapping("/userInfo")
    public String userInfo() {
        return "Info";
    }


}
