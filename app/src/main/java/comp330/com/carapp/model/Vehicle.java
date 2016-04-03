package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Vehicle {
    private String make;
    private String model;
    private Integer year;
    private String color;
    private String licensePlate;
    private String VIN;

    public void setMake(String make) {
        this.make = make;
    }
    
    public String getMake(){ return make; }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }
}
