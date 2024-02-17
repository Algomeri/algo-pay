package com.algomeri.data.impl;

import com.algomeri.data.AccountVerifier;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaystackAccountVerifier implements AccountVerifier {
    @JsonProperty(value = "account_number")
    private String accountNumber;
    @JsonProperty(value = "account_name")
    private String accountName;

    public PaystackAccountVerifier() {
    }

    public PaystackAccountVerifier(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    @Override
    public String getAccoutNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return "PaystackAccountVerifier [accountNumber=" + accountNumber + ", accountName=" + accountName + "]";
    }

}
