package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Vehicle implements VehicleInterface{

    private String name;
    private String make;
    private String model;
    private int year;
    private String color;
    private String licensePlate;
    private String VIN;
    private MileageInterface mileage;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String getMake(){ return make; }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @Override
    public String getVIN() {
        return VIN;
    }

    @Override
    public void setMileage(int i) {
        mileage.setMileage(i);
    }

    @Override
    public MileageInterface getMileage() {
        return mileage;
    }
}
