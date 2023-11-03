package com.algomeri.service.impl;

import com.algomeri.service.PlaceHolderService;
import com.algomeri.service.response.Todo;
import com.algomeri.utility.Mapper;
import java.io.IOException;
import java.util.List;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Form;
import org.apache.hc.client5.http.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaceHolderServiceImpl implements PlaceHolderService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final Mapper mappingUtility;

    public PlaceHolderServiceImpl(Mapper mappingUtility) {
        this.mappingUtility = mappingUtility;
    }

    @Override
    public List<Todo> getTodos() throws Exception {
        Content content = Request.get("https://jsonplaceholder.typicode.com/todos").execute().returnContent();
        List<Todo> list = mappingUtility.convertList(content.asString(), Todo.class);
        return list;
    }

    @Override
    public Todo getTodo(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTodo'");
    }

    public void name() throws IOException {
        Request
            .post("http://targethost/login")
            .bodyForm(Form.form().add("username", "vip").add("password", "secret").build())
            .execute()
            .returnContent();
    }
}
