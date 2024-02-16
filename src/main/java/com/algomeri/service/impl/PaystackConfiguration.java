package com.algomeri.service.impl;

import com.algomeri.service.Configuration;

import lombok.ToString;

@ToString
public class PaystackConfiguration implements Configuration{
    private String secretKey;
    private String publicKey;

    public PaystackConfiguration(String secretKey, String publicKey) {
        this.secretKey = secretKey;
        this.publicKey = publicKey;
    }

    @Override
    public String getSecretKey() {
        return secretKey;
    }

    @Override
    public String getPublicKey() {
        return publicKey;
    }

}
