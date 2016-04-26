package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface MaintenanceInterface {
    public void setType(String type);

    public String getType();

    public void setValue(String value);

    public String getValue();

    public void setDetails(String details);

    public String getDetails();

    public MileageInterface getMileage();

    public void setMileage(MileageInterface mileage);
}
