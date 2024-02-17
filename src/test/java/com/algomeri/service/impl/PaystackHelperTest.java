package com.algomeri.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.data.AccountVerifier;
import com.algomeri.data.Bank;
import com.algomeri.data.Estimate;
import com.algomeri.data.impl.PaystackAccountVerifier;
import com.algomeri.data.impl.PaystackBank;
import com.algomeri.utility.MappingUtils;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PaystackHelperTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private MappingUtils mappingUtils;

    @InjectMocks
    private PaystackHelper helper;

    @Mock
    private PaystackClient paystackClient;

    @Test
    public void testEstimateWithChargeBelow2500() {
        final double AMOUNT = 400.3;
        final Boolean isLocalPayment = true;
        Estimate estimate = helper.estimateFee(AMOUNT, isLocalPayment);

        double roundedCharge = Double.valueOf(String.format("%.2f", estimate.getEstimatedCharge()));
        double roundedFee = Double.valueOf(String.format("%.2f", estimate.getEstimatedFee()));

        assertThat(AMOUNT).isNotEqualTo(estimate.getEstimatedCharge());
        assertThat(AMOUNT).isEqualTo(roundedCharge - roundedFee);
    }

    @Test
    public void testEstimateWithChargeAbove2500() {
        final double AMOUNT = 3000;
        final Boolean isLocalPayment = true;
        Estimate estimate = helper.estimateFee(AMOUNT, isLocalPayment);

        double roundedCharge = Double.valueOf(String.format("%.2f", estimate.getEstimatedCharge()));
        double roundedFee = Double.valueOf(String.format("%.2f", estimate.getEstimatedFee()));

        assertThat(AMOUNT).isNotEqualTo(estimate.getEstimatedCharge());
        assertThat(AMOUNT).isEqualTo(roundedCharge - roundedFee);
    }

    @Test
    public void testEstimateWithFeeAbove() {
        final double AMOUNT = 400000;
        final Boolean isLocalPayment = true;
        final double MAX_FEE = 2000l;
        Estimate estimate = helper.estimateFee(AMOUNT, isLocalPayment);

        double roundedCharge = Double.valueOf(String.format("%.2f", estimate.getEstimatedCharge()));
        double roundedFee = Double.valueOf(String.format("%.2f", estimate.getEstimatedFee()));

        assertThat(AMOUNT).isNotEqualTo(estimate.getEstimatedCharge());
        assertThat(AMOUNT).isEqualTo(roundedCharge - roundedFee);
        assertThat(estimate.getEstimatedFee()).isEqualTo(MAX_FEE);
    }

    @Test
    public void testEstimateWithInternationalPayment() {
        final double AMOUNT = 400000;
        final Boolean isLocalPayment = false;
        Estimate estimate = helper.estimateFee(AMOUNT, isLocalPayment);

        double roundedCharge = Double.valueOf(String.format("%.2f", estimate.getEstimatedCharge()));
        double roundedFee = Double.valueOf(String.format("%.2f", estimate.getEstimatedFee()));

        assertThat(AMOUNT).isNotEqualTo(estimate.getEstimatedCharge());
        assertThat(AMOUNT).isEqualTo(roundedCharge - roundedFee);
    }

    @Test
    public void getBanks() throws Exception {
        final String BANK_NAME = "my bank";
        final String BANK_CODE = "my code";

        when(paystackClient.getBanks()).thenReturn(List.of(new PaystackBank(BANK_NAME, BANK_CODE)));

        List<Bank> banks = helper.getBanks();
        assertThat(banks).isNotNull();
        assertThat(banks).isNotEmpty();
        assertThat(banks).element(0).isInstanceOf(Bank.class);
        assertThat(banks).element(0).extracting("name").isEqualTo(BANK_NAME);
        assertThat(banks).element(0).extracting("code").isEqualTo(BANK_CODE);
    }

    @Test
    public void verifyBankAccount() throws Exception {
        final String ACCOUNT_NUMBER = "123458896";
        final String ACCOUNT_NAME = "my name";
        final String BANK_CODE = "047";

        when(paystackClient.verifyAccountNumber(any(), any())).thenReturn(new PaystackAccountVerifier(ACCOUNT_NUMBER, ACCOUNT_NAME));

        AccountVerifier verifier = helper.verifyAccountNumber(ACCOUNT_NUMBER, BANK_CODE);
        verifier.toString();
        assertThat(verifier).isNotNull();
        assertThat(verifier.getAccountName()).isEqualTo(ACCOUNT_NAME);
        assertThat(verifier.getAccoutNumber()).isEqualTo(ACCOUNT_NUMBER);
        assertThat(verifier).isNotEqualTo(new PaystackAccountVerifier());
    }

}
