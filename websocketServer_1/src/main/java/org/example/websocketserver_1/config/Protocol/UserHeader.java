package org.example.websocketserver_1.config.Protocol;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserHeader {
    private String tid;
    private String nadid;
    private double lat;
    private double lon;
    private String currAreaCode;
    private String vrCodec;
    private String vin;
    private String AVNPlatform;
    private String VehicleName;
    private String VehicleCode;
    private String speaker;
    private String volume;
    private String brand;
    private String VRSWVALUE;
    private String VRSWVERSION;
    private String dialoguerequestidk;
    private String olddialoguerequestidk;
    private String vrslotfilling;
    private String avntstatusdata;
    private String device;

}
