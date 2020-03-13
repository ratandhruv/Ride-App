package drg.rideapp.Response;

public class GenericResponse {

    Boolean success;

    String message;

    public GenericResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}