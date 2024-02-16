package com.algomeri;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.data.PaymentVerifier;
import com.algomeri.sdk.AlgoPay;
import com.algomeri.sdk.Paystack;
import com.algomeri.service.impl.PaystackConfig;

public class Check {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public static void name() {
        
        new Paystack.Builder().withConfiguration(new PaystackConfig("", "null")).build();
    }

    @Test
    public void checl() {

        AlgoPay algoPay = Paystack.getInstance();
        Optional<PaymentVerifier> verifier = algoPay.payment().verifyPayment("0nuorm8qhj");
        log.info("response: {}", verifier);
        
        
    }

}
