package com.algomeri.sdk.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

/**
 * @author Edward Abattam
 * @since 1.0.0
 * @apiNote
 * <p> Platform to use for operations. Currently offers support to only paytack </p>
 */
public enum PaymentPlatform {
    PAYSTACK,
    FLUTTERWAVE;

    @JsonValue
    public String lowercase() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
