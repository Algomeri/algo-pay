package com.algomeri.response.impl;

import com.algomeri.response.PaystackPaymentInitializationResponse;

public class PaystackPaymentInitializationResponseImpl implements PaystackPaymentInitializationResponse{
    private String authorizationUrl;
    private String accessCode;
    private String reference;

    @Override
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }
    @Override
    public String getAccessCode() {
        return accessCode;
    }
    @Override
    public String getReference() {
        return reference;
    }
}
