package com.example.warptracker.model.warptrackerdb;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "item_type", nullable = false)
    private String itemType;

    @Column(name = "rank_type", nullable = false)
    private Integer rankType;

    // Default constructor
    public Item() {
    }

    // Constructor for an item
    public Item(Long itemId, String name, String itemType, Integer rankType) {
        this.itemId = itemId;
        this.name = name;
        this.itemType = itemType;
        this.rankType = rankType;
    }

    // Getters and setters
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getRankType() {
        return rankType;
    }

    public void setRankType(Integer rankType) {
        this.rankType = rankType;
    }
}