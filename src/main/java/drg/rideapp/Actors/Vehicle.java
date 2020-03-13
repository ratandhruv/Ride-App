package drg.rideapp.Actors;

public class Vehicle {

    User user;

    String ownerName;

    String model;

    String reg;


    public Vehicle(String ownerName, String model, String reg) {
        this.ownerName = ownerName;
        this.model = model;
        this.reg = reg;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "user=" + user +
                ", ownerName='" + ownerName + '\'' +
                ", model='" + model + '\'' +
                ", reg='" + reg + '\'' +
                '}';
    }
}
