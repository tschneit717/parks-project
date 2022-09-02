package com.schneit.parksproject.parks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ParksRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getResult(String id) {
        StringBuilder query = new StringBuilder("SELECT full_name FROM parks WHERE");
        if (id != null) {
            query.append(" id = " + id);
        }

        // TODO: Return an actual object - Tom
        String result = jdbcTemplate.queryForObject(query.toString(), String.class);

        return result;
    }

}
