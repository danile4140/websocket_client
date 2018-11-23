package com.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * Created by danny.deng on 2018/11/22.
 */
public class WsClient extends WebSocketClient {
    public static Logger logger = LogManager.getLogger(WsClient.class);

    public WsClient(URI uri) {
        super(uri);
        logger.info("------>>>>> client create connect..");
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {

        HeartCheck.start(this, 5000);
        String openid = "999999";
        logger.info("玩家1打开链接=" + openid);
        String login = "{\"cmd\":6,\"openid\":" + openid + ", \"platform\":\"android\"}";   //步骤1：发送登录消息
        logger.info("玩家1登录请求消息=" + login);
        send(login);
    }

    @Override
    public void onMessage(String message) {
        logger.info("------->>>>get msg from server.. Msg： " + message);
        send("------->>>> onMessage() Called");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        logger.info("------->>>>onClose() Called.. Msg： " + reason);
    }

    @Override
    public void onError(Exception ex) {
        logger.info("------->>>>onClose() Called.. ");
        ex.printStackTrace();

    }
}
