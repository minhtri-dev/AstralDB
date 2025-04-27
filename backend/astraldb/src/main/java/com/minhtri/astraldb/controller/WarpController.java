package com.minhtri.astraldb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collection;

import com.minhtri.astraldb.service.WarpService;
import com.minhtri.astraldb.repository.WarpRepository;
import com.minhtri.astraldb.model.warptrackerdb.Warp;

@RestController
@RequestMapping("/api/v1/warps")
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
