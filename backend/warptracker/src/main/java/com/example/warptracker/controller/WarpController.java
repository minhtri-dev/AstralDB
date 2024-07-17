package com.example.warptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collection;

import com.example.warptracker.service.WarpService;
import com.example.warptracker.repository.WarpRepository;
import com.example.warptracker.model.warptrackerdb.Warp;

@RestController
@RequestMapping("/v1/api/warp")
public class WarpController {
    @Autowired
    WarpRepository warpRepository;

    @Autowired
    WarpService warpService;

    @PostMapping("/getWarpRecord")
    public ResponseEntity<Collection<Warp>> all(@RequestBody JsonNode jsonNode) {
        String warpUrl = jsonNode.get("warp_url").asText();
        System.out.println(warpUrl);
        Collection<Warp> warps = warpService.getWarpsFromApi(warpUrl);
        
        return ResponseEntity.ok(warps);
    }
}
