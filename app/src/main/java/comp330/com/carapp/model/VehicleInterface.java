package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface VehicleInterface {
    public String getName();
    public void setName(String name);
    public void setMake(String make);
    public String getMake();
    public void setModel(String model);
    public String getModel();
    public void setYear(int year);
    public int getYear();
    public void setColor(String color);
    public String getColor();
    public String getLicensePlate();
    public void setLicensePlate(String licensePlate);
    public void setVIN(String VIN);
    public String getVIN();
}
