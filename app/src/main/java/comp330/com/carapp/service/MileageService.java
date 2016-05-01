package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.dal.MileageDAO;
import comp330.com.carapp.model.MileageInterface;


/**
 * Service layer for the mileage - middle layer between DAO and Android view
 */
public class MileageService {

    private MileageDAO mileageDAO;

    public MileageService(Context context) {
        mileageDAO = new MileageDAO(context);
    }

    /**
     * Gets the list of mileage for a particular vehicle.
     * @param vehicleID selected vehicle to get the mileage for
     * @return an ArrayList of Mileage objects
     */
    public ArrayList<MileageInterface> getMileageList(int vehicleID) {
        try {
            return mileageDAO.getMileageList(vehicleID);
        } catch (Exception se) {
            System.err.println("MileageService: Threw an exception retrieving mileage list.");
            System.err.println(se.getMessage());
        }
        return null;
    }

    /**
     * Adds a new mileage entry for a particular vehicle.
     * @param newMileage entry
     */
    public void addMileage(MileageInterface newMileage) {
        try {
            mileageDAO.addMileage(newMileage);
        } catch (Exception se) {
            System.err.println("MileageService: Threw an exception adding to the mileage table.");
            System.err.println(se.getMessage());
        }
    }

    /**
     * Gets the current mileage for a specific vehicle
     * @param vehicleID selected vehicle to get the current mileage for
     * @return a Mileage object representing the current mileage
     */
    public MileageInterface getCurrentMileage(int vehicleID) {
        try {
            return mileageDAO.getCurrentMileage(vehicleID);
        } catch (Exception se) {
            System.err.println("MileageService: Threw an exception getting the current mileage.");
            System.err.println(se.getMessage());
        }
        return null;
    }

}
