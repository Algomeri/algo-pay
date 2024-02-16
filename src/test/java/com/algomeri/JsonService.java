package com.algomeri;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonService {
    
    @GET("todos/{id}")
    Call<Todo> getTodo(@Path("id") int todoId);

    @GET("todos")
    Call<List<Todo>> getTodos();
}
