package com.algomeri.service.impl;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.algomeri.data.Estimate;
import com.algomeri.sdk.Paystack;
import com.algomeri.service.Helper;
import static org.assertj.core.api.Assertions.assertThat;

public class PaystackHelperTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    Helper helper = Paystack.getInstance().helper();
    

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

}
