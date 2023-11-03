package com.algomeri.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.List;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;

public class Mapper {

    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        return mapper;
    }

    public static ObjectMapper mapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        return mapper;
    }

    public <T> T jsonToPojo(JsonNode node, Class<T> to) throws IllegalArgumentException, JsonProcessingException {
        return objectMapper().treeToValue(node, to);
    }

    public <T> List<T> jsonToPojoList(JsonNode node, Class<T> to) throws IOException {
        return objectMapper().readerForListOf(to).readValue(node);
    }

    public <T> T jsonToPojo(String json, Class<T> to) throws JsonProcessingException, JsonMappingException {
        return jsonToPojo(objectMapper().readTree(json), to);
    }

    public static JsonNode jsonToNode(String json) throws JsonProcessingException, JsonMappingException {
        return mapper().readTree(json);
    }

    public <T> T convert(String response, Class<T> to) throws Exception {
        return jsonToPojo(response, to);
    }

    public <T> List<T> convertList(String response, Class<T> to) throws Exception {
        JsonNode node = objectMapper().valueToTree(response);
        return jsonToPojoList(node, to);
    }

    public static <T> T map(Object from, Class<T> to) {
        return mapper().convertValue(from, to);
    }

    public String toJsonString(Object object) throws JsonProcessingException {
        return objectMapper().writeValueAsString(object);
    }

    public static HttpEntity httpEntity(Object object) throws JsonProcessingException {
        return new StringEntity(mapper().writeValueAsString(object));
    }
}
