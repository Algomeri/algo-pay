package com.algomeri.client;

import com.algomeri.payload.impl.PaystackPaymentPayload;
import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PaystackRestClient {

    @POST("transaction/initialize")
    Call<JsonNode> initializePayment(@Body PaystackPaymentPayload payload);

    @GET("transaction/verify/{reference}")
    Call<JsonNode> verifyPayment(@Path("reference") String reference);

    @GET("bank")
    Call<JsonNode> getBanks();

    @GET("bank/resolve")
    Call<JsonNode> validateBankAccount(@Query(value = "account_number") String accountNumber, @Query(value = "bank_code") String bankCode);

    @GET("decision/bin/{bin}")
    Call<JsonNode> validateCard(@Path(value = "bin") String bin);

}
