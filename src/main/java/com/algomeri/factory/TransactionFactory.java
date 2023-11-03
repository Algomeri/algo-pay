package com.algomeri.factory;

import com.algomeri.sdk.enumeration.PaymentPlatform;
import com.algomeri.service.Transaction;
import com.algomeri.service.impl.paystack.PaystackTransaction;

public class TransactionFactory {

    public static Transaction getInstance(PaymentPlatform platform) throws IllegalAccessException {
        switch (platform) {
            case PAYSTACK:
                return new PaystackTransaction();
            case FLUTTERWAVE:
                return new PaystackTransaction();
            default:
                break;
        }

        throw new IllegalAccessException();
    }
}
