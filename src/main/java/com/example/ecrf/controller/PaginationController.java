package com.example.ecrf.controller;

import com.example.ecrf.model.eCRF1;
import com.example.ecrf.service.eCRFService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eCRF")
public class PaginationController {
    private final eCRFService service;

    @GetMapping("/draft")
    public Page<eCRF1> allDraft(@RequestParam(name = "search", required = false) String search,
                                Pageable pageable) {
        Page<eCRF1> byStatus = service.findByStatus(search, pageable);

        return byStatus;
    }

    @GetMapping("/sent")
    public Page<eCRF1> allSent(@RequestParam(name = "search", required = false) String search, Pageable pageable) {
        Page<eCRF1> byStatus = service.findBySend(search, pageable);

        return byStatus;
    }

    @GetMapping("/delete")
    public Page<eCRF1> allDelete(@RequestParam(name = "search", required = false) String search, Pageable pageable) {

        Page<eCRF1> byStatus = service.findByDelete(search, pageable);

        return byStatus;
    }


    @GetMapping("/changeStatus/delete/{id}")
    public eCRF1 changeStatusDelete(@PathVariable("id") Long id) {

        return service.changeStatusDelete(id);
    }

    @GetMapping("/changeStatus/sent/{id}")
    public eCRF1 changeStatusSend(@PathVariable("id") Long id) {

        return service.changeStatusSend(id);
    }

    @GetMapping("/changeStatus/restore/{id}")
    public eCRF1 changeStatusDraft(@PathVariable("id") Long id) {

        return service.changeStatusDraft(id);
    }

}
