package com.schneit.parksproject.requests;

public class GetDirectionsRequest {
    private String startingWaypoint;

    public String getStartingWaypoint() {
        return startingWaypoint;
    }

    public void setStartingWaypoint(String startingWaypoint) {
        this.startingWaypoint = startingWaypoint;
    }

    public String getEndingWaypoint() {
        return endingWaypoint;
    }

    public void setEndingWaypoint(String endingWaypoint) {
        this.endingWaypoint = endingWaypoint;
    }

    private String endingWaypoint;
}
