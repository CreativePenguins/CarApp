package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 3/31/16.
 */
public class User implements UserInterface {
    private String name;
    private String username;
    private String password;
    private String licenseNo;
    private String imageURL;
    //vehicles is HashMap that uses the VIN String as a key and the vehicle as a value
    private HashMap<String, VehicleInterface> vehicles = new HashMap<>();

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setLicNo(String LicNo) {
        this.licenseNo = LicNo;
    }

    @Override
    public String getLicNo() {
        return licenseNo;
    }

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
    /**
     * Add a vehicle to the vehicles HashMap with a key of the VIN string
     * and a value of the vehicle itself.
     */
    public void addVehicle(VehicleInterface v) {
        if(!vehicles.containsKey(v.getVIN())) {
            vehicles.put(v.getVIN(), v);
        }
    }

    @Override
    public HashMap<String, VehicleInterface> getVehicles() {
        return vehicles;
    }


    @Override
    /**
     * Remove the vehicle from vehicles if it is in the HashMap of vehicles
     */
    public void removeVehicle(VehicleInterface v) {
        if(vehicles.containsValue(v)) {
            vehicles.remove(v.getVIN());
        }
    }
}
