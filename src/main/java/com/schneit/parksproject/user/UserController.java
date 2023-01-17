package com.schneit.parksproject.user;

import com.schneit.parksproject.exception.DataNotFoundException;
import com.schneit.parksproject.exception.GenericException;
import com.schneit.parksproject.parks.ParkModel;
import com.schneit.parksproject.requests.RegisterRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private  UserRepository userRepository;

    // do database work inside repository class
    // Add validation
    // Add UI for application

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<UserModel> registerUser(@RequestBody RegisterRequestBody body) throws GenericException {
        if (body == null) {
            throw new GenericException("Body cannot be null");
        }
        try {
            return new ResponseEntity<>(userRepository.registerNewUser(body), HttpStatus.OK);
        } catch (EmptyResultDataAccessException error) {
            error.getStackTrace();
            throw new DataNotFoundException("Un-processable request");
        } catch (IllegalArgumentException ex) {
            ex.getStackTrace();
            throw ex;
        } catch (Exception error) {
            error.getStackTrace();
            throw new GenericException("Something went wrong.");
        }
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<UserModel> getUserByIdUsingQueryParam(@RequestParam String id) throws GenericException, DataNotFoundException, IllegalArgumentException {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("User id is required.");
        }
        try {
            return new ResponseEntity<>(userRepository.getUserById(id), HttpStatus.OK);
        } catch (EmptyResultDataAccessException error) {
            error.getStackTrace();
            throw new DataNotFoundException("Un-processable request");
        } catch (IllegalArgumentException ex) {
            ex.getStackTrace();
            throw ex;
        } catch (Exception error) {
            error.getStackTrace();
            throw new GenericException("Something went wrong.");
        }
    }
}

