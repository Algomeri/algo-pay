package com.algomeri.service;

import com.algomeri.service.payload.TransactionInitPayload;
import com.algomeri.service.response.TransactionInitResponse;

public interface Transaction {
    TransactionInitResponse initTransaction(TransactionInitPayload payload) throws Exception;
}
