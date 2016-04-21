package comp330.com.carapp.fragments.mileagelog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import comp330.com.carapp.R;
import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.model.MileageInterface;
import comp330.com.carapp.service.MileageService;

/**
 * Created by Chrissy on 4/18/2016.
 */
public class AddMileageDialog extends DialogFragment {

    private int vehicleID;
    private MileageService mileageService;

    /**
     * Create a new instance of MyDialogFragment, providing the vehicleID
     * as an argument.
     */
    public static AddMileageDialog newInstance(int vehicleID) {
        AddMileageDialog f = new AddMileageDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("vehicleID", vehicleID);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vehicleID = getArguments().getInt("vehicleID");
        mileageService = new MileageService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_mileage_dialog, container, false);
        getDialog().setTitle(R.string.add_mileage_title);

        mileageService = new MileageService(getActivity());
        final EditText selectedDate = (EditText) v.findViewById(R.id.insertDate);
        final EditText selectedMileage = (EditText) v.findViewById(R.id.insertMileage);

        // Watch for button clicks.
        Button addButton = (Button)v.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String date = selectedDate.getText().toString();
                int mileage = Integer.parseInt(selectedMileage.getText().toString());
                MileageInterface newMileage = new Mileage();
                newMileage.setVehicleID(vehicleID);
                newMileage.setDate(date);
                newMileage.setMileage(mileage);
                mileageService.addMileage(newMileage);
                getDialog().dismiss();
            }
        });

        Button closeButton = (Button)v.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // cancel dialog when clicking close
                getDialog().cancel();
            }
        });
        return v;
    }
}
