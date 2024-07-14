package com.example.warptracker.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.google.gson.Gson;

import com.example.warptracker.repository.WarpRepository;
import com.example.warptracker.model.HonkaiData;
import com.example.warptracker.model.HonkaiData.Item;
import com.example.warptracker.model.Warp;

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

    public List<Warp> populateWarpsFromApi(String api_url) {
        HonkaiData honkaiData = new HonkaiData();
        List<Warp> warps = new ArrayList<>();

        try {
            Map<String, String> params = Map.of(
            "gacha_type", "1",
            "end_id", "0",
            "size", "20",
            "page", "0"
            );

            URIBuilder uriBuilder = new URIBuilder(api_url);
            for (Map.Entry<String, String> entry : params.entrySet()) {
                uriBuilder.addParameter(entry.getKey(), entry.getValue());
            }

            URI uri = uriBuilder.build();
            String url = uri.toString();
            String end_id;
            Integer page = 0;
            
            while (true) {
                honkaiData = httpRequest(url); 
                List<Item> items = honkaiData.getData().getList();
                if (items.size() > 0) {
                    for (Item item : items) {
                        
                    } 
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
        
        
        
        return warpRepository.saveAll(warps);
    }

}
