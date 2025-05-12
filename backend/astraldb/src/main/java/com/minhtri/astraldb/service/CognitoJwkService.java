package com.minhtri.astraldb.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
public class CognitoJwkService {

    @Value("${jwk.url.template}")
    private String JWK_URL_TEMPLATE;

    public Map<String, Object> getJwkKeys(String region, String userPoolId) throws Exception {
        String jwkUrl = String.format(JWK_URL_TEMPLATE, region, userPoolId);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new URI(jwkUrl).toURL(), new com.fasterxml.jackson.core.type.TypeReference<Map<String, Object>>() {});
    }
}
