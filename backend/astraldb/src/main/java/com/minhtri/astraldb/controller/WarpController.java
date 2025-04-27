package com.minhtri.astraldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.UriComponentsBuilder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import com.minhtri.astraldb.service.WarpService;
import com.minhtri.astraldb.repository.WarpRepository;
import com.minhtri.astraldb.model.warptrackerdb.Warp;

@RestController
@RequestMapping("/api/v1/warp_record")
public class WarpController {
    @Autowired
    WarpRepository warpRepository;

    @Autowired
    WarpService warpService;

    private static final String API_URL = "https://public-operation-hkrpg-sg.hoyoverse.com/common/gacha_record/api/getGachaLog";

    @GetMapping("/getWarpLog")
    public ResponseEntity<?> fetchWarps(
        @RequestParam String gacha_type,
        @RequestParam(defaultValue = "0") String endId,
        @RequestParam String authkey_ver,
        @RequestParam String authkey,
        @RequestParam String sign_type
    ) {
        try {
            String encodedAuthKey = UriUtils.encode(authkey, StandardCharsets.UTF_8.name());

            String warpUrl = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("gacha_type", gacha_type)
                .queryParam("end_id", endId)
                .queryParam("authkey_ver", authkey_ver)
                .queryParam("authkey", encodedAuthKey)
                .queryParam("sign_type", sign_type)
                .queryParam("size", "20")
                .queryParam("lang", "en")
                .queryParam("game_biz", "hkrpg_global")
                .build()
                .toUriString();

            Collection<Warp> warps = warpService.getWarpsFromApi(warpUrl);
            return ResponseEntity.ok(warps);

        } catch (Exception e) {
            System.out.println("Error occurred while fetching the warp data: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}