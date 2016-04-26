package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Maintenance implements MaintenanceInterface{

    private String type;
    private String value;
    private String details;
    private MileageInterface mileage;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public MileageInterface getMileage() {
        return mileage;
    }

    @Override
    public void setMileage(MileageInterface mileage) {
        this.mileage = mileage;
    }
}
