package com.example.warptracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.warptracker.model.HonkaiData;
import com.example.warptracker.model.HonkaiData.Item;
import com.example.warptracker.model.User;
import com.example.warptracker.model.Warp;
import com.example.warptracker.repository.WarpRepository;

public class WarpServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WarpRepository warpRepository;

    @InjectMocks
    private WarpService warpService;

    private String EXTERNAL_API_URL = "https://api-os-takumi.mihoyo.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&lang=en&authkey=DY4Wjzr3d3JZIwY4KRGrHuf6Rb4uVh%2fSl4GkyfEWr1WzhXJ0hp3vE9thKW7%2fIEx3ay1zF96GRBoZ7pZJpqY%2fhNjIVJynFxIPRKbtFGRq6cQ71A%2fb6wibxvFzG%2f9atESDAA%2fPPR2T7KLyZAOWefemnj%2bUJ9btzC7KheHaF3TaOyUaR9wvWgz1eaPvYfxRQJLJPsLZfac%2fx569FYnzzN2gRFGwQTIXlMpCFASVs5FeRM74Tcmmgv6ylxEBcE%2f4q%2b5obI%2fJw9giZp5GtohlBpBMh0WXGddRXgCr0eomRjHf4KOzOpBCitGruVbYjrYOeV1oYViNd5ZgPT037QeUHxk4AW5NSI6sz88j7fqAUNvQuyr5PGn98TSWd8IBjBIhDm4c0sWNUDm3G%2fCBLyBh8RWQaJTsmHLyPPT3hc1iKk3PMOYntpxjq2xzuQhR9YUURy0ro3HpHMCC4Y17vyjGoY9njqFz8RUdPFPQ6AB1dETWoCm79D7k5fjFNLIRZTCGZ5iZxmV1CJOhmdsKu%2fkeQdSqJ1N86HSq%2bsjHg1E%2f040oKH5y6YixvGSwWaoMy8XLHqT5c8wn%2fRb0hnU1mmTtE6Jg%2bAeIboxMy7LzABNmUIIL9dHkSHhEHhGO8dZgk7r%2bWoxEFgWDDBkvz7QpJPQwnLJbX35a3vBtNkAAZaMNoy4TaxQ%3d&game_biz=hkrpg_global";
    private String API_DATA = "https://api-os-takumi.mihoyo.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&lang=en&authkey=DY4Wjzr3d3JZIwY4KRGrHuf6Rb4uVh%2fSl4GkyfEWr1WzhXJ0hp3vE9thKW7%2fIEx3ay1zF96GRBoZ7pZJpqY%2fhNjIVJynFxIPRKbtFGRq6cQ71A%2fb6wibxvFzG%2f9atESDAA%2fPPR2T7KLyZAOWefemnj%2bUJ9btzC7KheHaF3TaOyUaR9wvWgz1eaPvYfxRQJLJPsLZfac%2fx569FYnzzN2gRFGwQTIXlMpCFASVs5FeRM74Tcmmgv6ylxEBcE%2f4q%2b5obI%2fJw9giZp5GtohlBpBMh0WXGddRXgCr0eomRjHf4KOzOpBCitGruVbYjrYOeV1oYViNd5ZgPT037QeUHxk4AW5NSI6sz88j7fqAUNvQuyr5PGn98TSWd8IBjBIhDm4c0sWNUDm3G%2fCBLyBh8RWQaJTsmHLyPPT3hc1iKk3PMOYntpxjq2xzuQhR9YUURy0ro3HpHMCC4Y17vyjGoY9njqFz8RUdPFPQ6AB1dETWoCm79D7k5fjFNLIRZTCGZ5iZxmV1CJOhmdsKu%2fkeQdSqJ1N86HSq%2bsjHg1E%2f040oKH5y6YixvGSwWaoMy8XLHqT5c8wn%2fRb0hnU1mmTtE6Jg%2bAeIboxMy7LzABNmUIIL9dHkSHhEHhGO8dZgk7r%2bWoxEFgWDDBkvz7QpJPQwnLJbX35a3vBtNkAAZaMNoy4TaxQ%3d&game_biz=hkrpg_global&gacha_type=12&end_id=0&size=20";


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetWarpsFromApi() {
        List<Warp> warps = new ArrayList<>();
        Integer count = 0;
        String url = "";
        warps = warpService.getWarpsFromApi(API_DATA);

        assertEquals("", warps);

    }

    @Test
    public void testHttpRequest() {
        HonkaiData data = new HonkaiData();
        data = warpService.httpRequest(API_DATA);
        List<Item> items = data.getData().getList();

        List<Warp> warps = new ArrayList<>();

        try {
            for (Item item : items) {
                // Use UID to find user in DB, if user isnt in database use the uid from the api
                User user = new User(Long.valueOf(item.getUid()));
                warps.add(new Warp(
                    Long.parseLong((item.getId())),
                    user, 
                    Integer.parseInt(item.getItemId()), 
                    Integer.parseInt(item.getGachaId()),
                    item.getGachaType(),
                    null,
                    Timestamp.valueOf(item.getTime())
                ));
            }
        } catch (Exception e) {

        }
        

        assertEquals("", warps);
    }

    @Test
    public void testURIbuilder() {
        String url = "";
        try {
            url = warpService.changeQueryParam(EXTERNAL_API_URL, "gacha_type", "11");
            url = warpService.changeQueryParam(EXTERNAL_API_URL, "gacha_type", "12");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        
        assertEquals("", url);
    }

    @Test
    public void testList() {
        // HonkaiData honkaiData = new HonkaiData();
        // List<Warp> warps = new ArrayList<>();
        // String end_id = "0";
        // List<Item> items = new ArrayList<>();
        // String url = "";

        // Integer count = 0;

        // try {
        //     Map<String, String> params = Map.of(
        //     "gacha_type", "1",
        //     "end_id", "0",
        //     "size", "19"
        //     );

        //     for (Map.Entry<String, String> entry : params.entrySet()) {
        //         uriBuilder.addParameter(entry.getKey(), entry.getValue());
        //     }
        //     URI uri = uriBuilder.build();
        //     url = uri.toString();
        //     items = warpService.httpRequest(API_DATA).getData().getList();

        //     while (!items.isEmpty()) {
        //         count++;
        //         for (Item item : items) {
        //             // Use UID to find user in DB, if user isnt in database use the uid from the api
        //             User user = new User(Integer.parseInt(item.getUid()));
        //             warps.add(new Warp(
        //                 Integer.parseInt(item.getId()),
        //                 user, 
        //                 Integer.parseInt(item.getItemId()), 
        //                 Integer.parseInt(item.getGachaId()),
        //                 item.getGachaType(),
        //                 0,
        //                 Timestamp.valueOf(item.getTime())
        //             ));
        //             end_id = item.getItemId();
        //         }
        //         uriBuilder.setParameter("end_id", end_id);
        //         url = uriBuilder.build().toString();
        //         honkaiData = warpService.httpRequest(url); 
        //         items = honkaiData.getData().getList();
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace(); 
        // }

        // assertEquals("", url);
    }
}
