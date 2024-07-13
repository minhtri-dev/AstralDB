package com.example.warptracker.repository;

import com.example.warptracker.models.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<item, Integer> {
}
