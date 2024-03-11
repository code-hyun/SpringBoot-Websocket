package org.example.websocketserver_1.config;

import lombok.RequiredArgsConstructor;
import org.example.websocketserver_1.MyWebsocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
    private final MyWebsocketHandler myWebsocketHandler;
    @Autowired
    public WebSocketConfiguration(MyWebsocketHandler myWebsocketHandler) {
        this.myWebsocketHandler = myWebsocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebsocketHandler, "/audio")
                .setAllowedOrigins("*").addInterceptors(new HttpSessionHandshakeInterceptor());
    }

}
