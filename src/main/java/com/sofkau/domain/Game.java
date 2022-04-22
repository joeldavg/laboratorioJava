package com.sofkau.domain;

public class Game {

    private Long id;
    private Integer totalScore;
    private Boolean didWin;
    private Long playerId;
    private Long idCategoryReached;

    public Game(Long id, Integer totalScore, Boolean didWin, Long playerId, Long idCategoryReached) {
        this.id = id;
        this.totalScore = totalScore;
        this.didWin = didWin;
        this.playerId = playerId;
        this.idCategoryReached = idCategoryReached;
    }

    public Game(Integer totalScore, Boolean didWin, Long playerId, Long idCategoryReached) {
        this.totalScore = totalScore;
        this.didWin = didWin;
        this.playerId = playerId;
        this.idCategoryReached = idCategoryReached;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Boolean getDidWin() {
        return didWin;
    }

    public void setDidWin(Boolean didWin) {
        this.didWin = didWin;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getIdCategoryReached() {
        return idCategoryReached;
    }

    public void setIdCategoryReached(Long idCategoryReached) {
        this.idCategoryReached = idCategoryReached;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", totalScore=" + totalScore +
                ", didWin=" + didWin +
                ", playerId=" + playerId +
                ", idCategoryReached=" + idCategoryReached +
                '}';
    }
}
