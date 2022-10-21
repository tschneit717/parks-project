package com.schneit.parksproject.parks;

import com.schneit.parksproject.addresses.AddressModel;
import com.schneit.parksproject.addresses.AddressesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ParksRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ParkModel getResult(String id) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM parks p INNER JOIN addresses ON p.id = addresses.park_id WHERE p.id = ");
        if (id != null) {
            query.append(id);
        } else {
            throw new Exception("");
        }

        return jdbcTemplate.queryForObject(query.toString(), new ParksMapper());
    }

}
