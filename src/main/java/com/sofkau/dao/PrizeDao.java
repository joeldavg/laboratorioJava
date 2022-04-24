package com.sofkau.dao;

import com.sofkau.domain.Prize;
import com.sofkau.exception.GenericException;

public interface PrizeDao {
    public Prize getById(Long id) throws GenericException;
}
