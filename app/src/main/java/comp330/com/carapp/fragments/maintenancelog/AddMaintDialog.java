package comp330.com.carapp.fragments.maintenancelog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import comp330.com.carapp.R;
import comp330.com.carapp.model.Maintenance;
import comp330.com.carapp.model.MaintenanceInterface;
import comp330.com.carapp.model.Mileage;
import comp330.com.carapp.model.MileageInterface;
import comp330.com.carapp.service.MaintService;

/**
 * A dialog fragment that allows user to add maintenance in the maintenance log
 * section.
 *
 * Created by aksharkumar 04/27/16
 */
public class AddMaintDialog extends DialogFragment {
    private int vehicleID;
    private MaintService maintService;
    private static EditText selectedmaintDate;
    private static EditText selectmaintType;
    private static EditText selectedmaintMileage;

    /**
     * Create a new instance of MyDialogFragment, providing the vehicleID
     * as an argument.
     */
    public static AddMaintDialog newInstance(int vehicleID) {
        AddMaintDialog f = new AddMaintDialog();

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
        maintService = new MaintService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_maint_dialog, container, false);
        getDialog().setTitle(R.string.add_maint_title);

        maintService = new MaintService(getActivity());
        selectedmaintDate = (EditText) v.findViewById(R.id.insertMaintDate);
        selectedmaintMileage = (EditText) v.findViewById(R.id.insertMaintMileage);
        selectmaintType = (EditText) v.findViewById(R.id.insertMaintType);

        // Watch for button clicks.
        Button addButton = (Button)v.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String date = selectedmaintDate.getText().toString();
                String type = selectmaintType.getText().toString();
                MileageInterface mileage = new Mileage();
                mileage.setMileage(Integer.parseInt(selectedmaintMileage.getText().toString()));
                MaintenanceInterface newMaintenance = new Maintenance();
                //newMaintenance.setVehicleID(vehicleID);
                newMaintenance.setType(type);
                newMaintenance.setMileage(mileage);
                newMaintenance.getMileage().setDate(date);
                maintService.addMaint(newMaintenance);
                getDialog().dismiss();
            }
        });

        selectedmaintDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showDialog(DATEINIT_DIALOG);
                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.show(getFragmentManager(), "add maintenance dialog");
            }

        });
        selectmaintType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaintTypeFragment maintTypeFragment = new MaintTypeFragment();
                maintTypeFragment.show(getFragmentManager(), "add maintenance type");
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

    public static class MaintTypeFragment extends DialogFragment {
        String[] mainttypes = {"oil change", "brakes", "tires", "air filter"};
        int selectedItem = 0;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Pick a Maintenance Type")
                    .setSingleChoiceItems(mainttypes, selectedItem, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            selectmaintType.setText(mainttypes[which]);
                            dialog.dismiss();
                        }
                    });
            return builder.create();
        }
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

        public void onDateSet(DatePicker view, int year, int month, int day) {
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
            selectedmaintDate.setText(date);
        }
    }
}
