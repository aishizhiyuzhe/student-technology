package com.ming.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class MyFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        String uri=request.getRequestURI();
        HttpSession session=request.getSession();
        String login= (String) session.getAttribute("login");
        if (uri.equals("/") ||uri.equals("/login")){
            System.out.print("/访问登录页面无需权限");
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println("需要权限");
            if (null!=login&& login.equals("login")){
                System.out.println("权限认证成功");
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
