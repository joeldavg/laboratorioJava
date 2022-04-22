package com.sofkau.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sofkau.dao.QuestionDao;
import com.sofkau.dao.jdbc.ConectionDB;
import com.sofkau.domain.Question;
import com.sofkau.exception.GenericException;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public List<Question> getByCategory(Long categoryId) throws GenericException {

        List<Question> questions = new ArrayList<>();

        String sql = "SELECT * FROM preguntas WHERE categorias_id = " + categoryId;

        try (Connection connection = ConectionDB.obtenerConexion()) {

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        String pregunta = rs.getString(2);
                        questions.add(new Question(id, pregunta, categoryId));
                    }
                }
            }

        } catch (Exception e) {
            throw new GenericException("No consultation was possible: " + sql, e);
        }

        return questions;
    }

}
