package com.algomeri.data.impl;

import com.algomeri.data.PaystackPayInit;

public class PaystackPayInits implements PaystackPayInit{
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
