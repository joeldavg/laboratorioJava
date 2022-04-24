package com.sofkau.dao;

import com.sofkau.domain.Question;
import com.sofkau.exception.GenericException;

import java.util.List;

public interface QuestionDao {
    public List<Question> getByCategory(Long categoryId) throws GenericException;
}
