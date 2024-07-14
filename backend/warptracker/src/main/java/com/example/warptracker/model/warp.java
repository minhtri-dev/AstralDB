package com.example.warptracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warp")
public class warp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warp_id")
    private Integer warpId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "gacha_id", nullable = false)
    private Integer gachaId;

    @Column(name = "gacha_type", nullable = false)
    private String gachaType;

    @Column(name = "pity")
    private Integer pity;

    @Column(name = "warp_time", nullable = false)
    private LocalDateTime warpTime;

    // Getters and setters
    public Integer getWarpId() {
        return warpId;
    }

    public void setWarpId(Integer warpId) {
        this.warpId = warpId;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
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

    public LocalDateTime getWarpTime() {
        return warpTime;
    }

    public void setWarpTime(LocalDateTime warpTime) {
        this.warpTime = warpTime;
    }
}
