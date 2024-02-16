package com.algomeri.service;

import com.algomeri.sdk.AlgoPay;

public interface AlgoPayBuilder {
    AlgoPayBuilder withConfiguration(Configuration configuration);
    AlgoPay build();
}
