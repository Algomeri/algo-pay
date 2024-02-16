package com.algomeri.sdk;

import com.algomeri.service.Configuration;
import com.algomeri.service.Payment;

public interface AlgoPay {
    public Configuration configuration();
    public Payment payment();
}
