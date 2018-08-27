package com.zlkj.trainmonitor.websocket;

import com.zlkj.trainmonitor.threads.OutputSocketThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class OutputDataHandler extends TextWebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    Runnable thread = TestThread.getInstance();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("socket connect success");
        session.sendMessage(new TextMessage("success"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("---MessageHandlers----websoket connection");
        logger.info("----MessageHandlers----sessionId---" + session.getId());
        //调用扫盘方
        Thread thread = new Thread(OutputSocketThread.getInstance());
        OutputSocketThread.getInstance().setFlag(session, true);
        thread.start();

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("----MessageHandlers---连接已关闭");
        OutputSocketThread.getInstance().setFlag(null, false);
    }
}