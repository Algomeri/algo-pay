package com.algomeri.sdk;

import java.util.Optional;

import com.algomeri.service.AlgoPayBuilder;
import com.algomeri.service.Configuration;
import com.algomeri.service.Helper;
import com.algomeri.service.Payment;
import com.algomeri.service.impl.PaystackConfig;
import com.algomeri.service.impl.PaystackHelper;
import com.algomeri.service.impl.PaystackPayment;

import lombok.ToString;

@ToString
public class Paystack implements AlgoPay {

    private PaystackConfig configuration;
    private static volatile Optional<Paystack> instance = Optional.empty();

    private Paystack(Builder builder) {
        this.configuration = builder.configuration;
    }

    private Paystack() {

    }

    private static Paystack buildInstance(Builder builder) {
        if (instance.isEmpty()) {
            synchronized(Paystack.class){
                if (instance.isEmpty()) {
                    instance = Optional.of(new Paystack(builder));
                }
            }
        }

        return instance.get();
    }

    public static Paystack getInstance() {
        if (instance.isEmpty()) {
            synchronized(Paystack.class){
                if (instance.isEmpty()) {
                    instance = Optional.of(new Paystack());
                }
            }
        }

        return instance.get();
    }

    @Override
    public Configuration configuration() {
        return configuration;
    }

    public static class Builder implements AlgoPayBuilder {
        private PaystackConfig configuration;

        @Override
        public AlgoPayBuilder withConfiguration(Configuration configuration) {
            this.configuration = (PaystackConfig) configuration;
            return this;
        }

        @Override
        public AlgoPay build() {
            return buildInstance(this);
        }

    }

    @Override
    public Payment payment() {
        return new PaystackPayment();
    }

    @Override
    public Helper helper() {
        return new PaystackHelper();
    }

}
