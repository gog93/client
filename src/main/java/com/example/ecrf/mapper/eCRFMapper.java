package com.example.ecrf.mapper;

import com.example.ecrf.dto.RequesteCRF;
import com.example.ecrf.dto.ResponseeCRF;
import com.example.ecrf.model.eCRF1;
import org.springframework.stereotype.Component;

@Component
public class eCRFMapper {

    public eCRF1 toeCRFFromRequest(RequesteCRF requesteCRF) {
        return eCRF1.builder()
                .ecrfStatus(requesteCRF.getStatus())
                .created_At(requesteCRF.getCreated_At())
                .patId(requesteCRF.getPat_id())
                .filling_status(requesteCRF.getFilling_status())
                .build();
    }
    public eCRF1 toeCRFFromResponse(ResponseeCRF responseeCRF) {
        return eCRF1.builder()
                .id(responseeCRF.getId())
                .ecrfStatus(responseeCRF.getStatus())
                .created_At(responseeCRF.getCreated_At())
                .patId(responseeCRF.getPat_id())
                .filling_status(responseeCRF.getFilling_status())
                .build();
    }
    public ResponseeCRF toResponse(eCRF1 eCRF1) {
        return ResponseeCRF.builder()
                .id(eCRF1.getId())
                .status(eCRF1.getEcrfStatus())
                .created_At(eCRF1.getCreated_At())
                .pat_id(eCRF1.getPatId())
                .filling_status(eCRF1.getFilling_status())
                .build();
    }
}
