package com.schneit.parksproject.parks;


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
        park.setLatidute(rs.getDouble("latitude"));
        park.setLongitude(rs.getDouble("longitude"));



        return park;
    }
}
