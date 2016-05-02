package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.dal.MaintDAO;
import comp330.com.carapp.model.MaintenanceInterface;

/**
 * Service layer for the maintenance - middle layer between DAO and Android view
 */
public class MaintService {
    private MaintDAO maintDAO;
    public MaintService(Context context){
        maintDAO = new MaintDAO(context);
    }


    /**
     * Gets a list of maintenance objects of a particular type.
     * @param type of maintenance to filter by
     * @return a maintenance interface.
     */
    public ArrayList<MaintenanceInterface> getMaintListByType(String type) {
        try {
            return maintDAO.getMaintListByType(type);
        } catch (Exception e) {
            System.err.println("MaintService: Threw an exception retrieving maintenance list by type.");
            System.err.println(e.getMessage());
        } return null;
    }

    /**
     * Add a maintenance object to the maintenance and mileage tables.
     * @param newMaint to be added
     */
    public void addMaint(MaintenanceInterface newMaint) {
        try {
            maintDAO.addMaint(newMaint);
        } catch (Exception e) {
            System.err.println("MaintService: Threw an exception adding to maintenance table.");
            System.err.println(e.getMessage());
        }
    }
}
