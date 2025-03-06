package com.jocata.externalservices.controller;

import com.jocata.externalservices.payload.AadharPayload;
import com.jocata.externalservices.payload.CibilPayload;
import com.jocata.externalservices.payload.ExternalServiceRequest;
import com.jocata.externalservices.payload.PanPayload;
import com.jocata.externalservices.response.AadharResponse;
import com.jocata.externalservices.response.CibilResponse;
import com.jocata.externalservices.response.ExternalServiceResponse;
import com.jocata.externalservices.response.PanResponse;
import com.jocata.externalservices.service.AadharService;
import com.jocata.externalservices.service.CibilService;
import com.jocata.externalservices.service.PanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ExternalServicesController {

    @Autowired
    private PanService panService;
    @Autowired
    private AadharService aadharService;
    @Autowired
    private CibilService cibilService;

    @PostMapping ("/getPanDetails")
    public ExternalServiceResponse<PanResponse> getPanInfoDetails(@RequestBody ExternalServiceRequest request) {

        PanPayload payload = request.getPanPayload();
        PanResponse panResponse = panService.getPanInfoDetails(payload);
        return new ExternalServiceResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), request.getTxnId(), panResponse);
    }
    @PostMapping("/getAadharDetails")
    public ExternalServiceResponse<AadharResponse> getAadharInfoDetails(@RequestBody ExternalServiceRequest request){
        AadharPayload aadharPayload=request.getAadharPayload();
        AadharResponse aadharResponse=aadharService.getAadharInfoDetails(aadharPayload);
        return new ExternalServiceResponse<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), request.getTxnId(), aadharResponse);

    }
    @PostMapping("/getCibilDetails")
    public ExternalServiceResponse<CibilResponse>getCibilInfoDetails(@RequestBody ExternalServiceRequest request){
        CibilPayload cibilPayload=request.getCibilPayload();
        CibilResponse cibilResponse= cibilService.getCibilInfoDetails(cibilPayload);
        return new ExternalServiceResponse<>(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),request.getTxnId(),cibilResponse);


    }
    @PostMapping("/postCibilDetails")
    public Object postCibilInfoDetails(@RequestBody CibilResponse cibilResponse){
        return cibilService.postCibilInfoDetails(cibilResponse);



    }
}
