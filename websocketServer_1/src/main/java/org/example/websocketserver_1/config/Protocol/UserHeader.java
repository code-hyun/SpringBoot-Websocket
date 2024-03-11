package org.example.websocketserver_1.config.Protocol;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserHeader {
    private String tid;
    private String nadid;
    private double lat;
    private double lon;
    private String currareacode;
    private String vrcodec;
    private String vin;
    private String avnplatform;
    private String vehiclecode;
    private String speaker;
    private String volume;
    private String brand;
    private String vrswversion;
    private String vrswverion;
    private String dialoguerequestidk;
    private String olddialoguerequestidk;
    private String vrslotfilling;
    private String avntstatusdata;
    private String device;

    public UserHeader() {
    }

    public UserHeader(String tid, String nadid, double lat, double lon, String currareacode, String vrcodec, String vin, String avnplatform, String vehiclecode, String speaker, String volume, String brand, String vrswversion, String vrswverion, String dialoguerequestidk, String olddialoguerequestidk, String vrslotfilling, String avntstatusdata, String device) {
        this.tid = tid;
        this.nadid = nadid;
        this.lat = lat;
        this.lon = lon;
        this.currareacode = currareacode;
        this.vrcodec = vrcodec;
        this.vin = vin;
        this.avnplatform = avnplatform;
        this.vehiclecode = vehiclecode;
        this.speaker = speaker;
        this.volume = volume;
        this.brand = brand;
        this.vrswversion = vrswversion;
        this.vrswverion = vrswverion;
        this.dialoguerequestidk = dialoguerequestidk;
        this.olddialoguerequestidk = olddialoguerequestidk;
        this.vrslotfilling = vrslotfilling;
        this.avntstatusdata = avntstatusdata;
        this.device = device;
    }
}

