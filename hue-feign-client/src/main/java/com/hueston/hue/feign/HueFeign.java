package com.hueston.hue.feign;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs.JAXRSContract;

public class HueFeign {
    public static HueService create(String ip, String user_id) {
        String url = "http://" + ip + "/api/" + user_id;
        return Feign.builder()
                .contract(new JAXRSContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(HueService.class, url);
    }
}