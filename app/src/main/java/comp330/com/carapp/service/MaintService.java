package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.dal.MaintDAO;
import comp330.com.carapp.model.MaintenanceInterface;

/**
 * Created by Tyler on 4/26/16.
 */
public class MaintService {
    private MaintDAO maintDAO;
    public MaintService(Context context){
        maintDAO = new MaintDAO(context);
    }


    /**
     *
     * @param type
     * @return a maintenance interface.
     */
    public ArrayList<MaintenanceInterface> getMaintList(int type) {
        try {
            return maintDAO.getMaintList(type);
        } catch (Exception e) {
            System.err.println("MaintServ: Threw an exception retrieving mileage list.");
            System.err.println(e.getMessage());
        } return null;
    }

    public void addMaint(MaintenanceInterface newMaint) {
        try {
            maintDAO.addMaint(newMaint);
        } catch (Exception e) {
            System.err.println("MaintServ: Threw an exception retrieving mileage list.");
            System.err.println(e.getMessage());
        }
    }
}
