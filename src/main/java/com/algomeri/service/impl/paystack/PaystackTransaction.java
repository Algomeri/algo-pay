package com.algomeri.service.impl.paystack;

import com.algomeri.configuration.AlgoPayConfiguration;
import com.algomeri.sdk.AlgoPay;
import com.algomeri.sdk.enumeration.PaymentChannel;
import com.algomeri.service.Transaction;
import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.payload.paystack.PaystackTransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;
import com.algomeri.service.response.TransactionVerificationResponse;
import com.algomeri.utility.Mapper;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

@RequiredArgsConstructor
public class PaystackTransaction implements Transaction {

    private final String BASE_URL = "https://api.paystack.co";
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private AlgoPayConfiguration configuration = AlgoPay.getInstance().getConfiguration();

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

        Content content = Request
            .post(url)
            .addHeader(HEADER, PREFIX.concat(configuration.getTestSecretKey()))
            .body(Mapper.httpEntity(paystackPayload))
            .execute()
            .returnContent();
        System.out.println("Content: " + content);

        JsonNode node = Mapper.jsonToNode(content.asString());

        return TransactionInitResponse
            .builder()
            .status(node.get("status").asText())
            .message(node.get("message").asText())
            .paymentUrl(node.at("/data/authorization_url").asText())
            .accessCode(node.at("/data/access_code").asText())
            .build();
    }

    @Override
    public TransactionVerificationResponse verifyTransaction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verifyTransaction'");
    }
}
