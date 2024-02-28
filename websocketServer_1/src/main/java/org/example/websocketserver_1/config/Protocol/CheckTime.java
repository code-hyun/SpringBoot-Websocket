package org.example.websocketserver_1.config.Protocol;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CheckTime {
    private String stTime;
    private String edTime;
    private String parTime;
    private String finTime;
    private String nluTime;
    private String dmTime;
    private String resTime;

}
