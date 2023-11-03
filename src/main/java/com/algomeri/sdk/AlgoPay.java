package com.algomeri.sdk;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Edward Abattam
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public final class AlgoPay extends AbstractAlgoPay {

    private static final AlgoPay instance = new AlgoPay();

    private AlgoPay() {}

    public static AlgoPay getInstance() {
        return instance;
    }
}
