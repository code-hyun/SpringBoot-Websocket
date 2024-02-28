package org.example.websocketclient.Config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VrResponse {
    private String Result;
    private Object resultInfo;
    private String version;
    private String work_time;

    public VrResponse(String result, Object resultInfo, String version, String work_time) {
        Result = result;
        this.resultInfo = resultInfo;
        this.version = version;
        this.work_time = work_time;
    }
}
