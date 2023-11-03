package com.algomeri.service.response.paystack;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PaystackResponse {

    private String status;
    private String message;
    private Data data;

    /**
     * Data
     */

    @Getter
    @Setter
    public static class Data {}
}
