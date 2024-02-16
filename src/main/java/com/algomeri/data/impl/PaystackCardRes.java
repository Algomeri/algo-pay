package com.algomeri.data.impl;

import com.algomeri.data.CardResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.ToString;

@ToString
public class PaystackCardRes implements CardResponse {

    @JsonProperty(value = "authorization_code")
    private String authorizationCode;

    @JsonProperty(value = "last4")
    private String lastFourDigits;

    @JsonProperty(value = "exp_month")
    private String expirationMonth;

    @JsonProperty(value = "exp_year")
    private String expirationYear;

    @JsonProperty(value = "")
    private String expiration;

    @JsonProperty(value = "card_type")
    private String cardType;

    @JsonProperty(value = "bank")
    private String bank;

    @JsonProperty(value = "country_code")
    private String countryCode;

    public PaystackCardRes() {
    }

    public PaystackCardRes(String authorizationCode, String lastFourDigits, String expirationMonth,
            String expirationYear, String expiration, String cardType, String bank, String countryCode) {
        this.authorizationCode = authorizationCode;
        this.lastFourDigits = lastFourDigits;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.expiration = expiration;
        this.cardType = cardType;
        this.bank = bank;
        this.countryCode = countryCode;
    }

    @Override
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    @Override
    public String getLastFourDigits() {
        return lastFourDigits;
    }

    @Override
    public String getExpirationMonth() {
        return expirationMonth;
    }

    @Override
    public String getExpirationYear() {
        return expirationYear;
    }

    @Override
    public String getExpiration() {
        return expiration;
    }

    @Override
    public String getCardType() {
        return cardType;
    }

    @Override
    public String getBank() {
        return bank;
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    public class Builder {
        private String authorizationCode;
        private String lastFourDigits;
        private String expirationMonth;
        private String expirationYear;
        private String expiration;
        private String cardType;
        private String bank;
        private String countryCode;

        public Builder authorizationCode(String authorizationCode) {
            this.authorizationCode = authorizationCode;
            return this;
        }

        public Builder lastFourDigits(String lastFourDigits) {
            this.lastFourDigits = lastFourDigits;
            return this;
        }

        public Builder expirationMonth(String expirationMonth) {
            this.expirationMonth = expirationMonth;
            return this;
        }

        public Builder expirationYear(String expirationYear) {
            this.expirationYear = expirationYear;
            return this;
        }

        public Builder expiration(String expiration) {
            this.expiration = expiration;
            return this;
        }

        public Builder cardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        public Builder bank(String bank) {
            this.bank = bank;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public CardResponse build() {
            return new PaystackCardRes(authorizationCode, lastFourDigits, expirationMonth, expirationYear,
                    expiration, cardType, bank, countryCode);
        }
    }
}
