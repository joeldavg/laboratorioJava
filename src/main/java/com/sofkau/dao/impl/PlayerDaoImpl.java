package com.sofkau.dao.impl;

import com.sofkau.dao.PlayerDao;
import com.sofkau.dao.jdbc.ConnectionDB;
import com.sofkau.domain.Player;
import com.sofkau.exception.GenericException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlayerDaoImpl implements PlayerDao {

    @Override
    public Player getByEmail(String email) throws GenericException {
        Player player = null;

        String sql = "SELECT * FROM jugadores WHERE email = '" + email + "'";

        try (Connection connection = ConnectionDB.getConnection()) {

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        String name = rs.getString(2);
                        String surname = rs.getString(3);
                        player = new Player(id, name, surname, email);
                    }
                }
            }

        } catch (Exception e) {
            throw new GenericException("No se pudo consultar: " + sql, e);
        }

        return player;
    }

    @Override
    public Player save(Player player) throws GenericException {
        String sql = "INSERT INTO jugadores(nombre, apellido, email)  VALUES(?, ?, ?);";

        try (Connection connection = ConnectionDB.getConnection()) {

            try (PreparedStatement pst = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                pst.setString(1, player.getName());
                pst.setString(2, player.getLastname());
                pst.setString(3, player.getEmail());

                pst.execute();

                try (ResultSet rs = pst.getGeneratedKeys()) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        player.setId(id);
                    }
                }
            }

        } catch (Exception e) {
            throw new GenericException("Couldn't query: " + sql, e);
        }

        return player;
    }

    @Override
    public Boolean emailExist(String email) throws GenericException {
        boolean exist = false;
        if (getByEmail(email) != null) {
            exist = true;
        }
        return exist;
    }
}
