package com.schneit.parksproject.challenge;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Random;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {
    @GetMapping
    public ResponseEntity<String> getChallenge() {
//        byte[] array = new byte[7]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));

        String generatedString = RandomStringUtils.randomAlphanumeric(20);
        return new ResponseEntity<>(generatedString, HttpStatus.OK);
    }

    // Next steps:
    // Save string that we send to the user in the session
    // User will do some manipulation and send it back to us on the registration endpoint
    // Make sure we do the same manipulation that we're expecting the user to do and verify they match
    // If successful, register the user
    // If not successful, return a 401

}
