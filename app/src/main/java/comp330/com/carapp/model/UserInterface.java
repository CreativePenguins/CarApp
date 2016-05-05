package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface UserInterface {
    void setName(String name);
    String getName();
    void setLicNo(String LicNo);
    String getLicNo();
    void setUsername (String username);
    String getUsername();
    void setPassword(String password);
    String getPassword();
    void setImageURL(String imageURL);
    String getImageURL();
    void addVehicle(VehicleInterface v);
    HashMap<String, VehicleInterface> getVehicles();
    void removeVehicle(VehicleInterface v);
}