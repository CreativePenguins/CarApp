package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Mileage implements MileageInterface{
    private int mileage = 0;
    private String date = "";
    private int vehicleID = 0;

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    @Override
    public int getVehicleID() {
        return vehicleID;
    }

    @Override
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }
}
