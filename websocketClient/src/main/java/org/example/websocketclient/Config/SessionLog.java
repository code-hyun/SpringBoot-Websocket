package org.example.websocketclient.Config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionLog {
    private String tid;
    private String nadid;
    private String req_type;
    private Object result_data;
    private String res_status;
    private String st_time;
    private String ed_time;
    private String work_time;

    public SessionLog(String tid, String nadid, String req_type, Object result_data, String res_status, String st_time, String ed_time, String work_time) {
        this.tid = tid;
        this.nadid = nadid;
        this.req_type = req_type;
        this.result_data = result_data;
        this.res_status = res_status;
        this.st_time = st_time;
        this.ed_time = ed_time;
        this.work_time = work_time;
    }
}
