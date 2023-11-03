package com.algomeri.utility;

import com.algomeri.service.response.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MappingUtilityTest {

    private Mapper mappingUtility;

    @BeforeEach
    public void init() {
        mappingUtility = new Mapper();
    }

    @Test
    public void name() throws Exception {
        Todo dto = new Todo();
        dto.setId(1);
        dto.setTitle("title");
        dto.setUserId(40);
        dto.setCompleted(true);
        String result = mappingUtility.toJsonString(dto);
        System.out.println(result);
    }
}
