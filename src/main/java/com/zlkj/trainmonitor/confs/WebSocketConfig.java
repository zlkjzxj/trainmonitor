package com.zlkj.trainmonitor.confs;


import com.zlkj.trainmonitor.websocket.DataProgressHandler;
import com.zlkj.trainmonitor.websocket.InitHandler;
import com.zlkj.trainmonitor.websocket.OutputDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@EnableWebSecurity
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private InitHandler initHandler;
    @Autowired
    private OutputDataHandler outputDataHandler;
    @Autowired
    private DataProgressHandler dataProgressHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("registerWebSocketHandlers");
//        registry.addHandler(chatHandler,"/chat")
//                .setAllowedOrigins("*")//跨域
//                .addInterceptors(webSocketHandshakeInterceptor)  //添加 websocket握手拦截器
//                .withSockJS();
        registry.addHandler(initHandler, "/init");
        registry.addHandler(outputDataHandler, "/outPutData");
        registry.addHandler(dataProgressHandler, "/dataProgress");
//        registry.addHandler(initHandler, "/chat/socketJs").withSockJS();
    }
//    @Bean
//    public ServletServerContainerFactoryBean createWebSocketContainer() {
//        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
//        container.setMaxTextMessageBufferSize(8192 * 4);
//        container.setMaxBinaryMessageBufferSize(8192 * 4);
//        return container;
//    }

}