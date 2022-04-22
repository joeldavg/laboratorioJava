package com.sofkau.domain;

public enum Level {
    ONE("one"),
    TWO("two"),
    THREE("three"),
    FOUR("four"),
    FIVE("five");

    private String level;


    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
