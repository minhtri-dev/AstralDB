package com.example.warptracker.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import java.sql.Timestamp;

import com.example.warptracker.repository.WarpRepository;
import com.example.warptracker.model.HonkaiData;
import com.example.warptracker.model.HonkaiData.Item;
import com.example.warptracker.model.Warp;
import com.example.warptracker.model.User;

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
            honkaiData = httpRequest(api_url); 
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
                    end_id = item.getItemId();
                }
                // url = changeQueryParam(api_url, "end_id", end_id);
                honkaiData = httpRequest(url); 
                if (honkaiData != null) {
                    items = honkaiData.getData().getList();
                }
                
                items = new ArrayList();
            }
            // Update warptracker database
            // warpRepository.saveAll(warps);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
        return warps;
    }

     // Add or update a query parameter
    public String changeQueryParam(String url, String key, String value) {
        if (url.contains(key + "=")) {
            String regex = "([&?])" + Pattern.quote(key) + "=[^&]*";
            return url.replaceAll(regex, "$1" + key + "=" + value);
        } else {
            return url + "&" + key + "=" + value;
        }
    }
}
