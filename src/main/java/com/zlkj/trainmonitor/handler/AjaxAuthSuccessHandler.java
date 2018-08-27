package com.zlkj.trainmonitor.handler;

import com.google.gson.Gson;
import com.zlkj.trainmonitor.bean.CurrentUser;
import com.zlkj.trainmonitor.bean.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    Logger logger = LoggerFactory.getLogger(AjaxAuthSuccessHandler.class);
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_OK);
//    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        logger.error("AjaxAuthSuccessHandler!!!!!!!!!!");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", "false");
        CurrentUser currentUser = new CurrentUser("", "https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png", "00000001", 12);
        out.write(new Gson().toJson(new LoginResult("ok", "account", "admin", currentUser)));
        out.flush();
        out.close();
    }
}