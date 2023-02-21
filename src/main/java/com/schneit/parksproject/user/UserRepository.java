package com.schneit.parksproject.user;

import com.schneit.parksproject.exception.GenericException;
import com.schneit.parksproject.requests.RegisterRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserModel registerNewUser(UserModel user) throws GenericException {
        StringBuilder query = new StringBuilder("INSERT INTO users (name, password, username) VALUES (?, ?, ?)");
        try {
            jdbcTemplate.update(query.toString(), user.getUserName(), user.getPassword(), user.getUserName());
            user.setUserName(user.getUserName());
            return user;
        } catch (Exception error) {
            throw new GenericException("Oops something went wrong");
        }
    }

    public UserModel getUserById(@RequestBody String id) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM users WHERE id = ");
        if (id != null) {
            query.append(id);
        } else {
            throw new Exception("Missing id");
        }
        return  jdbcTemplate.queryForObject(query.toString(), new UserMapper());
    }

    public UserModel getUserByUserName(@RequestBody String userName) throws Exception {
        StringBuilder query = new StringBuilder("SELECT * FROM users WHERE userName = (?)");
        if (userName == null) {
            throw new Exception("Missing userName");
        }
        return jdbcTemplate.queryForObject(query.toString(), new UserMapper(), userName);
    }
}
