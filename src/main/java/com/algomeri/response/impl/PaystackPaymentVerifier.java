package com.algomeri.response.impl;

import java.math.BigDecimal;
import java.time.Instant;

import com.algomeri.response.CardResponse;
import com.algomeri.response.CustomerRes;
import com.algomeri.response.PaystackLogResponse;
import com.algomeri.response.PSPayVerify;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@AllArgsConstructor
@ToString
public class PaystackPaymentVerifier implements PSPayVerify {

    @JsonProperty("id")
    private String paymentId;

    @JsonProperty(value = "domain")
    private String domain;

    @JsonProperty(value = "status")
    private String status;


    @JsonProperty(value = "reference")
    private String reference;


    @JsonProperty(value = "amount")
    private BigDecimal amount;


    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "paid_at")
    private Instant datePaid;

    @JsonProperty(value = "created_at")
    private Instant dateCreated;


    @JsonProperty(value = "channel")
    private String channel;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "ip_address")
    private String ipAddress;
    private String metadata;

    @ToString.Exclude
    // private PaystackLogResponse log;
    private int fees;
    private Object fees_split;

    @JsonProperty(value = "authorization")
    private PaystackCardRes card;
    // private PaystackCustomer

    public PaystackPaymentVerifier() {
    }

    @Override
    public String getReference() {
        return reference;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public String getPaymentId() {
        return paymentId;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Instant getDateCreated() {
        return dateCreated;
    }

    @Override
    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    public CustomerRes getCustomer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomer'");
    }

    @Override
    public CardResponse getCard() {
        return card;
    }

    @Override
    public PaystackLogResponse getLog() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLog'");
    }


    /**
     * Builder
     */
    public static class Builder {
    
        
    }


    @Override
    public String getStatus() {
        return status;
    }
}
