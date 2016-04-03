package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class Mileage {
    private Integer mileage;
    private String date;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getMileage() {
        return mileage;
    }
}
