package drg.rideapp.Actors;

import java.util.Date;

public class Ride {
    private User user;
    private Vehicle vehicle;
    private String origin;
    private Integer seatsAvailable;
    private String destination;
    private Date startTime;
    private Integer rideDuration;

    public Ride(User user, Vehicle vehicle, String origin, Integer seatsAvailable, String destination, Date startTime, Integer rideDuration) {
        this.user = user;
        this.vehicle = vehicle;
        this.origin = origin;
        this.seatsAvailable = seatsAvailable;
        this.destination = destination;
        this.startTime = startTime;
        this.rideDuration = rideDuration;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getOrigin() {
        return origin;
    }

    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }

    public String getDestination() {
        return destination;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Integer getRideDuration() {
        return rideDuration;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "user=" + user +
                ", vehicle=" + vehicle +
                ", origin='" + origin + '\'' +
                ", seatsAvailable=" + seatsAvailable +
                ", destination='" + destination + '\'' +
                ", startTime=" + startTime +
                ", rideDuration=" + rideDuration +
                '}';
    }

}