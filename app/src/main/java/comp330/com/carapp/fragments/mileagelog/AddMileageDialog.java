package comp330.com.carapp.fragments.mileagelog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import comp330.com.carapp.R;
import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.model.MileageInterface;
import comp330.com.carapp.service.MileageService;

/**
 * Dialog to add mileage that opens when clicking the plus button when in the Mileage Log
 */
public class AddMileageDialog extends DialogFragment {

    private int vehicleID;
    private MileageService mileageService;
    private static EditText selectedDate;
    private EditText selectedMileage;

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
        if (getArguments() != null) {
            vehicleID = getArguments().getInt("vehicleID");
        } else {
            vehicleID = 1;
        }
        mileageService = new MileageService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_mileage_dialog, container, false);
        getDialog().setTitle(R.string.add_mileage_title);

        mileageService = new MileageService(getActivity());
        selectedDate = (EditText) v.findViewById(R.id.insertDate);
        selectedMileage = (EditText) v.findViewById(R.id.insertMileage);

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

        selectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog(DATEINIT_DIALOG);
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "add mileage dialog");
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

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            month += 1;
            String date = String.valueOf(year);
            if (month < 10) {
                date += "0" + String.valueOf(month);
            } else {
                date += month;
            }

            if (day < 10) {
                date += "0" + String.valueOf(day);
            } else {
                date += day;
            }
            selectedDate.setText(date);
        }
    }
}


