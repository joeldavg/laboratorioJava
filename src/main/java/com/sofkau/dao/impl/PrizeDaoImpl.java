package com.sofkau.dao.impl;

import com.sofkau.dao.PrizeDao;
import com.sofkau.dao.jdbc.ConnectionDB;
import com.sofkau.domain.Prize;
import com.sofkau.exception.GenericException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrizeDaoImpl implements PrizeDao {
    @Override
    public Prize getById(Long id) throws GenericException {

        Prize prize = null;

        String sql = "SELECT * FROM premios WHERE id = " + id;

        try (Connection connection = ConnectionDB.getConnection()) {

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        Integer points = rs.getInt(2);
                        prize = new Prize(id, points);
                    }
                }
            }

        } catch (Exception e) {
            throw new GenericException("No se pudo consultar: " + sql, e);
        }

        return prize;
    }
}
