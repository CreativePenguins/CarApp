package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface UserInterface {

    public void setName(String name);
    public String getName();
    public void setLicNo(String LicNo);
    public String getLicNo();
    public void setUsername (String username);
    public String getUsername();
    public void setPassword(String password);
    public String getPassword();
    public void setImageURL(String imageURL);
    public String getImageURL();
    public void addVehicle(VehicleInterface v);
    public HashMap<String, VehicleInterface> getVehicles();
    public void removeVehicle(VehicleInterface v);
}
