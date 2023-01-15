package com.schneit.parksproject.user;


import com.schneit.parksproject.addresses.AddressModel;
import com.schneit.parksproject.user.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {


    @Override
    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserModel user = new UserModel();

        user.setUserName(rs.getString("username"));
        user.setName(rs.getString("name"));

        return user;
    }
}
