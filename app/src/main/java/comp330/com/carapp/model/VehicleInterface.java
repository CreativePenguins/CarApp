package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface VehicleInterface {
    String getName();
    void setName(String name);
    void setMake(String make);
    String getMake();
    void setModel(String model);
    String getModel();
    void setYear(int year);
    int getYear();
    void setColor(String color);
    String getColor();
    String getLicensePlate();
    void setLicensePlate(String licensePlate);
    void setVIN(String VIN);
    String getVIN();
}