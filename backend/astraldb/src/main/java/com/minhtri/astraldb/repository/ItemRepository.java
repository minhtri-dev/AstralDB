package com.minhtri.astraldb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhtri.astraldb.model.warptrackerdb.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
