package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class VehicleSettings implements VehicleSettingsInterface {
    private Integer mileageUpdateFreq;
    //need to define methods for setting maintenance to track
    private HashMap<String, Boolean> maintenanceToTrack;

    public void setMileageUpdateFreq(Integer mileageUpdateFreq) {
        this.mileageUpdateFreq = mileageUpdateFreq;
    }

    public Integer getMileageUpdateFreq() {
        return mileageUpdateFreq;
    }


}
