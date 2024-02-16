package com.algomeri.service;

import java.util.List;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;
import com.algomeri.data.CardVerifier;

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
}
