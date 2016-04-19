package comp330.com.carapp.fragments.mileagelog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import comp330.com.carapp.R;

/**
 * Created by Chrissy on 4/18/2016.
 */
public class AddMileageDialog extends DialogFragment {

    private int vehicleID;
    /**
     * Create a new instance of MyDialogFragment, providing "num"
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
        vehicleID = getArguments().getInt("num");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.add_mileage_dialog, container, false);
        getDialog().setTitle(R.string.add_mileage_title);
        // Watch for button clicks.
        Button addButton = (Button)v.findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // show snack bar toast when click add button
                Snackbar.make(v, "Add Mileage Dialog", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
