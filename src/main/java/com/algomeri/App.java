package com.algomeri;

import com.algomeri.domain.AlgoPay;
import com.algomeri.domain.enumeration.PaymentPlatform;
import com.algomeri.factory.TransactionFactory;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        App app = new App();

        Transaction transaction = TransactionFactory.getInstance(PaymentPlatform.PAYSTACK);

        TransactionInitPayload payload = new TransactionInitPayload();
        payload.setAmount("1000");
        payload.setEmail("me@you.com");
        transaction.initTransaction(payload);

        AlgoPay algoPay = AlgoPay.getInstance();
        TransactionInitResponse response = algoPay.initTransaction(payload);
        System.out.println("Response");
        System.out.println(response);
        // app.log.info("Response: {}", response);
    }
}
