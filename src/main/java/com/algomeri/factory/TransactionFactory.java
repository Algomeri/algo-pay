package com.algomeri.factory;

import com.algomeri.sdk.enumeration.PaymentPlatform;
import com.algomeri.service.Transaction;
import com.algomeri.service.impl.paystack.PaystackTransaction;

/**
 * @author Edward Abattam
 * @since 1.0.0
 * @apiNote Factory class for getting a type of transaction
 */
public class TransactionFactory {

    /**
     *
     * @param platform the payment platform to use. Defaults to {@link PaystackTransaction}
     * @return {@link Transaction}
     */
    public static Transaction getInstance(PaymentPlatform platform) {
        switch (platform) {
            case PAYSTACK:
                return new PaystackTransaction();
            default:
                return new PaystackTransaction();
        }
    }
}
