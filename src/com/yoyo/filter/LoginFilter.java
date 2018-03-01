package com.yoyo.filter;

import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = "*.jsp")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
        if(!path.contains("login")){
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if(user == null){
                response.sendRedirect("./login.jsp");
            }else{
                chain.doFilter(request,response);
            }
        }else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
