package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 3/31/16.
 */
public class User implements UserInterface {
    private String username;
    private String password;
    private String imageURL;
    private HashMap<String, VehicleInterface> vehicles = new HashMap<>();

    @Override
    public void setUsername (String username) {
        this.username = username;
    }

    @Override
    public String getUsername() { return username; }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() { return password; }

    @Override
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String getImageURL() { return imageURL; }

    @Override
    public void addVehicle(VehicleInterface v) {
        if(!vehicles.containsKey(v.getVIN())) vehicles.put(v.getVIN(), v);
    }

    @Override
    //this method could introduce potential bugs
    public VehicleInterface getVehicle(String s) {
        if(vehicles.containsKey(s)) {
            return vehicles.get(s);
        }
        else return null;
    }
}
