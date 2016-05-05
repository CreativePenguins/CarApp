package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface MaintenanceInterface {
    void setType(String type);
    String getType();
    void setValue(String value);
    String getValue();
    void setDetails(String details);
    String getDetails();
    MileageInterface getMileage();
    void setMileage(MileageInterface mileage);
}