package com.schneit.parksproject.parks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ParksRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public String getResult() {
        String sql = "SELECT full_name FROM parks WHERE id = 1";

        String result = jdbcTemplate.queryForObject(sql, String.class);

        return result;
    }

}
