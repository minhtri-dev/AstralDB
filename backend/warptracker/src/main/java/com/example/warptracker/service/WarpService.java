package com.example.warptracker.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.example.warptracker.repository.WarpRepository;
import com.example.warptracker.model.api_response;

@Service
public class WarpService {

    @Autowired
    private WarpRepository warpRepository;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    private String EXTERNAL_API_URL = "https://api-os-takumi.mihoyo.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&lang=en&authkey=DY4Wjzr3d3JZIwY4KRGrHuf6Rb4uVh%2fSl4GkyfEWr1WzhXJ0hp3vE9thKW7%2fIEx3ay1zF96GRBoZ7pZJpqY%2fhNjIVJynFxIPRKbtFGRq6cQ71A%2fb6wibxvFzG%2f9atESDAA%2fPPR2T7KLyZAOWefemnj%2bUJ9btzC7KheHaF3TaOyUaR9wvWgz1eaPvYfxRQJLJPsLZfac%2fx569FYnzzN2gRFGwQTIXlMpCFASVs5FeRM74Tcmmgv6ylxEBcE%2f4q%2b5obI%2fJw9giZp5GtohlBpBMh0WXGddRXgCr0eomRjHf4KOzOpBCitGruVbYjrYOeV1oYViNd5ZgPT037QeUHxk4AUrQeG5CP2uwCSFZK9P%2f2WNccjUp3EYnAGS%2bmIN5RNUHUJRdPDWm8UYwL5V2nUOBI1ZFitveGb84CQqwdG6yZhxAoZ4bhPDmGzMDpV8r6ESCYi6it1yz4v7WK4lwkLET2a5IiGet3UsC8x8akShvAIlt2%2fcw2B3ByKo%2boX9suKnMe7x%2bxqpU%2bk6W9eRy240vPO1Xinwqjcet57xk%2bNcQ3Tvq%2bMn52eo98cj%2f1ZhmFN6tc2LkRYYPVELbTRXP2S1HRgcd6VemVMuB1N8wIw1sHXUgGASplAC1%2bjwkMwPBI06Ss6j4kSq6Pp2goVVXhfCuxZftEo9jqdsHCWH0FAsaVA4%3d&game_biz=hkrpg_global";
    
    HttpClient httpClient = HttpClient.newHttpClient();
    Gson gson = new Gson();

    public String populateWarpsFromApi() {
        api_response api_response = new api_response();
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(EXTERNAL_API_URL))
                .GET()
                .build();
            HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            api_response = gson.fromJson(getResponse.body(), api_response.class);
            

        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
        
        return api_response.getMessage();
    }

}
