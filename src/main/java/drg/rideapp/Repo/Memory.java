package drg.rideapp.Repo;

import drg.rideapp.Actors.Ride;
import drg.rideapp.Actors.RideCount;
import drg.rideapp.Actors.User;
import drg.rideapp.Actors.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Memory {

    List<User> users ;

    List<Vehicle> vehicles;

    List<Ride> rides;

    Map<User, RideCount> count = new HashMap<>();

    public Memory() {
        this.users = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.rides = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public void addRides(Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }

    public Map<User, RideCount> getCount() {
        return count;
    }
}