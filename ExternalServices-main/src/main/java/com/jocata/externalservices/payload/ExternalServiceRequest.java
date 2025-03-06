package com.jocata.externalservices.payload;

import java.io.Serializable;

public class ExternalServiceRequest implements Serializable {

    private String txnId;
    private PanPayload panPayload;
    private AadharPayload aadharPayload;
    private CibilPayload cibilPayload;

    public CibilPayload getCibilPayload() {
        return cibilPayload;
    }

    public void setCibilPayload(CibilPayload cibilPayload) {
        this.cibilPayload = cibilPayload;
    }

    public AadharPayload getAadharPayload() {
        return aadharPayload;
    }

    public void setAadharPayload(AadharPayload aadharPayload) {
        this.aadharPayload = aadharPayload;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public PanPayload getPanPayload() {
        return panPayload;
    }

    public void setPanPayload(PanPayload panPayload) {
        this.panPayload = panPayload;
    }
}
