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

    public ParkModel getResult(String id) {
        ParkModel park = new ParkModel();
        // TODO: Update sql query to reference address table as well as parks
        // TODO: Create address model
        // TODO: add as a property to parks
        StringBuilder query = new StringBuilder("SELECT * FROM parks p INNER JOIN addresses ON p.id = addresses.park_id WHERE p.id = ").append(id);
//        if (id != null) {
//            query.append(" id = ").append(id);
//        }

        ParkModel result = jdbcTemplate.queryForObject(query.toString(), new ParksMapper());

//        StringBuilder addressQuery = new StringBuilder("SELECT * FROM addresses WHERE park_id = ");
//        if (id != null) {
//            addressQuery.append(id).append(" AND address_type_id = 1");
//        }
//        AddressModel addressResult = jdbcTemplate.queryForObject(addressQuery.toString(), new AddressesMapper());

//        System.out.println(addressResult);
        // TODO: Join on the address here to the park model
        return result;
    }

}
