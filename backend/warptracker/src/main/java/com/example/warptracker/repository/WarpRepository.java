package com.example.warptracker.repository;

import com.example.warptracker.models.warp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarpRepository extends JpaRepository<warp, Integer> {
}
