package com.yoyo.servlet;

import com.yoyo.util.ResponseUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/4 0004.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map jsonMap = new HashMap();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            String userName = request.getParameter("UserName");
            String password = request.getParameter("PassWord");
            if(userName.equals("user1") || userName.equals("user2")
                    || userName.equals("user3") || userName.equals("user4") || userName.equals("user5")){
                if(password.equals("123456")){
                    jsonMap.put("IsOk",true);
                    request.getSession().setAttribute("user","user");
                    logger.info("登录成功");
                }
                else {
                    jsonMap.put("IsOk",false);
                    jsonMap.put("Msg", "密码错误！");
                    logger.info("密码错误");
                }
            }else{
                jsonMap.put("IsOk",false);
                jsonMap.put("Msg", "用户名错误");
                logger.info("用户名错误");
            }
        } catch (Exception e) {
            jsonMap.put("IsOk",false);
            jsonMap.put("Msg", "系统繁忙,请稍候再试！");
            logger.info(e);
        } finally {
            ResponseUtil.response(response,jsonMap);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
