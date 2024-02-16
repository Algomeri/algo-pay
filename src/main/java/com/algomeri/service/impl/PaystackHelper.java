package com.algomeri.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;
import com.algomeri.data.impl.PaystackAccountVerifier;
import com.algomeri.data.impl.PaystackBank;
import com.algomeri.service.Helper;
import com.algomeri.utility.MappingUtils;
import com.fasterxml.jackson.databind.JsonNode;

public class PaystackHelper implements Helper {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private MappingUtils mappingUtils = new MappingUtils();

    @Override
    public List<Bank> getBanks() {
        try {
            JsonNode node = PaystackClient.client.getBanks().execute().body();
            List<PaystackBank> banks = mappingUtils.jsonToPojoList(node.get("data"), PaystackBank.class);
            return new ArrayList<>(banks);
        } catch (Exception e) {
            log.error("Error getting banks: {}", e.getMessage());
            throw new RuntimeException("An exception occured while getting banks", e);
        }
    }

    @Override
    public AccountVerifier verifyAccountNumber(String accountNumber, String bankCode) {
        try {
            JsonNode node = PaystackClient.client.validateBankAccount(accountNumber, bankCode).execute().body();
            return mappingUtils.jsonToPojo(node.get("data"), PaystackAccountVerifier.class);
        } catch (Exception e) {
            log.error("Error getting banks: {}", e.getMessage());
            throw new RuntimeException("An exception occured while verifying account number", e);
        }
    }

    @Override
    public void validateCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateCard'");
    }

    

}
