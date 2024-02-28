package org.example.websocketclient.Config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CheckTime {
    Long stTime;
    private String edTime;
    private String parTime;
    private String finTime;
    private String nluTime;
    private String dmTime;
    private String resTime;

    public CheckTime(Long stTime, String edTime, String parTime, String finTime, String nluTime, String dmTime, String resTime) {
        this.stTime = stTime;
        this.edTime = edTime;
        this.parTime = parTime;
        this.finTime = finTime;
        this.nluTime = nluTime;
        this.dmTime = dmTime;
        this.resTime = resTime;
    }
}
