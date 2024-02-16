package com.algomeri.payload;

import com.algomeri.payload.enumeration.PaystackCountry;

public interface PSBankParam extends BankParam {
    PaystackCountry getCountry();
}
