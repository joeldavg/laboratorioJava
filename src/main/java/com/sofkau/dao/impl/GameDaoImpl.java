package com.sofkau.dao.impl;

import com.sofkau.dao.GameDao;
import com.sofkau.dao.jdbc.ConnectionDB;
import com.sofkau.domain.Game;
import com.sofkau.exception.GenericException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {

    @Override
    public List<Game> getByPlayerId(Long playerId) throws GenericException {
        List<Game> games = new ArrayList<>();
        String sql = "SELECT * FROM partidas WHERE jugadores_id = " + playerId;
        try (Connection connection = ConnectionDB.getConnection()) {

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        Integer totalPoint = rs.getInt(2);
                        Boolean won = rs.getBoolean(3);
                        Long categoryIdReached = rs.getLong(5);
                        games.add(new Game(id, totalPoint, won, playerId, categoryIdReached));
                    }
                }
            }
        } catch (Exception e) {
            throw new GenericException("Couldn't query: " + sql, e);
        }
        return games;
    }

    @Override
    public Game save(Game game) throws GenericException {
        String sql = "INSERT INTO partidas(puntos_totales, ganada, jugadores_id, categoria_id_alcanzada)"
                + " VALUES(?, ?, ?, ?);";
        try (Connection connection = ConnectionDB.getConnection()) {

            try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                pst.setInt(1, game.getTotalScore());
                pst.setBoolean(2, game.getDidWin());
                pst.setLong(3, game.getPlayerId());
                pst.setLong(4, game.getIdCategoryReached());

                pst.execute();

                try (ResultSet rs = pst.getGeneratedKeys()) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        game.setId(id);
                    }
                }
            }
        } catch (Exception e) {
            throw new GenericException("Couldn't query: " + sql, e);
        }

        return game;
    }
}
