package com.algomeri.factory;

import com.algomeri.sdk.enumeration.PaymentPlatform;
import com.algomeri.service.Transaction;
import com.algomeri.service.impl.paystack.PaystackTransaction;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionFactoryTest {

    @Test
    public void testGetInstance() throws Exception {
        for (PaymentPlatform platform : PaymentPlatform.values()) {
            switch (platform) {
                case PAYSTACK:
                    Transaction transaction = TransactionFactory.getInstance(platform);
                    Assertions.assertThat(transaction).isInstanceOf(PaystackTransaction.class);
                    break;
                default:
            }
        }
    }
}
