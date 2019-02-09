package com.ss.touragency.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICrudDao<SomeEntity> {

    /**
     * Query for insert entity to database
     *
     * @param entity Object from package entity
     */
    //create
    void insert(SomeEntity entity);


    /**
     * Query for select all entities from database
     *
     * @return List of entities
     * @throws SQLException
     */
    //read
    List<SomeEntity> selectAll() throws SQLException;

    /**
     * Search entity by Id from database
     *
     * @param id Id entity in database
     * @return some entity found by Id
     * @throws SQLException
     */
    SomeEntity selectById(Long id) throws SQLException;

    // update
    void updateById(SomeEntity entity, Long id);

    // delete
    void deleteById(Long id);

}
