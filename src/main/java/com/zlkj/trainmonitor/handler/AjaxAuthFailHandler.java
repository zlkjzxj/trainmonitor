package com.zlkj.trainmonitor.handler;

import com.google.gson.Gson;
import com.zlkj.trainmonitor.bean.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
    Logger logger = LoggerFactory.getLogger(AjaxAuthSuccessHandler.class);
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
//    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        logger.error("AjaxAuthFailHandler");
        PrintWriter out = response.getWriter();
        out.write( new Gson().toJson(new LoginResult("error","account","guest",null)));

    }
}