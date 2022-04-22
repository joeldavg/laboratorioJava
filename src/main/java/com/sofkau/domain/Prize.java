package com.sofkau.domain;

public class Prize {
    private Long id;
    private Integer points;

    public Prize(Long id, Integer points) {
        this.id = id;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer puntos) {
        this.points = puntos;
    }

    @Override
    public String toString() {
        return "Premio [id=" + id + ", pointss=" + points + "]";
    }
}
