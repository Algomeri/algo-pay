package com.algomeri.service.impl;

import org.junit.jupiter.api.Test;

import com.algomeri.sdk.AlgoPay;
import com.algomeri.sdk.Paystack;
import com.algomeri.service.Helper;

public class PaystackHelperTest {

    Helper helper = Paystack.getInstance().helper();
    

    @Test
    public void testEstimate() {
        final double AMOUNT = 5000;
        final Boolean isLocalPayment = true;
        helper.estimateFee(AMOUNT, isLocalPayment);
        
    }

}
