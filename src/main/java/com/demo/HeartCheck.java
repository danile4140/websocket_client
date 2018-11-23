package com.demo;

import org.java_websocket.client.WebSocketClient;

/**
 * Created by danny.deng on 2018/11/22.
 */
public class HeartCheck {
    /**
     * 启动心跳检测
     *
     * @param conn ： 连接
     * @param period ： 心跳检测周期
     */
    public static void start(final WebSocketClient conn, final int period) {

        new Thread(new Runnable() {
            public void run() {
                while (!conn.isClosed()) {
                    conn.send(">>>>> heart beat...connection: " + conn.getLocalSocketAddress().toString());
                    try {
                        Thread.sleep(period);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
