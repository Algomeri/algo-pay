package com.algomeri.payload.impl;

import com.algomeri.payload.PSBankParam;
import com.algomeri.payload.enumeration.PaystackCountry;

public class PaystackBankParam implements PSBankParam {
    private PaystackCountry country;

    @Override
    public PaystackCountry getCountry() {
        return country;
    }

}
