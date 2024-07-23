package com.example.warptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.warptracker.repository.BannerRepository;
import com.example.warptracker.model.warptrackerdb.Banner;

@RestController
@RequestMapping("/api/v1/banners")
public class BannerController {

    @Autowired
    BannerRepository bannerRepository;
    
    @GetMapping
    public List<Banner> getAllBanners() {
        return bannerRepository.findAll();
    }
}
