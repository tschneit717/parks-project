package com.schneit.parksproject.user;

import com.schneit.parksproject.exception.GenericException;
import com.schneit.parksproject.requests.RegisterRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Move insert statement into a user repository
    // leave if body is null
    // leave catch
    // do database work inside repository class
    // Add validation
    // Add UI for application

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody RegisterRequestBody body) throws GenericException {
        StringBuilder query = new StringBuilder("INSERT INTO users (name, password, username) VALUES (?, ?, ?)");
        if (body == null) {
            throw new GenericException("Body cannot be null");
        }
        try {
            jdbcTemplate.update(query.toString(), body.getUsername(), body.getPassword(), body.getUsername());
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception error) {
            throw new GenericException("Oops something went wrong");
        }
    }
}
