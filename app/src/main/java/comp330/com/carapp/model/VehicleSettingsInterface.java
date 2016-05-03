package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 4/10/16.
 */
public interface VehicleSettingsInterface {
    public void setMileageUpdateFreq(int mileageUpdateFreq);
    public int getMileageUpdateFreq();
    public void setMaintenanceToTrack(String s);
    public HashMap<String, Boolean> getMaintenanceToTrack();
}

