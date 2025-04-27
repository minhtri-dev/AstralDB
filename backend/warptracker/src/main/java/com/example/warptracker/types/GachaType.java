package com.example.warptracker.types;

public enum GachaType {
    STANDARD(1),
    BEGINNER(2),
    LIMITED_CHARACTER(11),
    LIMITED_WEAPON(12);

    private final int id;

    GachaType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}