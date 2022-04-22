package com.sofkau.dao;

import com.sofkau.domain.Category;
import com.sofkau.domain.Level;
import com.sofkau.exception.GenericException;

public interface CategoryDao {
    public Category getByLevel(Level level) throws GenericException;

}
