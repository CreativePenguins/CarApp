package comp330.com.carapp.model;

import java.util.HashMap;

/**
 * Created by aksharkumar on 4/2/16.
 */
public class VehicleSettings {
    private Integer mileageUpdateFreq;
    private HashMap maintenanceToTrack;

    public void setMileageUpdateFreq(Integer mileageUpdateFreq) {
        this.mileageUpdateFreq = mileageUpdateFreq;
    }

    public Integer getMileageUpdateFreq() {
        return mileageUpdateFreq;
    }


}
