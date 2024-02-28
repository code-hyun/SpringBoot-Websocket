package org.example.websocketserver_1.config.Protocol;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SessionLog {
    private String tid;
    private String nadid;
    private String req_type;
    private Object result_data;
    private String res_status;
    private String st_time;
    private String ed_time;
    private String work_time;


}
