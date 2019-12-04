package com.demo.websocket;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 相当于controller的处理器
 */
public class MyHandler  extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session,
                             TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.err.println(payload);
        Map<String, String> map = JSONObject.parseObject(payload, HashMap.class);
        System.err.println("接收到的数据：" + map);
        session.sendMessage(new TextMessage("服务器返回收到的数据!!!" + payload));
        // 获取请求ip
    }
}
