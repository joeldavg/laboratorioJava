package com.sofkau.dao.impl;

import com.sofkau.dao.CategoryDao;
import com.sofkau.dao.jdbc.ConnectionDB;
import com.sofkau.domain.Category;
import com.sofkau.domain.Level;
import com.sofkau.exception.GenericException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CategoryDaoImpl  implements CategoryDao {

    @Override
    public Category getByLevel(Level level) throws GenericException {
        Category category = null;

        String sql = "SELECT * FROM categorias WHERE nivel = '" + level.toString() + "'";

        try (Connection connection = ConnectionDB.getConnection()) {

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        Long puntosId = rs.getLong(3);
                        category = new Category(id, level, puntosId);
                    }
                }
            }

        } catch (Exception e) {
            throw new GenericException("Couldn't query: " + sql, e);
        }

        return category;
    }
}
