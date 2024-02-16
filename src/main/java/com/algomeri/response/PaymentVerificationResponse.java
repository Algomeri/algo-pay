package com.algomeri.response;

import java.time.Instant;

public interface PaymentVerificationResponse {
    public String getReference();
    public String getCurrency();
    public String getPaymentId();
    public String getAmount();
    public String getMessage();
    public Instant getDateCreated();
    public String getIpAddress();
    public CustomerResponse getCustomer();
    public CardResponse getCard();
}
