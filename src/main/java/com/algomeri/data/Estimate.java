package com.algomeri.data;

public class Estimate {

    /**
     * The actual charge you want to receive after fees have been deducted
     */
    private double charge;

    /**
     * The estimated amount you should charge your customer to receive your actual charge after fees have been decusted
     */
    private double estimatedCharge;

    /**
     * The estimated amount the gateway would charge you for this payment
     */
    private double estimatedFee;
    public Estimate() {
    }
    public Estimate(double charge, double estimatedCharge, double estimatedFee) {
        this.charge = charge;
        this.estimatedCharge = estimatedCharge;
        this.estimatedFee = estimatedFee;
    }
    public double getCharge() {
        return charge;
    }
    public void setCharge(double charge) {
        this.charge = charge;
    }
    public double getEstimatedCharge() {
        return estimatedCharge;
    }
    public void setEstimatedCharge(double estimatedCharge) {
        this.estimatedCharge = estimatedCharge;
    }
    public double getEstimatedFee() {
        return estimatedFee;
    }
    public void setEstimatedFee(double estimatedFee) {
        this.estimatedFee = estimatedFee;
    }
    @Override
    public String toString() {
        return "Estimate [charge=" + charge + ", estimatedCharge=" + estimatedCharge + ", estimatedFee=" + estimatedFee
                + "]";
    }

}
