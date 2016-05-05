package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface MileageInterface {
    void setDate(String date);
    String getDate();
    void setMileage(int mileage);
    int getMileage();
    int getVehicleID();
    void setVehicleID(int vehicleID);
}