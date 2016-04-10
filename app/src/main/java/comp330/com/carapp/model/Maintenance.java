package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Maintenance implements MaintenanceInterface{
    private String type;
    private String value;
    private String details;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
