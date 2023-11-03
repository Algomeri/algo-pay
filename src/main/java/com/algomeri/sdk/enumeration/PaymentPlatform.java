package com.algomeri.sdk.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

public enum PaymentPlatform {
    PAYSTACK,
    FLUTTERWAVE;

    @JsonValue
    public String lowercase() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
