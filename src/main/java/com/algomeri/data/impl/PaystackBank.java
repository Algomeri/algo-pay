package com.algomeri.data.impl;

import com.algomeri.data.Bank;

public class PaystackBank implements Bank {
    private String name;
    private String code;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "PaystackBank [name=" + name + ", code=" + code + "]";
    }

}
