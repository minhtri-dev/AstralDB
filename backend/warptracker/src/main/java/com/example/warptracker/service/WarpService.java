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

import com.example.warptracker.types.GachaType;
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
        List<GachaType> gachaTypes = Arrays.asList(
            GachaType.STANDARD,
            GachaType.BEGINNER,
            GachaType.LIMITED_CHARACTER,
            GachaType.LIMITED_WEAPON
        );

        try {
            for (GachaType gachaType : gachaTypes) {
            String end_id = "0";
            boolean hasMore = true;

            while (hasMore) {
                String url = UriComponentsBuilder.fromUriString(api_url)
                    .queryParam("size", "20")
                    .queryParam("end_id", end_id)
                    .queryParam("gacha_type", gachaType.getId())
                    .build().toUriString();

                HonkaiData honkaiData = httpRequest(url);
                if (honkaiData == null || honkaiData.getData() == null) break;

                List<Item> items = honkaiData.getData().getList();
                if (items == null || items.isEmpty()) break;

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
                    end_id = item.getId();
                }

                hasMore = items.size() == 20;
            }
        }

        warpRepository.saveAll(warps);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return warps;
    }
}
