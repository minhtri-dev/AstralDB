package com.minhtri.astraldb.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.sql.Timestamp;

import com.minhtri.astraldb.types.GachaType;
import com.minhtri.astraldb.model.API.HonkaiData;
import com.minhtri.astraldb.model.API.HonkaiData.Item;
import com.minhtri.astraldb.model.warptrackerdb.Warp;
import com.minhtri.astraldb.model.warptrackerdb.User;
import com.minhtri.astraldb.repository.UserRepository;
import com.minhtri.astraldb.repository.WarpRepository;

@Service
public class WarpService {

    @Autowired
    private WarpRepository warpRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();


    public HonkaiData httpRequest(String api_url) {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(api_url))
                .GET()
                .build();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(getResponse.body(), HonkaiData.class);
        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
    }

    public List<Warp> getWarpsFromApi(String api_url) {
        List<Warp> warps = new ArrayList<>();

        HonkaiData honkaiData = httpRequest(api_url);
        if (honkaiData == null || honkaiData.getData() == null) {
            throw new IllegalStateException(honkaiData.getMessage());
        }
        List<Item> items = honkaiData.getData().getList();
        for (Item item : items) {
            User user = userRepository.findByHsrUid(Long.valueOf(item.getUid()));
            Long user_id = null;
            if (user != null) {
                user_id = user.getUserId();
            }
            warps.add(new Warp(
                Long.parseLong(item.getId()),
                user_id,
                Long.valueOf(item.getUid()), 
                Long.parseLong(item.getItemId()), 
                Integer.parseInt(item.getGachaId()),
                item.getGachaType(),
                null,
                Timestamp.valueOf(item.getTime())
            ));
        }
        warpRepository.saveAll(warps);
        
        return warps;
    }
}
