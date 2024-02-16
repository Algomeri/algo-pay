package com.algomeri.response;

import java.util.List;

public interface PaystackLogResponse {

    long getStartTime();

    int getTimeSpent();

    int getAttempts();

    int getErrors();

    boolean isSuccess();

    boolean isMobile();

    List<Object> getInput();

    List<History> getHistory();

    interface History {
        String getType();

        String getMessage();

        int getTime();
    }
}
