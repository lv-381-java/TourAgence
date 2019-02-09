package com.ss.touragency.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDao<SomeEntity> {

    //create
    void create(SomeEntity entity);


    //read
    List<SomeEntity> getAll() throws SQLException;

    SomeEntity getById(int id) throws SQLException;


    // update
    void updateById(SomeEntity entity);

    void updateByName(SomeEntity entity);


    // delete
    void deleteById(Long id);

}
