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

    @Column(name = "image_url")
    private String imgUrl;

    @Column(name = "item_id")
    private Integer itemId;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    // public Set<Warp> getWarps() {
    //     return warps;
    // }

    // public void setWarps(Set<Warp> warps) {
    //     this.warps = warps;
    // }
}
