package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface VehicleInterface {
    public void setMake(String make);
    public String getMake();
    public void setModel(String model);
    public String getModel();
    public void setYear(Integer year);
    public Integer getYear();
    public void setColor(String color);
    public String getColor();
    public String getLicensePlate();
    public void setLicensePlate(String licensePlate);
    public void setVIN(String VIN);
    public String getVIN();
    public void updateMileage(Integer i);
    public Mileage getMileage();
}
