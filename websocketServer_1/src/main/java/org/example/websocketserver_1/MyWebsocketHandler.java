package org.example.websocketserver_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.websocketserver_1.config.Protocol.UserHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Slf4j
@RequiredArgsConstructor
public class MyWebsocketHandler extends AbstractWebSocketHandler {
    private UserHeader userHeader;
    @Autowired
    public MyWebsocketHandler(UserHeader userHeader) {
        this.userHeader = userHeader;
    }

    private final List<WebSocketSession> clientSessions = new CopyOnWriteArrayList<>();
//    private WebSocketSession externalServerSession;
//    private WebSocketSession kaldi;
    private final HashMap<String, BufferedOutputStream> sendFileMap = new HashMap<>();

    // 연결이 된 후
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("[WSS][CON] Websocket Connection..");
        log.info(String.valueOf(session.getHandshakeHeaders()));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Object, Object> wsHeader = objectMapper.convertValue(session.getHandshakeHeaders(), Map.class);

        log.info(wsHeader.toString());
//        for(String key : wsHeader.keySet()){
//            if(header.containsKey(key)){
//                header.put(key, wsHeader.get(key));
//                log.info(userHeader.toString());
//            }
//
//        }
        clientSessions.add(session);
    }

//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
////        ByteBuffer byteBuffer = (ByteBuffer) message.getPayload();
//        String payload = (String) message.getPayload();
//        session.sendMessage(message);
//        log.info("payload :" + payload);
//        // 새로운 메시지 생성
//        TextMessage newMessage = new TextMessage("Hello, Client!");
//
//        // 클라이언트에게 새로운 메시지 전송
//        session.sendMessage(newMessage);
//
//        // 로그에 새로운 메시지 전송 정보 기록
//        log.info("Sent new message to client: Hello, Client!");
//    }


//    private void connectToExternalServer() {
//        WebSocketClient client = new StandardWebSocketClient();
//        client.execute(new WebSocketHandler() {
//            @Override
//            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//                externalServerSession = session;
//            }
//
//            @Override
//            public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//                // 외부 서버로부터 메시지를 받았을 때, 모든 클라이언트 세션에 메시지를 전송합니다.
//                for (WebSocketSession clientSession : clientSessions) {
//                    if (clientSession.isOpen()) {
//                        clientSession.sendMessage(message);
//                    }
//                }
//            }
//
//        }, "ws://external-server-url/websocket-path"); // 외부 서버의 WebSocket URL
//    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        String test2 = test.toString() == null ? String.valueOf(test.add("test")) : test.toString();
//        log.info(test2);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 텍스트 메시지를 받았을 때 호출됩니다.
        // 받은 메시지를 다른 서버로 전달합니다.
//        forwardMessage(message);
        log.info(message.getPayload());
        TextMessage end = new TextMessage("end");

        session.sendMessage(end);
        log.info(end.getPayload());
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        String sessionId = session.getId();
//        log.info("Received binary message from session: {}", sessionId);
        BufferedOutputStream bos = sendFileMap.get(sessionId); //
        String fileName = "output_" + sessionId + ".opus";

        if (bos == null) {
            bos = new BufferedOutputStream(new FileOutputStream(fileName, true)); // 파일에 데이터를 추가합니다.
            sendFileMap.put(sessionId, bos);
        }

        ByteBuffer byteBuffer = message.getPayload();
        byte[] bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(bytes);
        bos.write(bytes);

        if (message.isLast()) { // 마지막 메시지인지 확인합니다.
            if (bos != null) {
                bos.close(); // 스트림을 닫고 리소스를 해제합니다.
                sendFileMap.remove(sessionId); // 세션 ID와 관련된 스트림을 맵에서 제거합니다.
//                log.info("File writing completed for session: {}", sessionId);
            }
        }
    }
//
//    private void forwardMessage(Object message) throws Exception {
//        if (this.externalServerSession != null && this.externalServerSession.isOpen()) {
//            if (message instanceof TextMessage) {
//                this.externalServerSession.sendMessage((TextMessage) message);
//            } else if (message instanceof BinaryMessage) {
//                this.externalServerSession.sendMessage((BinaryMessage) message);
//            }
//            // 추가 메시지 유형이 있을 경우 여기에 처리 로직을 구현합니다.
//        }
//    }

}