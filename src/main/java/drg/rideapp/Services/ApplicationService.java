package drg.rideapp.Services;

import drg.rideapp.Actors.*;
import drg.rideapp.Constants.Commands;
import drg.rideapp.Repo.Memory;
import drg.rideapp.Response.GenericResponse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ApplicationService {

    Memory memory;

    public ApplicationService(Memory memory) {
        this.memory = memory;
    }

    public GenericResponse addUser(User user){
        try {
            if (memory.getUsers().contains(user)) throw new Exception("User already added");
            if (!memory.getUsers().contains(user))
                memory.addUser(user);
            return new GenericResponse(true, Commands.USER_ADDED);
        }catch(Exception e){
            return new GenericResponse(false,e.getMessage());
        }
    }

    public GenericResponse addVehicle(User user,Vehicle vehicle){
        if(!memory.getUsers().contains(user)) return new GenericResponse(false,"User does not exist");
        vehicle.setUser(user);
        memory.addVehicle(vehicle);
        return new GenericResponse(true, "Vehicle Added");
    }

    public GenericResponse offerRide(User user,Vehicle vehicle, String origin, Integer seats, String destination, Date startTime, Integer duration){
        if(vehicle!=null && vehicle.getUser()!=user)
            return new GenericResponse(false,Commands.BAD_REQUEST);
        Ride ride = new Ride(user,vehicle,origin,seats,destination,startTime,duration);
        memory.addRides(ride);
        return new GenericResponse(true,Commands.RIDE_ADDED);
    }

    public Ride searchRide(String origin, String destination, RideType rideType){
        List<Ride> matchingRides = findMatchingRides(origin,destination);
        if(matchingRides.size()==0) return null;;
        if(rideType.equals(RideType.EARLIEST)) {
            matchingRides.sort(new RideComparator(rideType));
            return matchingRides.get(0);
        }
        if(rideType.equals(RideType.FASTEST)) {
            matchingRides.sort(new RideComparator(rideType));
            return matchingRides.get(0);
        }
        return null;
    }

    private List<Ride> findMatchingRides(String origin, String destination) {
        List<Ride> matchingRides = new ArrayList<>();
        List<Ride> rides = memory.getRides();
        for(Ride ride : rides){
            if(ride.getOrigin().equalsIgnoreCase(origin) && ride.getDestination().equalsIgnoreCase(destination))
                matchingRides.add(ride);
        }
        return matchingRides;
    }


}