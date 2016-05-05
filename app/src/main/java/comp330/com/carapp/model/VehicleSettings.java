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
        maintenanceToTrack = new HashMap<>();
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

    /**
     * Method is called to switch the current tracking
     * of the input maintenance type. If the input type is set to false,
     * the method switches it to true. If the input type is set to true,
     * the method switches it to false.
     * @param maintType type of maintenance to set
     */
    @Override
    public void setMaintenanceToTrack(String maintType) {
        if(maintenanceToTrack.get(maintType)) {
            maintenanceToTrack.put(maintType, false);
        }
        else {
            maintenanceToTrack.put(maintType, true);
        }
    }

    @Override
    public HashMap<String, Boolean> getMaintenanceToTrack() {
        return maintenanceToTrack;
    }

    private void initialSetMaintenanceToTrack() {
        maintenanceToTrack.put("air filter", true);
        maintenanceToTrack.put("brakes", true);
        maintenanceToTrack.put("oil change", true);
        maintenanceToTrack.put("tires", true);
    }
}