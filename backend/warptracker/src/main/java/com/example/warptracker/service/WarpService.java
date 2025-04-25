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
import java.util.Arrays;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.sql.Timestamp;

import com.example.warptracker.model.API.HonkaiData;
import com.example.warptracker.model.API.HonkaiData.Item;
import com.example.warptracker.model.warptrackerdb.Warp;
import com.example.warptracker.model.warptrackerdb.User;
import com.example.warptracker.repository.UserRepository;
import com.example.warptracker.repository.WarpRepository;

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
        HonkaiData honkaiData = new HonkaiData();
        String url = "";
        String end_id = "0";
        ArrayList<Integer> gachaTypes = new ArrayList<>(Arrays.asList(1, 2, 11, 12));

        try {
            UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(api_url)
                .queryParam("size", "20")
                .queryParam("end_id", end_id)
                // Need to go through all banner types
                .queryParam("gacha_type", "12");
            url = urlBuilder.build().toUriString();

            honkaiData = httpRequest(url); 
            if (honkaiData == null) {
                throw new RuntimeException("Failed to retrieve data from API: honkaiData is null.");
            }
            List<Item> items = honkaiData.getData().getList();
            Long hsrId = Long.parseLong(items.get(0).getUid());

            while (!items.isEmpty()) {
                for (Item item : items) {
                    // Use UID to find user in DB, if user isnt in database, set user as null
                    User user = userRepository.findByHsrUid(Long.valueOf(item.getUid()));
                    warps.add(new Warp(
                        Long.parseLong(item.getId()),
                        hsrId,
                        // Long.parseLong(item.getHsrId()),
                        Long.valueOf(item.getUid()), 
                        Long.parseLong(item.getItemId()), 
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
                if (items != null) {
                    items = honkaiData.getData().getList();
                }
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
