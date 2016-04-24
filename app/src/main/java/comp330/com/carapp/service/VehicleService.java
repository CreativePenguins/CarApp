package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.dal.VehicleDAO;
import comp330.com.carapp.model.VehicleInterface;

/**
 * Service layer for the vehicle - middle layer between DAO and Android view
 */
public class VehicleService {

    private VehicleDAO vehicleDAO;

    public VehicleService(Context context) {
        vehicleDAO = new VehicleDAO(context);
    }

    /**
     * Gets the list of vehicles.
     * @return an ArrayList of Vehicle objects
     */
    public ArrayList<VehicleInterface> getVehicleList() {
        try {
            return vehicleDAO.getVehicleList();
        } catch (Exception se) {
            System.err.println("VehicleService: Threw an exception retrieving vehicle list.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    /**
     * Adds a new vehicle.
     * @param newVehicle to be added
     */
    public void addVehicle(VehicleInterface newVehicle) {
        try {
            vehicleDAO.addVehicle(newVehicle);
        } catch (Exception se) {
            System.err.println("VehicleService: Threw an exception adding to the VehicleData table.");
            System.err.println(se.getMessage());
        }
    }

}
