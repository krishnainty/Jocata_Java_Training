package com.jocata.externalServices.controller;

import com.jocata.externalServices.bean.PanRequestForm;
import com.jocata.externalServices.bean.PanResponseForm;
import com.jocata.externalServices.entity.Pan;

import com.jocata.externalServices.service.PanService;
import com.jocata.externalServices.service.impl.PanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/pan")
public class PanController {
    @Autowired
    private PanService panService;
    @GetMapping("/get")
    public PanResponseForm getPanInfo(@RequestParam String panNo){
        PanRequestForm panReq = new PanRequestForm();
        panReq.setPanNo(panNo);
        PanResponseForm response = panService.getPanInfo(panReq);
        if (response == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No PAN found for the provided PAN number");
        }

        return response;

    }


}
