package com.schneit.parksproject;

import com.schneit.parksproject.exception.GenericException;
import com.schneit.parksproject.requests.GetDirectionsRequest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DirectionsController {
    @PostMapping("/directions")

    // Create an endpoint to get directions
    // Take user input and create a query
    public ResponseEntity<Object> getDirections(@RequestBody GetDirectionsRequest body) throws GenericException {
        if (body.getStartingWaypoint() == null || body.getEndingWaypoint() == null) {
            throw new IllegalArgumentException("Invalid waypoints provided.");
        }

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.build();


        try {
            Object object = restTemplate.getForObject("http://dev.virtualearth.net/REST/V1/Routes/Driving" + "?o=json" + "&wp.0=jackson,wy" + "&wp.1=yellowstone" + "&avoid=minimizeTolls" + "&key=Ao3q4A3Buf6tjtYAgD2qVl2ABzox2l60f6OMy7NcTKqjzbtolWmgDlbFFIxZJ3Uy" , Object.class);
            return new ResponseEntity<>(object, HttpStatus.OK);
        }
        catch (Exception error) {
            error.printStackTrace();
            throw new GenericException("oops?");
        }
    }
    // Return itinerary steps
    // TODO: Allow for chaining queries to show directions to multiple locations
    // Ideas:
    // Save history into database
    // Find most convenient route between queries
    //
}
