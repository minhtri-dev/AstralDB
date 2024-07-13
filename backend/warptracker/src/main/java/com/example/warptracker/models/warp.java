package com.example.warptracker.models;

import jakarta.persistence.*;

@Entity
@Table(name = "warp")
public class warp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warpId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @Column(nullable = false)
    private String itemId;

    @Column(nullable = false)
    private String gachaType;

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getGachaType() {
        return gachaType;
    }

    public void setGachaType(String gachaType) {
        this.gachaType = gachaType;
    }
}