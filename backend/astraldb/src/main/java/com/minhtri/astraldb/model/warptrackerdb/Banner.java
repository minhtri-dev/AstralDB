package com.minhtri.astraldb.model.warptrackerdb;

// import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "banner")
public class Banner {
    
    @Id
    @Column(name = "gacha_id")
    private Long gachaId;

    @Column(name = "banner_name")
    private String bannerName;

    @Column(name = "user_count")
    private Integer userCount;

    @Column(name = "warp_count")
    private Integer warpCount;

    @Column(name = "jade_spent")
    private Integer jadeSpend;

    @Column(name = "avg_5_pity")
    private Integer avgFivePity;

    @Column(name = "avg_4_pity")
    private Integer avgFourPity;

    @Column(name = "rate_5050")
    private Float rate5050;

    @Column(name = "image_url")
    private String imgUrl;

    // @OneToMany(mappedBy = "gachaId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Set<Warp> warps;

    // Getters and Setters

    public Long getGachaId() {
        return gachaId;
    }

    public void setGachaId(Long gachaId) {
        this.gachaId = gachaId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getWarpCount() {
        return warpCount;
    }

    public void setWarpCount(Integer warpCount) {
        this.warpCount = warpCount;
    }

    public Integer getJadeSpend() {
        return jadeSpend;
    }

    public void setJadeSpend(Integer jadeSpend) {
        this.jadeSpend = jadeSpend;
    }

    public Integer getAvgFivePity() {
        return avgFivePity;
    }

    public void setAvgFivePity(Integer avgFivePity) {
        this.avgFivePity = avgFivePity;
    }

    public Integer getAvgFourPity() {
        return avgFourPity;
    }

    public void setAvgFourPity(Integer avgFourPity) {
        this.avgFourPity = avgFourPity;
    }

    public Float getRate5050() {
        return rate5050;
    }

    public void setRate5050(Float rate5050) {
        this.rate5050 = rate5050;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    // public Set<Warp> getWarps() {
    //     return warps;
    // }

    // public void setWarps(Set<Warp> warps) {
    //     this.warps = warps;
    // }
}
