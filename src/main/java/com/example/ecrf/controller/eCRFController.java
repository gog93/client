package com.example.ecrf.controller;

import com.example.ecrf.dto.RequesteCRF;
import com.example.ecrf.service.eCRFService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@RequestMapping("/eCRF")
@RequiredArgsConstructor
public class eCRFController {
    private final eCRFService service;

    @GetMapping
    public String eCRFGet() {

//        model.addAttribute("eCRFEs", all);
        return "index";
    }

    @GetMapping("eCRF1/Filling_status/{id}")
    public String eCRFGet(@PathVariable("id") String filling_status) {

//        model.addAttribute("eCRFEs", all);
        return "edit";
    }




    @PostMapping("/medical.org/addnewecrf")
    public String addNewCaseFamily(RequesteCRF eCRF, Model model) {
        model.addAttribute("eCRF", eCRF);
        try {
            service.create(eCRF);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/eCRF";
    }
}
