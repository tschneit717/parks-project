package com.schneit.parksproject.activities;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivitiesMapper implements RowMapper<ActivitiesModel> {

    @Override
    public ActivitiesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ActivitiesModel activities = new ActivitiesModel();

        activities.setId(rs.getString("id"));
        activities.setName(rs.getString("name"));

        return activities;
    }
}
