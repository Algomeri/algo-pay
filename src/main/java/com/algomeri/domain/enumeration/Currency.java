package com.algomeri.domain.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Locale;

public enum Currency {
    NGN,
    USD,
    GHS,
    ZAR,
    KES;

    @JsonValue
    public String lowercase() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
