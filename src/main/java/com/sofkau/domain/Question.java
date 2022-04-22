package com.sofkau.domain;

public class Category {

    private Long id;
    private Level nivel;
    private Long scoreId;

    public Category(Long id, Level nivel, Long scoreId) {
        this.id = id;
        this.nivel = nivel;
        this.scoreId = scoreId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getNivel() {
        return nivel;
    }

    public void setNivel(Level nivel) {
        this.nivel = nivel;
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
                ", nivel=" + nivel +
                ", scoreId=" + scoreId +
                '}';
    }
}