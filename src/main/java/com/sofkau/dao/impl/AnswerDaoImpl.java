package com.sofkau.dao.impl;

import com.sofkau.dao.AnswerDao;
import com.sofkau.dao.jdbc.ConnectionDB;
import com.sofkau.domain.Answer;
import com.sofkau.exception.GenericException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao {
    @Override
    public List<Answer> getByQuestionId(Long preguntaId) throws GenericException {

        List<Answer> respuestas = new ArrayList<>();

        String sql = "SELECT * FROM respuestas WHERE preguntas_id = " + preguntaId;

        try (Connection connection = ConnectionDB.getConnection()) {

            try (Statement st = connection.createStatement()) {

                try (ResultSet rs = st.executeQuery(sql)) {

                    while (rs.next()) {
                        Long id = rs.getLong(1);
                        String answer = rs.getString(2);
                        Boolean correct = rs.getBoolean(3);
                        respuestas.add(new Answer(id, answer, correct, preguntaId));
                    }
                }
            }

        } catch (Exception e) {
            throw new GenericException("Couldn't query: " + sql, e);
        }

        return respuestas;
    }
}
