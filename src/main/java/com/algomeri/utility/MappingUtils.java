package com.algomeri.utility;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MappingUtils {

    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper;
    }

    /**
     * 
     * @param <T>
     * @param node
     * @param to
     * @return
     * @throws IllegalArgumentException
     * @throws JsonProcessingException
     */
    public <T> T jsonToPojo(JsonNode node, Class<T> to) throws IllegalArgumentException, JsonProcessingException{
        return objectMapper().treeToValue(node, to);
    }

    public <T> List<T> jsonToPojoList(JsonNode node, Class<T> to) throws IOException{
        return objectMapper().readerForListOf(to).readValue(node);
    }

    public <T> List<T> jsonToPojoList(String json, Class<T> to) throws JsonProcessingException, JsonMappingException{
        return objectMapper().readerForListOf(to).readValue(json);
    }

    public <T> T jsonToPojo(String json, Class<T> to) throws JsonProcessingException, JsonMappingException{
        return jsonToPojo(objectMapper().readTree(json), to);
    }

    public JsonNode jsonToNode(String json) throws JsonProcessingException, JsonMappingException{
        return objectMapper().readTree(json);
    }
}
