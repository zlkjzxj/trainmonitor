package com.zlkj.trainmonitor.threads;

import com.zlkj.trainmonitor.test.CheckEquType;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

public class InitThread implements Runnable {
    private WebSocketSession session;
    private boolean flag;

    //    public TestThread(WebSocketSession session, boolean flag) {
//        this.session = session;
//        this.flag = flag;
//    }
    private static InitThread initThread;

    private InitThread() {
        this.session = session;
        this.flag = flag;
    }

    public static synchronized InitThread getInstance() {
        if (initThread == null) {
            initThread = new InitThread();
        }
        return initThread;
    }

    public void setFlag(WebSocketSession session, boolean flag) {
        this.session = session;
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            i++;
            try {
                String s = CheckEquType.checkEquTypeString();

                if (s.length() > 0 && session != null) {
                    session.sendMessage(new TextMessage(s));
                    //System.out.println(s + i);
                } else {
                    session.sendMessage(new TextMessage("0"));
                }
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InitThread());
        thread.start();
    }
}
