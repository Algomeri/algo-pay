package com.algomeri.sdk;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public final class AlgoPay extends AbstractAlgoPay {

    private static final AlgoPay instance = new AlgoPay();

    private AlgoPay() {}

    public static AlgoPay getInstance() {
        return instance;
    }
}
