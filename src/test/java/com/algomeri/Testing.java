package com.algomeri;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.sdk.AlgoPay;
import com.algomeri.sdk.Paystack;
import com.algomeri.service.impl.PaystackConfiguration;

public class Testing {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void name() {
        AlgoPay algoPay = new Paystack.Builder()
                .withConfiguration(new PaystackConfiguration("secret", "public"))
                .build();
    }

}
