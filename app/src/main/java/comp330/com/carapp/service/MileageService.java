package comp330.com.carapp.service;

import android.content.Context;

import java.util.ArrayList;

import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.dal.MileageDAO;


/**
 * Created by Chrissy on 4/16/2016.
 */
public class MileageService {

    private MileageDAO mileageDAO;


    public MileageService(Context context) {
        mileageDAO = new MileageDAO(context);
    }
    public ArrayList<Mileage> getMileageList(int vehicleID) {
        try {
            return mileageDAO.getMileageList(vehicleID);
        } catch (Exception se) {
            System.err.println("MileageService: Threw an exception retreiving mileage list.");
            System.err.println(se.getMessage());
        }
        return null;
    }


}
