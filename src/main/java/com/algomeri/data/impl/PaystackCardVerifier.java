package com.algomeri.data.impl;

import com.algomeri.data.CardVerifier;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaystackCardVerifier implements CardVerifier {

    @JsonProperty(value = "country_name")
    private String country;
    private String brand;
    private String bank;
    private String bin;

    public PaystackCardVerifier() {
    }

    public PaystackCardVerifier(String country, String brand, String bank, String bin) {
        this.country = country;
        this.brand = brand;
        this.bank = bank;
        this.bin = bin;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String getBank() {
        return bank;
    }

    @Override
    public String getBin() {
        return bin;
    }

    @Override
    public String toString() {
        return "PaystackCardVerifier [country=" + country + ", brand=" + brand + ", bank=" + bank + ", bin=" + bin
                + "]";
    }

}
