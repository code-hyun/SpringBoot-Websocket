package org.example.websocketserver_1.config.Protocol;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class VrResponse {
    private String result;
    private Object resultInfo;
    private String version;
    private String work_time;

}
