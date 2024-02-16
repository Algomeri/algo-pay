package com.algomeri.data;

public interface CardResponse {
    public String getAuthorizationCode();

    public String getLastFourDigits();

    public String getExpirationMonth();

    public String getExpirationYear();

    public String getExpiration();

    public String getCardType();

    public String getBank();

    public String getCountryCode();
}
