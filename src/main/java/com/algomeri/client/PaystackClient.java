package com.algomeri.client;

import java.io.IOException;
import java.util.Optional;

import com.algomeri.sdk.Paystack;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PaystackClient {

    private static volatile Optional<Retrofit> retrofit = Optional.empty();
    private static volatile PaystackRestClient paystackRestClient;

    private PaystackClient() {

    }

    public static PaystackRestClient client() {
        if (retrofit.isEmpty()) {
            synchronized (Retrofit.class) {
                if (retrofit.isEmpty()) {

                    retrofit = Optional.of(new Retrofit.Builder()
                            .baseUrl("https://api.paystack.co/")
                            .client(interceptor())
                            .addConverterFactory(JacksonConverterFactory.create())
                            .build());
                    paystackRestClient = retrofit.get().create(PaystackRestClient.class);

                }
            }
        }

        return paystackRestClient;
    }

    private static OkHttpClient interceptor() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

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

}
