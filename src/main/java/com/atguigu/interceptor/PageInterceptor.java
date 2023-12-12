package com.atguigu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("userBasic");
        if (user != null) {
            return true;
        } else {
            System.out.println("拦截的请求是：" + request.getRequestURL().toString());
            System.out.println(request.getAttribute("loginId"));
            System.out.println(request.getAttribute("password"));
            System.out.println(request.getParameter("loginId"));
            System.out.println(request.getParameter("password"));
            request.setAttribute("msg", "请先登录账号");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
