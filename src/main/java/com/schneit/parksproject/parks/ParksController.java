package com.schneit.parksproject.parks;

import com.schneit.parksproject.exception.DataNotFoundException;
import com.schneit.parksproject.exception.GenericException;
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
    public ResponseEntity<ParkModel> getParkByIdUsingQueryParam(@RequestParam String id) throws GenericException, DataNotFoundException, IllegalArgumentException {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Park id is required.");
        }
        try {
            return new ResponseEntity<>(parksRepository.getResult(id), HttpStatus.OK);
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
