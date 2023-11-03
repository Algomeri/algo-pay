package com.algomeri.service.response;

import lombok.Data;

/**
 * Response after initialising a transaction
 */
@Data
public class TransactionInitResponse {

    private String status;
    private String paymentUrl;
    private String accessCode;
}
