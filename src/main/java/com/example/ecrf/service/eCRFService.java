package com.example.ecrf.service;

import com.example.ecrf.dto.RequesteCRF;
import com.example.ecrf.model.eCRF1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.List;

public interface eCRFService {
    void create(RequesteCRF eCRF) throws ParseException;

    Page<eCRF1> findByStatus(String path_Id, Pageable pageable);

    Page<eCRF1> findByDelete(String path_Id, Pageable pageable);

    Page<eCRF1> findBySend(String path_Id, Pageable pageable);

    List<eCRF1> alleCRFEs();

    Page<eCRF1> findAlleCRFEs(Pageable pageRequest);

    eCRF1 changeStatusSend(Long id);

    eCRF1 changeStatusDelete(Long id);
    eCRF1 changeStatusDraft(Long id);
}
