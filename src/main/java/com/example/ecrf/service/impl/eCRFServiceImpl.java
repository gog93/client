package com.example.ecrf.service.impl;

import com.example.ecrf.dto.RequesteCRF;
import com.example.ecrf.mapper.eCRFMapper;
import com.example.ecrf.model.eCRF1;
import com.example.ecrf.repository.eCRFRepository;
import com.example.ecrf.service.eCRFService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class eCRFServiceImpl implements eCRFService {
    private final eCRFRepository eCRFREpository;
    private final eCRFMapper mapper;

    @Override
    public void create(RequesteCRF eCRF) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date(); // create a new Date object with the current date/time
        String formattedDate = sdf.format(now);
        eCRF.setStatus(null);
        eCRF.setCreated_At(formattedDate);
        eCRF.setFilling_status("L300");
        eCRF.setPat_id("6ool8962");
        eCRFREpository.save(mapper.toeCRFFromRequest(eCRF));
    }

    @Override
    public Page<eCRF1> findByStatus(String path_Id, Pageable pageRequest) {

        return eCRFREpository.findAllByEcrfStatusIsNullOrDraftAndPatIdStartsWith(path_Id, pageRequest);
    }

    @Override
    public Page<eCRF1> findBySend(String path_Id, Pageable pageRequest) {

        return eCRFREpository.findByEcrfStatusAndPatIdStartsWith(path_Id, pageRequest);
    }

    @Override
    public Page<eCRF1> findByDelete(String path_Id, Pageable pageRequest) {

        return eCRFREpository.findAllByEcrfStatusIsDeleteAndPatIdStartsWith(path_Id, pageRequest);
    }

    @Override
    public List<eCRF1> alleCRFEs() {
        return eCRFREpository.findAll();
    }

    @Override
    public Page<eCRF1> findAlleCRFEs(Pageable pageRequest) {
        return eCRFREpository.findAll(pageRequest);
    }

    @Override
    public eCRF1 changeStatusSend(Long id) {
        eCRF1 byId = eCRFREpository.findById(id).get();
        byId.setEcrfStatus("sent");
        eCRFREpository.save(byId);
        return byId;
    }

    @Override
    public eCRF1 changeStatusDelete(Long id) {
        eCRF1 byId = eCRFREpository.findById(id).get();
        byId.setEcrfStatus("deleted");
        eCRFREpository.save(byId);
        return byId;
    }

    @Override
    public eCRF1 changeStatusDraft(Long id) {
        eCRF1 byId = eCRFREpository.findById(id).get();
        byId.setEcrfStatus("draft");
        eCRFREpository.save(byId);
        return byId;
    }
}
