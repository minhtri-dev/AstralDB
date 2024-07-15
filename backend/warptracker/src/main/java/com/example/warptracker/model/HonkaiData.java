package com.example.warptracker.model;

import java.util.List;

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
        private String gacha_id;
        private String gacha_type;
        private String item_id;
        private String count;
        private String time;
        private String name;
        private String lang;
        private String item_type;
        private String rank_type;
        private String id;

        // Getters and Setters

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGachaId() {
            return gacha_id;
        }

        public void setGachaId(String gacha_id) {
            this.gacha_id = gacha_id;
        }

        public String getGachaType() {
            return gacha_type;
        }

        public void setGachaType(String gacha_type) {
            this.gacha_type = gacha_type;
        }

        public String getItemId() {
            return item_id;
        }

        public void setItemId(String item_id) {
            this.item_id = item_id;
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
            return item_type;
        }

        public void setItemType(String item_type) {
            this.item_type = item_type;
        }

        public String getRankType() {
            return rank_type;
        }

        public void setRankType(String rank_type) {
            this.rank_type = rank_type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
