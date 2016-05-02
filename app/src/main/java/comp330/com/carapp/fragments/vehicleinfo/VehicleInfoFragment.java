package comp330.com.carapp.fragments.vehicleinfo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import comp330.com.carapp.R;
import comp330.com.carapp.model.VehicleInterface;
import comp330.com.carapp.service.VehicleService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VehicleInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VehicleInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VehicleInfoFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private VehicleService vehicleService;
    private int vehicleID;

    /**
     * Create a new instance of VehicleInfoFragment.
     *
     * @param vehicleID selected vehicle
     * @return A new instance of fragment VehicleInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VehicleInfoFragment newInstance(int vehicleID) {
        VehicleInfoFragment fragment = new VehicleInfoFragment();

        // Supply vehicleID input as an argument.
        Bundle args = new Bundle();
        args.putInt("vehicleID", vehicleID);
        fragment.setArguments(args);
        return fragment;
    }

    public VehicleInfoFragment() {
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
        vehicleService = new VehicleService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicle_info, container, false);
        setVehicleInfo(1, view);
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

    public void setVehicleInfo(int vehicleID, View view) {
        VehicleInterface vehicle = vehicleService.getVehicle(vehicleID);
        TextView tvName = (TextView) view.findViewById(R.id.vehicle_name);
        TextView tvMake = (TextView) view.findViewById(R.id.vehicle_make);
        TextView tvModel = (TextView) view.findViewById(R.id.vehicle_model);
        TextView tvYear = (TextView) view.findViewById(R.id.vehicle_year);
        TextView tvColor = (TextView) view.findViewById(R.id.vehicle_color);
        TextView tvLicensePlate = (TextView) view.findViewById(R.id.vehicle_licenseplate);

        tvName.setText(vehicle.getName());
        tvMake.setText(vehicle.getMake());
        tvModel.setText(vehicle.getModel());
        tvYear.setText(Integer.toString(vehicle.getYear()));
        tvColor.setText(vehicle.getColor());
        tvLicensePlate.setText(vehicle.getLicensePlate());

    }
}
