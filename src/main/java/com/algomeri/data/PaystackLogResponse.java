package com.algomeri.data;

import java.time.Instant;
import java.util.List;

public interface PaystackLogResponse {

    Instant getStartTime();

    int getTimeSpent();

    int getAttempts();

    int getErrors();

    boolean isSuccess();

    boolean isMobile();

    List<History> getHistory();

    interface History {
        String getType();

        String getMessage();

        Instant getTime();
    }
}
