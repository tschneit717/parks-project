package com.schneit.parksproject.parks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parks")
public class ParksController {
    @Autowired
    private ParksRepository parksRepository;

    @GetMapping("/hello")
    public ResponseEntity<String> getParkByIdUsingQueryParam(@RequestParam String id) {
        try {
            return new ResponseEntity<>(parksRepository.getResult(id), HttpStatus.OK);
        } catch (BadSqlGrammarException error) {
            error.getStackTrace();
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EmptyResultDataAccessException error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            error.getStackTrace();
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

    }
}
