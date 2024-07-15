package com.example.warptracker.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warptracker.model.primary.Warp;

@Repository
public interface WarpRepository extends JpaRepository<Warp, Integer> {
}
