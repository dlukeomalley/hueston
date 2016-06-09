package com.hueston.hue.feign;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.Map;

public class HueResponseDeserializer extends JsonDeserializer {
    @Override
    public HueResponse deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Map<String, Object> successes = Maps.newHashMap();
        Map<String, Object> errors = Maps.newHashMap();

        ArrayNode responses = p.getCodec().readTree(p);
        ObjectMapper mapper = new ObjectMapper();

        for (JsonNode node : responses) {
            Map<String, Map<String, Object>> response = mapper.convertValue(node, Map.class);

            if (response.containsKey("success")) {
                for (Map.Entry<String, Object> entry : response.get("success").entrySet()) {
                    successes.put(entry.getKey(), entry.getValue());
                }
            } else if (response.containsKey("error")) {
                for (Map.Entry<String, Object> entry : response.get("error").entrySet()) {
                    errors.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return ImmutableHueResponse.builder()
                .putAllErrors(errors)
                .putAllSuccesses(successes)
                .build();

    }
}
