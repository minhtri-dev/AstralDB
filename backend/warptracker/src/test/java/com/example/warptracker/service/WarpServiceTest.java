package com.example.warptracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.example.warptracker.model.API.HonkaiData;
import com.example.warptracker.model.primary.Warp;
import com.example.warptracker.repository.primary.WarpRepository;

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
        warps = warpService.getWarpsFromApi(EXTERNAL_API_URL);

        assertEquals(66, warps.size());
    }

    @Test
    public void testHttpRequest() {
        HonkaiData data = new HonkaiData();
        data = warpService.httpRequest(API_DATA);

        assertEquals("OK", data.getMessage());
    }
}
