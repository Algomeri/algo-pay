package com.algomeri.service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response after initialising a transaction
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionInitResponse {

    private String status;
    private String message;
    private String paymentUrl;
    private String accessCode;
}
