package com.hueston.hue.lights;

import com.hueston.hue.feign.HueResponse;

import javax.ws.rs.*;
import java.util.Map;

public interface HueLightsService {
    @GET
    @Path("/lights")
    Map<String, HueLight> getLights();

    @GET
    @Path("/lights/{id}")
    HueLight getLight(@PathParam("id") Integer id);

    @PUT
    @Path("/lights/{id}/state")
    HueResponse setState(@PathParam("id") Integer id, HueLightState content);
}