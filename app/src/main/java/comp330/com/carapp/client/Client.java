package comp330.com.carapp.client;

import java.util.ArrayList;

import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.service.MileageService;

/**
 * Client to make sure DAO works
 */
public class Client {

    public Client() {
        MileageService mileageService = new MileageService(null);

        ArrayList<Mileage> mileageList = mileageService.getMileageList(1);
        System.out.println(mileageList);
    }
}
