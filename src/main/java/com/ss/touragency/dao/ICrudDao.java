package com.ss.touragency.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDao<SomeEntity> {

    //create
    void insert(SomeEntity entity);


    //read
    List<SomeEntity> selectAll() throws SQLException;

    SomeEntity selectById(int id) throws SQLException;

    // update
    void updateById(SomeEntity entity, Long id);

    // delete
    void deleteById(Long id);

}
