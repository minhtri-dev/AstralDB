package com.minhtri.astraldb.service;

// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Component;

import com.minhtri.astraldb.repository.WarpRepository;

@Component
public class WarpServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private WarpRepository warpRepository;

    @InjectMocks
    private WarpService warpService;

    @Value("#{environment.API_URL}")
    private String api_url;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    // @Test
    // public void testGetWarpsFromApi() {
    //     List<Warp> warps = new ArrayList<>();
    //     warps = warpService.getWarpsFromApi(EXTERNAL_API_URL);

    //     assertEquals(66, warps.size());
    // }

    // @Test
    // public void testHttpRequest() {
    //     HonkaiData data = new HonkaiData();
    //     data = warpService.httpRequest(api_url);

    //     assertEquals("OK", api_url);
    // }
}
