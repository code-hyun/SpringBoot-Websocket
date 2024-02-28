package org.example.websocketclient.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
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

    public UserHeader(String tid, String nadid, double lat, double lon, String currAreaCode, String vrCodec, String vin, String AVNPlatform, String vehicleName, String vehicleCode, String speaker, String volume, String brand, String VRSWVALUE, String VRSWVERSION, String dialoguerequestidk, String olddialoguerequestidk, String vrslotfilling, String avntstatusdata, String device) {
        this.tid = tid;
        this.nadid = nadid;
        this.lat = lat;
        this.lon = lon;
        this.currAreaCode = currAreaCode;
        this.vrCodec = vrCodec;
        this.vin = vin;
        this.AVNPlatform = AVNPlatform;
        this.VehicleName = vehicleName;
        this.VehicleCode = vehicleCode;
        this.speaker = speaker;
        this.volume = volume;
        this.brand = brand;
        this.VRSWVALUE = VRSWVALUE;
        this.VRSWVERSION = VRSWVERSION;
        this.dialoguerequestidk = dialoguerequestidk;
        this.olddialoguerequestidk = olddialoguerequestidk;
        this.vrslotfilling = vrslotfilling;
        this.avntstatusdata = avntstatusdata;
        this.device = device;
    }
}
