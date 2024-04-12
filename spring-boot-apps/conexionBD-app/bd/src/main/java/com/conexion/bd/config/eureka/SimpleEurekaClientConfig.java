package com.conexion.bd.config.eureka;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
public class SimpleEurekaClientConfig extends EurekaClientConfigBean {

    private String eurekaUrl;
    private String zone;
    private String region;

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public String[] getAvailabilityZones(String s) {
        return new String[]{zone};
    }

    @Override
    public List<String> getEurekaServerServiceUrls(String s) {
        return Arrays.asList(eurekaUrl);
    }

    @Override
    public boolean shouldEnforceRegistrationAtInit() {
        return true;
    }

    @Override
    public boolean shouldRegisterWithEureka() {
        return true;
    }
}