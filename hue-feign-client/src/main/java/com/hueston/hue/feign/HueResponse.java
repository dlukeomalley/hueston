package com.hueston.hue.feign;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@JsonSerialize(as = ImmutableHueResponse.class)
@JsonDeserialize(as = ImmutableHueResponse.class, using = HueResponseDeserializer.class)
public abstract class HueResponse {
    public abstract Map<String, Object> getSuccesses();
    public abstract Map<String, Object> getErrors();
}
