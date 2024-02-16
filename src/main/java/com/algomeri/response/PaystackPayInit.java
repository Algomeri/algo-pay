package com.algomeri.response;

public interface PaystackPayInit extends PayInit{
    String getAuthorizationUrl();
    String getAccessCode();
    String getReference();
}
