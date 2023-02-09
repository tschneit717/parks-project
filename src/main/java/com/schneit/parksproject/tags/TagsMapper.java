package com.schneit.parksproject.tags;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagsMapper implements RowMapper<TagsModel> {

    @Override
    public TagsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        TagsModel tags = new TagsModel();

        tags.setId(rs.getString("id"));
        tags.setName(rs.getString("name"));

        return tags;
    }
}
