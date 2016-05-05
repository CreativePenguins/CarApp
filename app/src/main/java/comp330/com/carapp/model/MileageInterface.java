package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface MileageInterface {
    public void setDate(String date);
    public String getDate();
    public void setMileage(int mileage);
    public int getMileage();
    public int getVehicleID();
    public void setVehicleID(int vehicleID);
}