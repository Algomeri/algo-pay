package com.algomeri.service.payload.paystack;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaystackTransactionInitPayload {

    private String email;
    private String amount;
    private Currency currency;

    private List<String> channels;
    private Map<String, Object> metadata;
    private String reference;

    @JsonProperty(value = "transaction_charge")
    private BigDecimal transactionCharge;

    @JsonProperty(value = "callback_url")
    private String callbackUrl;
}
