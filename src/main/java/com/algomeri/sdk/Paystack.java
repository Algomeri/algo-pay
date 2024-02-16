package com.algomeri.sdk;

import java.util.Optional;

import com.algomeri.service.AlgoPayBuilder;
import com.algomeri.service.Configuration;
import com.algomeri.service.Payment;
import com.algomeri.service.impl.PaystackConfiguration;
import com.algomeri.service.impl.PaystackPayment;

public class Paystack implements AlgoPay {

    private PaystackConfiguration configuration;
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
        private PaystackConfiguration configuration;

        @Override
        public AlgoPayBuilder withConfiguration(Configuration configuration) {
            this.configuration = (PaystackConfiguration) configuration;
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

}
