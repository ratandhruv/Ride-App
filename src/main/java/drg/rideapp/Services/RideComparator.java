package drg.rideapp.Services;

import drg.rideapp.Actors.Ride;
import drg.rideapp.Actors.RideType;

import java.util.Comparator;

public class RideComparator implements Comparator<Ride> {

    RideType type;
    public RideComparator(RideType type) {
        this.type = type;
    }

    @Override
    public int compare(Ride r1, Ride r2) {
        if(RideType.EARLIEST.equals(type))
            return compareByStartTime(r1,r2);
        else return compareByDuration(r1,r2);

    }

    private int compareByStartTime(Ride r1, Ride r2) {
        if (r1.getStartTime().before(r2.getStartTime())) return -1;
        else return 1;
    }

    private int compareByDuration(Ride r1, Ride r2) {
        if (r1.getRideDuration() < r2.getRideDuration()) return -1;
        else return 1;
    }

}