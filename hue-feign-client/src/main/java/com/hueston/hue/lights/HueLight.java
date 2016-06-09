package com.hueston.hue.lights;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hueston.hue.feign.ImmutableHueLight;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableHueLight.class)
@JsonDeserialize(as = ImmutableHueLight.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class HueLight {
    public abstract HueLightState getState();
    public abstract String getType();
    public abstract String getName();
    public abstract String getUniqueid();
}
