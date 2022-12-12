package com.schneit.parksproject.user;

import com.schneit.parksproject.exception.GenericException;
import com.schneit.parksproject.requests.RegisterRequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody RegisterRequestBody body) throws GenericException {
        try {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception error) {
            throw new GenericException("Oops something went wrong");
        }
    }
}
