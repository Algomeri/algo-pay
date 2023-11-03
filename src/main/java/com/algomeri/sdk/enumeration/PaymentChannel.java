package com.algomeri.sdk.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

/**
 * @author Edward Abattam
 * @since 1.0.0
 * @apiNote
 * <p> Payment channels user is allowed to make payment from
 * <p>Select channels applicable to your payment platform
 */
public enum PaymentChannel {
    /**
     * Paystack channel
     */
    BANK,

    /**
     * Paystack channel
     */
    QR,

    /**
     * Paystack channel
     */
    MOBILE_MONEY,

    /**
     * Paystack channel
     */
    BANK_TRANSFER,

    /**
     * Paystack channel
     */
    EFT,

    /**
     * Flutterwave channel
     */
    NQR,

    /**
     * Flutterwave channel
     */
    BANKTRANSFER,

    /**
     * Flutterwave channel
     */
    CREDIT,

    /**
     * Flutterwave channel
     */
    BARTER,

    /**
     * Flutterwave channel
     */
    MOBILEMONEYZAMBIA,

    /**
     * Flutterwave channel
     */
    MOBILEMONEYRWANDA,

    /**
     * Flutterwave channel
     */
    MOBILEMONEYUGANDA,

    /**
     * Flutterwave channel
     */
    MOBILEMONEYFRANCO,

    /**
     * Flutterwave channel
     */
    MOBILEMONEYGHANA,

    /**
     * Flutterwave channel
     */
    MPESA,

    /**
     * Flutterwave channel
     */
    ACCOUNT,

    /**
     * Paystack & Flutterwave channel
     */
    CARD,

    /**
     * Paystack & Flutterwave channel
     */
    USSD;

    @JsonValue
    public String lowercase() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
