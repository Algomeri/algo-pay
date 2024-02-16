package com.algomeri.data;

import java.math.BigDecimal;
import java.time.Instant;

public interface PaymentVerifier {
    public String getReference();
    public String getCurrency();
    public String getPaymentId();
    public BigDecimal getAmount();
    public String getMessage();
    public Instant getDateCreated();
    public String getIpAddress();
    public CustomerRes getCustomer();
    public CardResponse getCard();
    public String getStatus();
}
