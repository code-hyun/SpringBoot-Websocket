package org.example.websocketclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.websocketclient.Config.UserHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Service
@Slf4j
public class WsClient {

    private final WsHandler wsHandler;

    @Autowired
    public WsClient(WsHandler wsHandler ) {
        this.wsHandler = wsHandler;
    }

    @PostConstruct
    public void connectToWebSocket() throws URISyntaxException, JsonProcessingException {
        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

        UserHeader header = new UserHeader("tid_test1","",123, 123,"", "OPUS_16K", "vin_test1", "", "test", "", "W", "50db", "", "", "", "", "", "", "", "");

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap  = objectMapper.convertValue(header, Map.class);
        for(String key : jsonMap.keySet()){
            headers.add(key, String.valueOf(jsonMap.get(key)));
        }
        log.info(String.valueOf(headers));
//        headers.add("headers", jsonHeader);
//        headers.add("headers", jsonHeader);
//        headers.keySet(jsonHeader);


//        headers.add("custom-header", "value");
//        headers.add("custom-headers1", "1234123456789");
//        headers.add("custom-headers2", "test");
//        headers.add("custom-headers3", "test2");
//        headers.add("custom-headers4","test3");
        URI uri = new URI("ws://localhost:10000/audio");

        client.execute(wsHandler, headers, uri);
        log.info("WebSocket client connected to: {}", uri);
    }

}
