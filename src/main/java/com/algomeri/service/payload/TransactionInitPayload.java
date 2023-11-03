package com.algomeri.service.payload;

import com.algomeri.sdk.enumeration.PaymentChannel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInitPayload {

    private String email;
    private String amount;
    private Currency currency;
    private String redirectUrl;
    private Object customer;

    @Builder.Default
    private List<PaymentChannel> paymentChannels = new ArrayList<>();

    private Map<String, Object> meta;
    private String reference;
    private BigDecimal transactionCharge;
}
