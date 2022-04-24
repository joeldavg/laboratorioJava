package com.sofkau.dao;

import com.sofkau.domain.Game;
import com.sofkau.exception.GenericException;

import java.util.List;

public interface GameDao {
    public List<Game> getByPlayerId(Long playerId) throws GenericException;
    public Game save(Game game) throws GenericException;
}
