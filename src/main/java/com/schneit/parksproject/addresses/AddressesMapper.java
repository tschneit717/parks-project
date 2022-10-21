package com.schneit.parksproject.addresses;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressesMapper implements RowMapper<AddressModel> {

    @Override
    public AddressModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        AddressModel address = new AddressModel();

        address.setLine_1(rs.getString("line_1"));
        address.setLine_2(rs.getString("line_2"));
        address.setLine_3(rs.getString("line_3"));
        address.setCity(rs.getString("city"));
        address.setState_code(rs.getString("state_code"));
        address.setPostal_code(rs.getString("postal_code"));

        return address;
    }
}
