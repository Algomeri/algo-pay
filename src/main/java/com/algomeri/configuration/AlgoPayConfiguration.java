package com.algomeri.configuration;

import com.algomeri.sdk.enumeration.Currency;
import com.algomeri.sdk.enumeration.Mode;
import com.algomeri.sdk.enumeration.PaymentPlatform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlgoPayConfiguration {

    private Mode mode;
    private Currency currency;
    private String testSecretKey;
    private String testPublicKey;
    private String liveSecretKey;
    private String livePublicKey;
    private PaymentPlatform paymentPlatform;
}
