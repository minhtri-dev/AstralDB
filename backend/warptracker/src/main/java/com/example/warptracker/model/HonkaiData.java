package com.example.warptracker.model;

import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class HonkaiData {
    private int retcode;
    private String message;
    private Data data;

    // Getters and Setters

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private String page;
        private String size;
        private List<Item> list;
        private String region;
        private int regionTimeZone;

        // Getters and Setters

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public List<Item> getList() {
            return list;
        }

        public void setList(List<Item> list) {
            this.list = list;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public int getRegionTimeZone() {
            return regionTimeZone;
        }

        public void setRegionTimeZone(int regionTimeZone) {
            this.regionTimeZone = regionTimeZone;
        }
    }

    public static class Item {
        private String uid;
        private String gachaId;
        private String gachaType;
        private String itemId;
        private String count;
        private String time;
        private String name;
        private String lang;
        private String itemType;
        private String rankType;
        private String id;

        // Getters and Setters

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGachaId() {
            return gachaId;
        }

        public void setGachaId(String gachaId) {
            this.gachaId = gachaId;
        }

        public String getGachaType() {
            return gachaType;
        }

        public void setGachaType(String gachaType) {
            this.gachaType = gachaType;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getRankType() {
            return rankType;
        }

        public void setRankType(String rankType) {
            this.rankType = rankType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
