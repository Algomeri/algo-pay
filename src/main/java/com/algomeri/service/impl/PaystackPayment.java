package com.algomeri.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.payload.PaymentParam;
import com.algomeri.payload.PaymentPayload;
import com.algomeri.response.PaymentChargeResponse;
import com.algomeri.response.PaymentInitializationResponse;
import com.algomeri.response.PaymentResponse;
import com.algomeri.response.PaymentTimelineResponse;
import com.algomeri.response.PaymentVerificationResponse;
import com.algomeri.service.Payment;

public class PaystackPayment implements Payment {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public PaymentVerificationResponse verifyPayment(String identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyPayment'");
    }

    @Override
    public List<PaymentResponse> getPayments(PaymentParam param) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPayments'");
    }

    @Override
    public Optional<PaymentResponse> getPayment(String paymentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPayment'");
    }

    @Override
    public PaymentInitializationResponse initializePayment(PaymentPayload payload) {
        throw new UnsupportedOperationException("Unimplemented method 'initializePayment'");
    }

    @Override
    public PaymentTimelineResponse getPaymentTimeline(String identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentTimeline'");
    }

    @Override
    public PaymentChargeResponse chargeAuthorization(PaymentPayload payload) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chargeAuthorization'");
    }

}
