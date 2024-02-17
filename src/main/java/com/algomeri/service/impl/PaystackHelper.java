package com.algomeri.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;
import com.algomeri.data.CardVerifier;
import com.algomeri.data.Estimate;
import com.algomeri.data.impl.PaystackCardVerifier;
import com.algomeri.service.Helper;
import com.algomeri.utility.MappingUtils;
import com.fasterxml.jackson.databind.JsonNode;

public class PaystackHelper implements Helper {
    private MappingUtils mappingUtils = new MappingUtils();
    private PaystackClient paystackClient = new PaystackClient();

    @Override
    public List<Bank> getBanks() {
       return new ArrayList<>(paystackClient.getBanks());
    }

    @Override
    public AccountVerifier verifyAccountNumber(String accountNumber, String bankCode) {
        return paystackClient.verifyAccountNumber(accountNumber, bankCode);
    }

    @Override
    public CardVerifier validateCard(String bin) {
        try {
            JsonNode node = PaystackClient.client().validateCard(bin).execute().body();
            return mappingUtils.jsonToPojo(node.get("data"), PaystackCardVerifier.class);
        } catch (Exception e) {
            throw new RuntimeException("An exception occured while verifying card", e);
        }
    }

    @Override
    public Estimate estimateFee(double amount, Boolean isLocalPayment) {
        isLocalPayment = Objects.requireNonNullElse(isLocalPayment, true);
        double fee = 0.015;
        double maxLocalCharge = 2000;
        double estimatedCharge = 0;
        double estimatedFee = 0;
        if (isLocalPayment) {
            if (amount < 2500) {
                estimatedCharge = amount / (1 - fee) + 0.01;
                estimatedFee = estimatedCharge * fee  + 0.01;
            }
            else{
                estimatedCharge = (amount / (1 - fee) + 101.539) ;
                estimatedFee = estimatedCharge * fee  + 100.01;
                estimatedCharge = amount + estimatedFee;

                if (estimatedFee > maxLocalCharge) {
                    estimatedFee = maxLocalCharge;
                    estimatedCharge = amount + estimatedFee;
                }
            }
        }
        else{
            estimatedCharge = amount / (1 - fee) + 0.01;
            estimatedFee = estimatedCharge * fee  + 0.01;
        }
        return new Estimate(amount, estimatedCharge, estimatedFee);
    }

   

    

}
