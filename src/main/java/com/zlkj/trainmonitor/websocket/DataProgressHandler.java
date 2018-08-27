package com.zlkj.trainmonitor.websocket;

import com.zlkj.trainmonitor.threads.DataProgressThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class DataProgressHandler extends TextWebSocketHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    Runnable thread = TestThread.getInstance();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("DataProgressHandler socket connect success");
        session.sendMessage(new TextMessage("success"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //获取盘符和进度条信息
        Thread thread = new Thread(DataProgressThread.getInstance());
        DataProgressThread.getInstance().setFlag(session, true);
        thread.start();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("DataProgressHandler socket  closed");
        DataProgressThread.getInstance().setFlag(null, false);
    }
}