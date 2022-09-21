package com.schneit.parksproject.parks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ParksRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ParkModel getResult(String id) {
        ParkModel park = new ParkModel();
        // TODO: Update sql query to reference address table as well as parks
        // TODO: Create address model
        // TODO: add as a property to parks
        StringBuilder query = new StringBuilder("SELECT * FROM parks WHERE");
        if (id != null) {
            query.append(" id = " + id);
        }

        ParkModel result = jdbcTemplate.queryForObject(query.toString(), new ParksMapper());

        // TODO: Join on the address here to the park model
        return result;
    }

}
