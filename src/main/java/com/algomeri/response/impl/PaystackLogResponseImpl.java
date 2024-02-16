package com.algomeri.response.impl;

import java.time.Instant;
import java.util.List;

import com.algomeri.response.PaystackLogResponse;

public class PaystackLogResponseImpl implements PaystackLogResponse{

    private Instant startTime;
    private int timeSpent;
    private int attempts;
    private int errors;
    private boolean success;
    private boolean mobile;
    private List<History> history;
    
    public PaystackLogResponseImpl() {
    }
    
    public PaystackLogResponseImpl(Instant startTime, int timeSpent, int attempts, int errors, boolean success,
            boolean mobile, List<History> history) {
        this.startTime = startTime;
        this.timeSpent = timeSpent;
        this.attempts = attempts;
        this.errors = errors;
        this.success = success;
        this.mobile = mobile;
        this.history = history;
    }
    @Override
    public Instant getStartTime() {
       return startTime;
    }
    @Override
    public int getTimeSpent() {
        return timeSpent;
    }
    @Override
    public int getAttempts() {
        return attempts;
    }
    @Override
    public int getErrors() {
        return errors;
    }
    @Override
    public boolean isSuccess() {
        return success;
    }
    @Override
    public boolean isMobile() {
        return mobile;
    }
    @Override
    public List<History> getHistory() {
        return history;
    }


public static class Builder {
    private Instant startTime;
    private int timeSpent;
    private int attempts;
    private int errors;
    private boolean success;
    private boolean mobile;
    private List<History> history;

    public Builder setStartTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public Builder setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
        return this;
    }

    public Builder setAttempts(int attempts) {
        this.attempts = attempts;
        return this;
    }

    public Builder setErrors(int errors) {
        this.errors = errors;
        return this;
    }

    public Builder setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public Builder setMobile(boolean mobile) {
        this.mobile = mobile;
        return this;
    }

    public Builder setHistory(List<History> history) {
        this.history = history;
        return this;
    }

    public PaystackLogResponse build() {
        return new PaystackLogResponseImpl(startTime, timeSpent, attempts, errors, success, mobile, history);
    }
}
}
