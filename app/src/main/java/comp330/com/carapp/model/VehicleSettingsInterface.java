package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface VehicleSettingsInterface {
    void setMileageUpdateFreq(int mileageUpdateFreq);
    int getMileageUpdateFreq();
    void setMaintenanceToTrack(String maintType);
    HashMap<String, Boolean> getMaintenanceToTrack();
}