package com.jocata.externalservices.service;

import com.jocata.externalservices.payload.AadharPayload;
import com.jocata.externalservices.response.AadharResponse;

public interface AadharService {
    AadharResponse getAadharInfoDetails(AadharPayload aadharPayload);
}
