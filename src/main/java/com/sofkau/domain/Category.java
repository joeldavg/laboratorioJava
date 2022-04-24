package com.sofkau.domain;

public class Category {
    private Long id;
    private Level level;
    private Long scoreId;

    public Category(Long id, Level level, Long scoreId) {
        this.id = id;
        this.level = level;
        this.scoreId = scoreId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", level=" + level +
                ", scoreId=" + scoreId +
                '}';
    }
}
