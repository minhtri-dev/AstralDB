package com.example.warptracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.warptracker.model.item;

@Repository
public interface ItemRepository extends JpaRepository<item, Integer> {
}
