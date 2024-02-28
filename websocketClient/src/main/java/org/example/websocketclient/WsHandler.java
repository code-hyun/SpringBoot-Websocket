package org.example.websocketclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

@Slf4j
@Component
public class WsHandler extends AbstractWebSocketHandler {
    final static int BUFFER_SIZE = 640;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session.getHandshakeHeaders().toString());
        log.info("Connected");
        TextMessage textMessage = new TextMessage("Hello");
        session.sendMessage(textMessage);
        // 연결이 성공적으로 수립되면 메시지 전송
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        TextMessage textMessage = new TextMessage("Hello from client!");
        if(!session.isOpen()){
            session.sendMessage(textMessage);
        }

        FileInputStream fis = new FileInputStream("D:\\01. project\\Spring Boot\\websocketClient\\src\\main\\resources\\static\\audio\\opus_sample.opus");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buffer = new byte[BUFFER_SIZE];
        int byteRead;
        while((byteRead = bis.read(buffer)) != -1){
            ByteBuffer byteBuffer = ByteBuffer.wrap(buffer, 0, byteRead);
            BinaryMessage binaryMessage = new BinaryMessage(byteBuffer);
            if (session.isOpen()) {
                session.sendMessage(binaryMessage);
            }
        }

//        while(true){
//        }

        log.info("Received message: {}", message.getPayload());

        if(message.getPayload().equals("end")){
            log.info("close");
            session.close();
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Connection closed: {}", status);
    }
}
