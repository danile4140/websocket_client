package com.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;

/**
 * Created by danny.deng on 2018/11/22.
 */
public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            WebSocket client = new WsClient(new URI("ws://127.0.0.1:8887"));
            client.connect();
            logger.info("master状态=" + client.getReadyState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
