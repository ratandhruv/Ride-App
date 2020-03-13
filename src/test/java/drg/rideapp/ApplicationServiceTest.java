package drg.rideapp;

import drg.rideapp.Actors.Ride;
import drg.rideapp.Actors.RideType;
import drg.rideapp.Actors.User;
import drg.rideapp.Actors.Vehicle;
import drg.rideapp.Repo.Memory;
import drg.rideapp.Services.ApplicationService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.creation.SuspendMethod;

import java.util.ArrayList;
import java.util.Date;


public class ApplicationServiceTest {

    Memory memory = new Memory();
    ApplicationService service = new ApplicationService(memory);

    @Test
    public void runAllTests() {
        work();
    }

    public void work() {
        User rohan = new User("Rohan", "M", 36);
        Vehicle rohanVehicle = new Vehicle("Shashank", "Baleno", "KA");
        service.addUser(rohan);
        service.addVehicle(rohan,rohanVehicle);

        User shashank = new User("Shashank", "M", 29);
        Vehicle shashankVehicle = new Vehicle("Shashank", "Baleno", "TS");
        service.addUser(shashank);
        service.addVehicle(shashank, shashankVehicle);

        User nandini = new User("Nandini", "F", 29);
        service.addUser(nandini);

        User shipra = new User("Shipra", "F", 27);
        Vehicle shipraVehicle = new Vehicle("Shipra", "Polo", "KA-02");
        Vehicle shipraVehicle2 = new Vehicle("Shipra", "Scooty", "KA-12");
        service.addUser(shipra);
        service.addVehicle(shipra, shipraVehicle);
        service.addVehicle(shipra, shipraVehicle2);

        User gaurav = new User("Gaurav", "M", 29);
        service.addUser(gaurav);

        service.offerRide(rohan, rohanVehicle, "Hyderabad", 1, "Bangalore", new Date(), 13);
        service.offerRide(shipra, shipraVehicle2, "Bangalore", 1, "Mysore", new Date(), 13);
        service.offerRide(shipra, shipraVehicle, "Bangalore", 2, "Mysore", new Date(), 4);
        service.offerRide(shashank, shashankVehicle, "Hyderabad", 2, "Bangalore", new Date(), 14);

        Ride ride = service.searchRide( "Bangalore","Mysore", RideType.FASTEST);
        System.out.println("Ride found");
        System.out.println(ride.toString());

        ride = service.searchRide("Mumbai","Mysore", RideType.FASTEST);
        System.out.println(ride==null ? "Not found" : ride);

        ride = service.searchRide("Hyderabad","Bangalore", RideType.FASTEST);
        System.out.println("Ride found");
        System.out.println(ride==null ? "Not found" : ride);






    }

}