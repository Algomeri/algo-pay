package com.algomeri.service.impl;

import java.util.List;
import java.util.Optional;

import com.algomeri.data.ChargeRes;
import com.algomeri.data.PayInit;
import com.algomeri.data.PayTimeline;
import com.algomeri.data.PaymentResponse;
import com.algomeri.data.PaymentVerifier;
import com.algomeri.data.impl.PaystackPaymentVerifier;
import com.algomeri.payload.PaymentParam;
import com.algomeri.payload.PaymentPayload;
import com.algomeri.service.Payment;
import com.algomeri.utility.MappingUtils;
import com.fasterxml.jackson.databind.JsonNode;

public class PaystackPayment implements Payment {
    private MappingUtils mappingUtils = new MappingUtils();

    @Override
    public PaymentVerifier verifyPayment(String identifier) {
        try {
            JsonNode node = PaystackClient.client.verifyPayment(identifier).execute().body();
            return mappingUtils.jsonToPojo(node.get("data"), PaystackPaymentVerifier.class);
        } catch (Exception e) {
            throw new RuntimeException("An exception occurred while trying to verify payment", e);
        }
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
    public PayInit initializePayment(PaymentPayload payload) {
        throw new UnsupportedOperationException("Unimplemented method 'initializePayment'");
    }

    @Override
    public PayTimeline getPaymentTimeline(String identifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentTimeline'");
    }

    @Override
    public ChargeRes chargeAuthorization(PaymentPayload payload) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chargeAuthorization'");
    }

}
