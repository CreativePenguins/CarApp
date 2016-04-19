package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Mileage implements MileageInterface{
    private int mileage;
    private String date;
    private int vehicleID;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}
