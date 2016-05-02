package comp330.com.carapp.fragments.dashboard;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import comp330.com.carapp.R;
import comp330.com.carapp.model.MaintenanceInterface;
import comp330.com.carapp.service.*;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {


    private OnFragmentInteractionListener mListener;
    private MileageService mileageService;
    private MaintService maintService;
    private int vehicleID;

    /**
     * Create a new instance of the Dashboard fragment,
     * providing the vehicleID as an input.
     *
     * @param vehicleID currently selected vehicle
     * @return A new instance of fragment DashboardFragment.
     */
    public static DashboardFragment newInstance(int vehicleID) {
        DashboardFragment fragment = new DashboardFragment();
        // Supply vehicleID input as an argument.
        Bundle args = new Bundle();
        args.putInt("vehicleID", vehicleID);
        fragment.setArguments(args);
        return fragment;
    }

    public DashboardFragment() {
        // Required empty public constructor
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
        maintService = new MaintService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        updateMileageValues(view);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private void updateMileageValues(View view) {
        TextView tvCurrentMileage = (TextView) view.findViewById(R.id.currentMileage);
        TextView tvLastAtMileage = (TextView) view.findViewById(R.id.lastAtMileage);
        TextView tvNextAtMileage = (TextView) view.findViewById(R.id.nextAtMileage);
        FixedArcProgress arcProgress = (FixedArcProgress) view.findViewById(R.id.arc_progress);

        int currentMileage = mileageService.getCurrentMileage(1).getMileage();
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        String formattedCurrentMileage = formatter.format(currentMileage) + " miles";
        tvCurrentMileage.setText(formattedCurrentMileage);

        ArrayList<MaintenanceInterface> oilChangeList = maintService.getMaintListByType(vehicleID, "oil change");
        MaintenanceInterface lastOilChange = oilChangeList.get(oilChangeList.size() - 1);
        int lastOCMileage = lastOilChange.getMileage().getMileage();
        String formattedLastOCMileage = formatter.format(lastOCMileage);
        tvLastAtMileage.setText(formattedLastOCMileage);

        int nextOCMileage = lastOCMileage + 3000;
        String formattedNextOCMileage = formatter.format(nextOCMileage);
        tvNextAtMileage.setText(formattedNextOCMileage);

        // find difference between current mileage and last oil change mileage,
        // divide it by 3000, then convert to percentage
        // always rounds down to make sure it's never rounded up to 100%
        int progress = (int) Math.floor((currentMileage - lastOCMileage) / 30);
        arcProgress.setProgress(progress);
    }

}
