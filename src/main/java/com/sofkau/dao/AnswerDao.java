package com.sofkau.dao;

import com.sofkau.domain.Answer;
import com.sofkau.exception.GenericException;

import java.util.List;

public interface AnswerDao {
    public List<Answer> getByQuestionId(Long preguntaId) throws GenericException;
}
