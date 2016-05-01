package comp330.com.carapp.fragments.maintenancelog;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import comp330.com.carapp.R;
import comp330.com.carapp.model.MaintenanceInterface;
import comp330.com.carapp.service.MaintService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MaintenanceLogFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MaintenanceLogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MaintenanceLogFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ArrayList<HashMap<String, String>> list;
    public static final String DATE_COLUMN = "Date Column";
    public static final String MILEAGE_COLUMN = "Mileage Column";
    public static final String TYPE_COLUMN = "Type Column";
    private MaintService maintService;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MaintenanceLogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MaintenanceLogFragment newInstance(String param1, String param2) {
        MaintenanceLogFragment fragment = new MaintenanceLogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MaintenanceLogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        maintService = new MaintService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        maintService = new MaintService(getActivity());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maintenance_log, container, false);
        ListView lview = (ListView) view.findViewById(R.id.maintList);
        generateMaintList(1);
        //populateSampleList();
        MaintListViewAdapter adapter = new MaintListViewAdapter(getActivity(), list);
        lview.setAdapter(adapter);
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

    private void populateSampleList() {

        list = new ArrayList<HashMap<String, String>>();

        //get values from database here
        HashMap<String, String> temp1 = new HashMap<String, String>();
        temp1.put(TYPE_COLUMN,"Oil Change");
        temp1.put(MILEAGE_COLUMN, "12,000 miles");
        list.add(temp1);

        HashMap<String, String> temp2 = new HashMap<String, String>();
        temp2.put(TYPE_COLUMN,"Brakes");
        temp2.put(MILEAGE_COLUMN, "12,500 miles");
        list.add(temp2);

        HashMap<String, String> temp3 = new HashMap<String, String>();
        temp3.put(TYPE_COLUMN,"Oil Change");
        temp3.put(MILEAGE_COLUMN, "15,000 miles");
        list.add(temp3);
    }
    private void generateMaintList(int vehicleID) {
        ArrayList<MaintenanceInterface> dbList = maintService.getMaintList(vehicleID);
        list = new ArrayList<HashMap<String, String>>();
        if(dbList.size() > 0) {
            for(MaintenanceInterface maint : dbList) {
                HashMap<String, String> temp = new HashMap<String, String>();
                //temp.put(DATE_COLUMN, maint.get());
                temp.put(TYPE_COLUMN, maint.getType());
                temp.put(MILEAGE_COLUMN, Integer.valueOf(maint.getMileage().getMileage()).toString());
                list.add(temp);
            }
        }
    }

}
