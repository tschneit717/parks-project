package com.schneit.parksproject.parks;


import com.schneit.parksproject.addresses.AddressModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ParksMapper implements RowMapper<ParkModel> {


    @Override
    public ParkModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ParkModel park = new ParkModel();


        park.setParkName(rs.getString("park_name"));
        park.setParkDescription(rs.getString("park_description"));
        park.setDesignation(rs.getString("designation"));
        park.setDirectionsInfo(rs.getString("directions_info"));
        park.setDirectionUrl(rs.getString("directions_url"));
        park.setFullName(rs.getString("full_name"));
        park.setParkUrl(rs.getString("park_url"));
        park.setWeatherInfo(rs.getString("weather_info"));
        park.setLatitude(rs.getDouble("latitude"));
        park.setLongitude(rs.getDouble("longitude"));

        AddressModel addressModel = new AddressModel();
        addressModel.setLine_1(rs.getString("line_1"));
        addressModel.setLine_2(rs.getString("line_2"));
        addressModel.setLine_3(rs.getString("line_3"));
        addressModel.setCity(rs.getString("city"));
        addressModel.setState_code(rs.getString("state_code"));
        addressModel.setPostal_code(rs.getString("postal_code"));

        park.setPhysicalAddress(addressModel);



        return park;
    }
}
