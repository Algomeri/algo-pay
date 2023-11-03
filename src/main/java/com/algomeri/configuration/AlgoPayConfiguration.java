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

    @Builder.Default
    private Mode mode = Mode.TEST;

    @Builder.Default
    private Currency currency = Currency.NGN;

    private String testSecretKey;
    private String testPublicKey;
    private String liveSecretKey;
    private String livePublicKey;

    private String secretKey;
    private String publicKey;

    private PaymentPlatform paymentPlatform;

    public void setSecretKey() {
        if (mode.equals(Mode.TEST)) {
            secretKey = getTestSecretKey();
        } else if (mode.equals(Mode.LIVE)) {
            secretKey = getLiveSecretKey();
        }
    }

    public void setPublicKey() {
        if (mode.equals(Mode.TEST)) {
            publicKey = getTestPublicKey();
        } else if (mode.equals(Mode.LIVE)) {
            publicKey = getLivePublicKey();
        }
    }
}
