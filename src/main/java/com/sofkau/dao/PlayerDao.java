package com.sofkau.dao;

import com.sofkau.domain.Player;
import com.sofkau.exception.GenericException;

public interface PlayerDao {

    public Player getByEmail(String email) throws GenericException;

    public Player save(Player player) throws GenericException;

    public Boolean emailExist(String email) throws GenericException;

}
