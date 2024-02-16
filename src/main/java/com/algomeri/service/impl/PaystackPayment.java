package com.algomeri.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.payload.PaymentParam;
import com.algomeri.payload.PaymentPayload;
import com.algomeri.response.ChargeRes;
import com.algomeri.response.PayInit;
import com.algomeri.response.PaymentResponse;
import com.algomeri.response.PayTimeline;
import com.algomeri.response.PaymentVerifier;
import com.algomeri.response.impl.PaystackPaymentVerifier;
import com.algomeri.service.Payment;
import com.algomeri.utility.MappingUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.Response;

public class PaystackPayment implements Payment {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private MappingUtils mappingUtils = new MappingUtils();

    @Override
    public Optional<PaymentVerifier> verifyPayment(String identifier) {
        Optional<PaymentVerifier> verifier = Optional.empty();
        // PaystackPaymentVerifier response = new PaystackPaymentVerifier();
        try {
            Call<JsonNode> call = PaystackClient.client.verifyPayment(identifier);
            Response<JsonNode> res = call.execute();
            JsonNode node = res.body();

            if (node.has("data")) {
                JsonNode data = node.get("data");
                PaymentVerifier response = mappingUtils.jsonToPojo(data, PaystackPaymentVerifier.class);
                verifier =  Optional.ofNullable(response);
            }
        } 
        catch (JsonProcessingException e) {
            log.error("Error processing json after verifying payment with message: {}", e.getMessage());
        }
        catch (IOException e) {
            log.error("Error verifying payment with message: {}", e.getMessage());
        }
        catch(IllegalArgumentException e){
            log.error("Error processing json after verifying payment with message: {}", e.getMessage());
        }
        catch (Exception e) {
            log.error("Error verifying payment with message: {}", e.getMessage());
        }

        return verifier;
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
