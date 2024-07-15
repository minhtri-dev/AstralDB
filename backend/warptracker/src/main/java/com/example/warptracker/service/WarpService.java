package com.example.warptracker.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.sql.Timestamp;

import com.example.warptracker.model.API.HonkaiData;
import com.example.warptracker.model.API.HonkaiData.Item;
import com.example.warptracker.model.warptrackerdb.User;
import com.example.warptracker.model.warptrackerdb.Warp;
import com.example.warptracker.repository.WarpRepository;

@Service
public class WarpService {

    @Autowired
    private WarpRepository warpRepository;

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
        HonkaiData honkaiData = new HonkaiData();
        List<Warp> warps = new ArrayList<>();
        String url = "";
        String end_id = "0";

        try {
            UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(api_url)
                .queryParam("size", "20")
                .queryParam("end_id", end_id)
                .queryParam("gacha_type", "12");
            url = urlBuilder.build().toUriString();

            honkaiData = httpRequest(url); 
            List<Item> items = honkaiData.getData().getList();
            
            while (!items.isEmpty()) {
                for (Item item : items) {
                    // Use UID to find user in DB, if user isnt in database use the uid from the api
                    User user = new User(Long.valueOf(item.getUid()));
                    warps.add(new Warp(
                        Long.parseLong(item.getId()),
                        user, 
                        Integer.parseInt(item.getItemId()), 
                        Integer.parseInt(item.getGachaId()),
                        item.getGachaType(),
                        null,
                        Timestamp.valueOf(item.getTime())
                    ));
                    end_id = item.getId();
                }
                urlBuilder.replaceQueryParam("end_id", end_id);
                url = urlBuilder.build().toUriString();
                honkaiData = httpRequest(url); 
                items = honkaiData.getData().getList();
            }
            // Update warptracker database
            warpRepository.saveAll(warps);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return warps;
    }
}
