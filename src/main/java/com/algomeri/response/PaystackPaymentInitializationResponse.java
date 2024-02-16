package com.algomeri.response;

public interface PaystackPaymentInitializationResponse extends PaymentInitializationResponse{
    String getAuthorizationUrl();
    String getAccessCode();
    String getReference();
}
