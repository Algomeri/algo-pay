package com.algomeri.data;

public interface PaystackPayInit extends PayInit{
    String getAuthorizationUrl();
    String getAccessCode();
    String getReference();
}
