package comp330.com.carapp.model;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface UserInterface {
    public void setUsername (String username);
    public String getUsername();
    public void setPassword(String password);
    public String getPassword();
    public void setImageURL(String imageURL);
    public String getImageURL();
    public void addVehicle(VehicleInterface v);
    //this method could introduce potential bugs
    public VehicleInterface getVehicle(String s);
}
