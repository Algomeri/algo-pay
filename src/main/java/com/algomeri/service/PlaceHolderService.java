package com.algomeri.service;

import com.algomeri.service.response.Todo;
import java.util.List;

public interface PlaceHolderService {
    List<Todo> getTodos() throws Exception;

    Todo getTodo(Long id);
}
