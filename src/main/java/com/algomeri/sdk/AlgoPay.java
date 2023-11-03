package com.algomeri.sdk;

import com.algomeri.configuration.AlgoPayConfiguration;
import com.algomeri.factory.TransactionFactory;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public final class AlgoPay implements Transaction {

    private AlgoPayConfiguration configuration;

    private static final AlgoPay instance = new AlgoPay();

    private AlgoPay() {}

    public static AlgoPay getInstance() {
        return instance;
    }

    @Override
    public TransactionInitResponse initTransaction(TransactionInitPayload payload) throws Exception {
        Transaction transaction = TransactionFactory.getInstance(configuration.getPaymentPlatform());
        TransactionInitResponse response = transaction.initTransaction(payload);
        return response;
    }
}
