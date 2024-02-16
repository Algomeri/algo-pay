package com.algomeri.client;

import com.algomeri.payload.impl.PaystackPaymentPayload;
import com.fasterxml.jackson.databind.JsonNode;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PaystackRestClient {

    @POST("transaction/initialize")
    Call<JsonNode> initializePayment(@Body PaystackPaymentPayload payload);

    @GET("transaction/verify/{reference}")
    Call<JsonNode> verifyPayment(@Path("reference") String reference);

}
