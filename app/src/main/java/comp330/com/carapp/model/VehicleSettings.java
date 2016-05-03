package comp330.com.carapp.model;
import java.util.HashMap;
/**
 * Created by aksharkumar on 4/2/16.
 */
public class VehicleSettings implements VehicleSettingsInterface {

    private int mileageUpdateFreq;
    //need to define methods for setting maintenance to track
    private HashMap<String, Boolean> maintenanceToTrack;

    VehicleSettings() {
        initialSetMaintenanceToTrack();
    }

    @Override
    public void setMileageUpdateFreq(int mileageUpdateFreq) {
        this.mileageUpdateFreq = mileageUpdateFreq;
    }

    @Override
    public int getMileageUpdateFreq() {
        return mileageUpdateFreq;
    }

    @Override
    public void setMaintenanceToTrack(String s) {
        if(maintenanceToTrack.get(s)) {
            maintenanceToTrack.put(s, false);
        }
        else {
            maintenanceToTrack.put(s, true);
        }
    }

    @Override
    public HashMap<String, Boolean> getMaintenanceToTrack() {
        return maintenanceToTrack;
    }

    private void initialSetMaintenanceToTrack() {
        setMaintenanceToTrack("brakes");
        setMaintenanceToTrack("oil change");
        setMaintenanceToTrack("air filter");
        setMaintenanceToTrack("tires");
    }
}
