package org.example.websocketserver_1.config.Protocol;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 *
 */

@Component
@Data
public class TraceLog {
    private String tid;
    private String seq;
    private String from;
    private String to;
    private String res_status;
    private Object result_data;
    private String update_time;

}
