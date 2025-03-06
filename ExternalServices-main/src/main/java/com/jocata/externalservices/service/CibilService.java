package com.jocata.externalservices.service;

import com.jocata.externalservices.payload.CibilPayload;
import com.jocata.externalservices.response.CibilResponse;
import org.springframework.stereotype.Service;

public interface CibilService {
    CibilResponse getCibilInfoDetails(CibilPayload cibilPayload);

    Object postCibilInfoDetails(CibilResponse cibilResponse);
}
