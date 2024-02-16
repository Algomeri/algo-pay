package com.algomeri;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;
import com.algomeri.data.PaymentVerifier;
import com.algomeri.sdk.AlgoPay;
import com.algomeri.sdk.Paystack;
import com.algomeri.service.impl.PaystackConfig;

public class Check {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    AlgoPay algoPay = new Paystack.Builder().withConfiguration(new PaystackConfig("", "null")).build();

    @BeforeAll
    public static void name() {
        
        
    }

    @Test
    public void checl() {

        AlgoPay algoPay = Paystack.getInstance();
        Optional<PaymentVerifier> verifier = algoPay.payment().verifyPayment("0nuorm8qhj");
        log.info("response: {}", verifier);
        
        
    }

    @Test
    public void getBanks() {
        algoPay = Paystack.getInstance();
        List<Bank> banks = algoPay.helper().getBanks();
        log.info("Banks: {}", banks);
        
    }

    @Test
    public void verifyAccount() {
        AccountVerifier verifier = algoPay.helper().verifyAccountNumber("7045553461", "999992");
        log.info("response: {}", verifier);
    }

}
