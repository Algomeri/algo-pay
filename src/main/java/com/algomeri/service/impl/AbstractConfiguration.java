package com.algomeri.service.impl;

import com.algomeri.service.Configuration;

public abstract class AbstractConfiguration implements Configuration {
    private String secretKey;
    private String publicKey;

    public AbstractConfiguration(String secretKey, String publicKey) {
        this.secretKey = secretKey;
        this.publicKey = publicKey;
    }

    @Override
    public String getPublicKey() {
        return publicKey;
    }

    @Override
    public String getSecretKey() {
        return secretKey;
    }
}
