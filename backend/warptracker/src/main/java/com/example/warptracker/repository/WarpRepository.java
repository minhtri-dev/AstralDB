package com.example.warptracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warptracker.model.warptrackerdb.Warp;

@Repository
public interface WarpRepository extends JpaRepository<Warp, Long> {
}
