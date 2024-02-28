package org.example.websocketclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;

@SpringBootApplication
@Slf4j
public class WebsocketClientApplication {

    public static void main(String[] args) throws URISyntaxException {
        SpringApplication.run(WebsocketClientApplication.class, args); // Spring 애플리케이션 실행
    }
}
