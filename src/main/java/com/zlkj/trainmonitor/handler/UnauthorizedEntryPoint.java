package com.zlkj.trainmonitor.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
    Logger logger = LoggerFactory.getLogger(UnauthorizedEntryPoint.class);

    //    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        if(isAjaxRequest(request)){
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
//        }else{
//            response.sendRedirect("/");
//        }
//
//    }
////
//    public static boolean isAjaxRequest(HttpServletRequest request) {
//        String ajaxFlag = request.getHeader("X-Requested-With");
//        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
//    }
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        logger.warn("UnauthorizedEntryPoint!!!!!!!!!!!!");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

}
