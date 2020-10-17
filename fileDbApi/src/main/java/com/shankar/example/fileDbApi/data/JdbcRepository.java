package com.shankar.example.fileDbApi.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    /*@Autowired
    public DynamicRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    @Autowired
    public JdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser(int id, String firstName, String lastName, String uri) {
        jdbcTemplate.update("INSERT INTO USER (id, first_name, last_name, uri) " +
                "VALUES ("+ id + ", '" + firstName + "', '" + lastName  + "', '"  + uri +"')");
    }
}
