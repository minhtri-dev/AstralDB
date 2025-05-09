package com.minhtri.astraldb.model.warptrackerdb;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "warp")
public class Warp {

    @Id
    @Column(name = "warp_id")
    private String warpId;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id")
    // private User user;

    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "hsr_uid", nullable = false)
    private Long hsr_uid;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

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
    public Warp(String warpId, Long userId, Long hsr_uid, Long itemId, Integer gachaId, String gachaType, Integer pity, Timestamp warpTime) {
        this.warpId = warpId;
        this.userId = userId;
        this.hsr_uid = hsr_uid;
        this.itemId = itemId;
        this.gachaId = gachaId;
        this.gachaType = gachaType;
        this.pity = pity;
        this.warpTime = warpTime;
    }

    // Getters and setters
    public String getWarpId() {
        return warpId;
    }

    public void setWarpId(String warpId) {
        this.warpId = warpId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHsrId() {
        return hsr_uid;
    }

    public void setHsrId(Long hsr_uid) {
        this.hsr_uid = hsr_uid;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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
