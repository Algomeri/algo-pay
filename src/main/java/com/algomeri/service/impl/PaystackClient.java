package com.algomeri.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.algomeri.client.PaystackRestClient;
import com.algomeri.data.AccountVerifier;
import com.algomeri.data.impl.PaystackAccountVerifier;
import com.algomeri.data.impl.PaystackBank;
import com.algomeri.sdk.Paystack;
import com.algomeri.utility.MappingUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

class PaystackClient {

    private static volatile Optional<Retrofit> retrofit = Optional.empty();
    private static volatile PaystackRestClient client = client();
    MappingUtils mappingUtils = new MappingUtils();

    public static PaystackRestClient client() {
        if (retrofit.isEmpty()) {
            synchronized (Retrofit.class) {
                if (retrofit.isEmpty()) {

                    retrofit = Optional.of(new Retrofit.Builder()
                            .baseUrl("https://api.paystack.co/")
                            .client(interceptor())
                            .addConverterFactory(JacksonConverterFactory.create())
                            .build());
                    client = retrofit.get().create(PaystackRestClient.class);

                }
            }
        }

        return client;
    }

    private static OkHttpClient interceptor() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                System.out.println(Paystack.getInstance());

                // Create a new request with added headers
                Request modifiedRequest = request.newBuilder()
                        .header("Authorization",
                                "Bearer ".concat(Paystack.getInstance().configuration().getSecretKey()))
                        .header("Content-Type", "application/json")
                        .build();

                // Proceed with the modified request
                return chain.proceed(modifiedRequest);
            }
        });

        return httpClient.build();
    }

    public List<PaystackBank> getBanks() {
        try {
            Call<JsonNode> call = client.getBanks();
            JsonNode node = call.execute().body();
            List<PaystackBank> banks = mappingUtils.jsonToPojoList(node.get("data"), PaystackBank.class);
            return new ArrayList<>(banks);
        } 
        catch(JsonProcessingException e){
            throw new RuntimeException("Error getting banks", null);
        }
        catch (Exception e) {
            throw new RuntimeException("Error getting banks", null);
        }
    }

    public AccountVerifier verifyAccountNumber(String accountNumber, String bankCode) {
        try {
            JsonNode node = client.validateBankAccount(accountNumber, bankCode).execute().body();
            return mappingUtils.jsonToPojo(node.get("data"), PaystackAccountVerifier.class);
        } catch (Exception e) {
            throw new RuntimeException("An exception occured while verifying account number", e);
        }
    }
}
