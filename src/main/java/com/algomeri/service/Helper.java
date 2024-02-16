package com.algomeri.service;

import java.util.List;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;

public interface Helper {

    public List<Bank> getBanks();

    public AccountVerifier verifyAccountNumber(String accountNumber, String bankCode);

    public void validateCard();
}
