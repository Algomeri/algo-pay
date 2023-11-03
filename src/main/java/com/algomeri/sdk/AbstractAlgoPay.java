package com.algomeri.sdk;

import com.algomeri.configuration.AlgoPayConfiguration;
import com.algomeri.factory.TransactionFactory;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import lombok.Data;

@Data
public abstract class AbstractAlgoPay implements Transaction {

    private AlgoPayConfiguration configuration;

    @Override
    public TransactionInitResponse initTransaction(TransactionInitPayload payload) throws Exception {
        Transaction transaction = TransactionFactory.getInstance(configuration.getPaymentPlatform());
        TransactionInitResponse response = transaction.initTransaction(payload);
        return response;
    }
}
