package com.hueston.hue.lights;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hueston.hue.feign.ImmutableHueLightState;
import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableHueLightState.class)
@JsonDeserialize(as = ImmutableHueLightState.class)
public abstract class HueLightState {
    @Nullable
    public abstract Boolean getOn();

    @Nullable
    public abstract Integer getBri();

    @Nullable
    public abstract Integer getHue();

    @Nullable
    public abstract Integer getSat();

    @Nullable
    public abstract List<Float> getXy();

    @Nullable
    public abstract Integer getCt();

    @Nullable
    public abstract String getEffect();

    @Nullable
    public abstract String getAlert();

    @Nullable
    public abstract String getColormode();

    @Nullable
    public abstract Boolean getReachable();
}
