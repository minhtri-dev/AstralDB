package com.example.warptracker.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "warp")
public class Warp {

    @Id
    @Column(name = "warp_id")
    private Integer warpId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "gacha_id", nullable = false)
    private Integer gachaId;

    @Column(name = "gacha_type", nullable = false)
    private String gachaType;

    @Column(name = "pity")
    private Integer pity;

    @Column(name = "warp_time", nullable = false)
    private Timestamp warpTime;

    // Default constructor
    public Warp() {
    }

    // Parameterised constructor
    public Warp(Integer warpId, User user, Integer itemId, Integer gachaId, String gachaType, Integer pity, Timestamp warpTime) {
        this.warpId = warpId;
        this.user = user;
        this.itemId = itemId;
        this.gachaId = gachaId;
        this.gachaType = gachaType;
        this.pity = pity;
        this.warpTime = warpTime;
    }

    // Getters and setters
    public Integer getWarpId() {
        return warpId;
    }

    public void setWarpId(Integer warpId) {
        this.warpId = warpId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getGachaId() {
        return gachaId;
    }

    public void setGachaId(Integer gachaId) {
        this.gachaId = gachaId;
    }

    public String getGachaType() {
        return gachaType;
    }

    public void setGachaType(String gachaType) {
        this.gachaType = gachaType;
    }

    public Integer getPity() {
        return pity;
    }

    public void setPity(Integer pity) {
        this.pity = pity;
    }

    public Timestamp getWarpTime() {
        return warpTime;
    }

    public void setWarpTime(String warpTime) {
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(warpTime);

        this.warpTime = timestamp; 
    }
}
