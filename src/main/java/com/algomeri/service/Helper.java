package com.algomeri.service;

import java.util.List;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;
import com.algomeri.data.CardVerifier;
import com.algomeri.data.Estimate;

/**
 * This contains contracts for providing useful methods that help in the payment process
 * @author Edward Abattam
 * @since 1.0
 */
public interface Helper {

    /**
     * Used to retrieve a list of {@link Bank}s.
     * <br>
     * This is particularly useful when trying to display a list of banks to select from or to prepoulate a local DB with banks
     * @return {@link List}<{@link Bank}>
     */
    public List<Bank> getBanks();

    /**
     * Used to verify an account number. 
     * <p>Particularly useful when you want to be certain an account exists and it bears the same name as the user.
     * @param accountNumber
     * @param bankCode
     * @return {@link AccountVerifier}
     * @see Helper#getBanks()
     */
    public AccountVerifier verifyAccountNumber(String accountNumber, String bankCode);

    /**
     * Used to get more information on a card
     * @param bin -> first six digits of card
     * @return {@link CardVerifier}
     */
    public CardVerifier validateCard(String bin);

    /**
     * This is useful when you're trying to make sure you get your full sum after settlement.
     * <p>Example, your charge is 5000 and gateway fee is 1.5%.
     * This returns an estimated amout you should charge your customer in order to still
     * receive 5000 after gateway fees have been deducted.
     * This is only applicable to Nigerian businesses if implementing for flutterwave
     * @param amount -> the actual amount you want to receive after user pays
     * @param isLocalPayment -> defaults to true if null
     * @return {@link Estimate}
     */
    public Estimate estimateFee(double amount, Boolean isLocalPayment);
}
