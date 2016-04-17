package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.dal.MileageDAO;


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
    public ArrayList<Mileage> getMileageList(int vehicleID) {
        try {
            return mileageDAO.getMileageList(vehicleID);
        } catch (Exception se) {
            System.err.println("MileageService: Threw an exception retrieving mileage list.");
            System.err.println(se.getMessage());
        }
        return null;
    }


}
