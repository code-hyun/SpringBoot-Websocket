package org.example.websocketclient.Config;

import lombok.Getter;
import lombok.Setter;

/**
 *
 */

@Getter
@Setter
public class TraceLog {
    private String tid;
    private String seq;
    private String from;
    private String to;
    private String res_status;
    private Object result_data;
    private String update_time;

    public TraceLog(String tid, String seq, String from, String to, String res_status, Object result_data, String update_time) {
        this.tid = tid;
        this.seq = seq;
        this.from = from;
        this.to = to;
        this.res_status = res_status;
        this.result_data = result_data;
        this.update_time = update_time;
    }
}
