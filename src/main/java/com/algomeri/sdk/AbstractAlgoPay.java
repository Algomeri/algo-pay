package com.algomeri.sdk;

import com.algomeri.configuration.AlgoPayConfiguration;
import com.algomeri.factory.TransactionFactory;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import com.algomeri.service.response.TransactionVerificationResponse;
import lombok.Data;

/**
 * @author Edward Abattam
 * @since 1.0.0
 */
@Data
public abstract class AbstractAlgoPay implements Transaction {

    private AlgoPayConfiguration configuration;

    @Override
    public TransactionInitResponse initTransaction(TransactionInitPayload payload) throws Exception {
        Transaction transaction = TransactionFactory.getInstance(configuration.getPaymentPlatform());
        TransactionInitResponse response = transaction.initTransaction(payload);
        return response;
    }

    @Override
    public TransactionVerificationResponse verifyTransaction() {
        // TODO Auto-generated method stub
        return null;
    }
}
