package com.algomeri.service.impl.paystack;

import com.algomeri.domain.enumeration.PaymentChannel;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.payload.paystack.PaystackTransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import com.algomeri.utility.Mapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

@RequiredArgsConstructor
public class PaystackTransaction implements Transaction {

    private final String BASE_URL = "https://api.paystack.co";

    @Override
    public TransactionInitResponse initTransaction(TransactionInitPayload payload) throws Exception {
        PaystackTransactionInitPayload paystackPayload = PaystackTransactionInitPayload
            .builder()
            .amount(payload.getAmount())
            .email(payload.getEmail())
            .currency(payload.getCurrency())
            .callbackUrl(payload.getRedirectUrl())
            .transactionCharge(payload.getTransactionCharge())
            .metadata(payload.getMeta())
            .channels(payload.getPaymentChannels().stream().map(PaymentChannel::lowercase).collect(Collectors.toList()))
            .build();

        String url = BASE_URL.concat("/transaction/initialize");
        Content content = Request.post(url).body(Mapper.httpEntity(paystackPayload)).execute().returnContent();
        return Mapper.map(content, TransactionInitResponse.class);
    }
}
