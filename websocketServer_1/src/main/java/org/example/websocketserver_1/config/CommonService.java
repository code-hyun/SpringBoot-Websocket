package org.example.websocketserver_1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.websocketserver_1.config.Protocol.UserHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class CommonService {
    public UserHeader handshakeToUserHeader(HttpHeaders handshakeHeaders, ObjectMapper objectMapper) {

        Map<String, Object> filteredHeader = new HashMap<>();
        filteredHeader.put("tid", getSingleHeaderValue(handshakeHeaders, "tid"));
        filteredHeader.put("nadid", getSingleHeaderValue(handshakeHeaders, "nadid"));
        filteredHeader.put("lat", getSingleHeaderValue(handshakeHeaders, "lat"));
        filteredHeader.put("lon", getSingleHeaderValue(handshakeHeaders, "lon"));
        filteredHeader.put("currareacode", getSingleHeaderValue(handshakeHeaders, "currareacode"));
        filteredHeader.put("vrcodec", getSingleHeaderValue(handshakeHeaders, "vrcodec"));
        filteredHeader.put("vin", getSingleHeaderValue(handshakeHeaders, "vin"));
        filteredHeader.put("avnplatform", getSingleHeaderValue(handshakeHeaders, "avnplatform"));
        filteredHeader.put("vehiclecode", getSingleHeaderValue(handshakeHeaders, "vehiclecode"));
        filteredHeader.put("speaker", getSingleHeaderValue(handshakeHeaders, "speaker"));
        filteredHeader.put("volume", getSingleHeaderValue(handshakeHeaders, "volume"));
        filteredHeader.put("brand", getSingleHeaderValue(handshakeHeaders, "brand"));
        filteredHeader.put("vrswversion", getSingleHeaderValue(handshakeHeaders, "vrswversion"));
        filteredHeader.put("vrswverion", getSingleHeaderValue(handshakeHeaders, "vrswverion"));
        filteredHeader.put("dialoguerequestidk", getSingleHeaderValue(handshakeHeaders, "dialoguerequestidk"));
        filteredHeader.put("olddialoguerequestidk", getSingleHeaderValue(handshakeHeaders, "olddialoguerequestidk"));
        filteredHeader.put("vrslotfilling", getSingleHeaderValue(handshakeHeaders, "vrslotfilling"));
        filteredHeader.put("avntstatusdata", getSingleHeaderValue(handshakeHeaders, "avntstatusdata"));
        filteredHeader.put("device", getSingleHeaderValue(handshakeHeaders, "device"));


        // 필터링된 헤더를 UserHeader 객체로 변환합니다.
        return objectMapper.convertValue(filteredHeader, UserHeader.class);
    }

    private String getSingleHeaderValue(HttpHeaders headers, String headerName) {
        if (headers.containsKey(headerName)) {
            List<String> values = headers.get(headerName);
            return values.isEmpty() ? null : values.get(0); // 첫 번째 값만 반환
        }
        return null;
    }
}
