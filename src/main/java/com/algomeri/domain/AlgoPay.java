package com.algomeri.domain;

import com.algomeri.domain.enumeration.Currency;
import com.algomeri.domain.enumeration.Mode;
import com.algomeri.domain.enumeration.PaymentPlatform;
import com.algomeri.factory.TransactionFactory;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class AlgoPay implements Transaction {

    @NotNull
    private PaymentPlatform paymentPlatform;

    @NotNull
    private Mode mode;

    private Currency currency;
    private String testSecretKey;
    private String testPublicKey;
    private String liveSecretKey;
    private String livePublicKey;

    private static final AlgoPay instance = new AlgoPay();

    private AlgoPay() {}

    public static AlgoPay getInstance() {
        return instance;
    }

    public void assertModeNotNull() {}

    @Override
    public TransactionInitResponse initTransaction(TransactionInitPayload payload) throws Exception {
        Transaction transaction = TransactionFactory.getInstance(paymentPlatform);
        TransactionInitResponse response = transaction.initTransaction(payload);
        return response;
    }
}
