package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 3/31/16.
 */
public class User {
    private String username;
    private String password;
    private String imageURL;
    private HashMap<String, Vehicle> vehicles;

    public void setUsername (String username) {
        this.username = username;
    }
    public String getUsername() { return username; }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() { return password; }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getImageURL() { return imageURL; }

    public void addVehicle(Vehicle v) {
        if(!vehicles.containsKey(v.getVIN())) vehicles.put(v.getVIN(), v);
    }
    
    //this method could introduce potential bugs
    public Vehicle getVehicle(String s) {
        if(vehicles.containsKey(s)) {
            return vehicles.get(s);
        }
        else return null;
    }
}
