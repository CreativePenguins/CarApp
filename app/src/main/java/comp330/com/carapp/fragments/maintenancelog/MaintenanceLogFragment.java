package comp330.com.carapp.fragments.maintenancelog;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private ArrayList<MaintenanceInterface> list;
    private ArrayList<CardView> cardList;
    private MaintService maintService;
    private int vehicleID;

    private OnFragmentInteractionListener mListener;

    /**
     * Create a new instance of the MaintenanceLogFragment
     *
     * @param vehicleID
     * @return A new instance of fragment MaintenanceLogFragment.
     */
    public static MaintenanceLogFragment newInstance(int vehicleID) {
        MaintenanceLogFragment fragment = new MaintenanceLogFragment();

        // Supply vehicleID input as an argument.
        Bundle args = new Bundle();
        args.putInt("vehicleID", vehicleID);
        fragment.setArguments(args);
        return fragment;
    }

    public MaintenanceLogFragment() {
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
        maintService = new MaintService(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        maintService = new MaintService(getActivity());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maintenance_log, container, false);
        RecyclerView rview = (RecyclerView) view.findViewById(R.id.maintList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rview.setLayoutManager(llm);
        generateMaintList();
        //populateSampleList();
        MaintViewAdapter adapter = new MaintViewAdapter(list);
        rview.setAdapter(adapter);
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

    /*private void populateSampleList() {

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
    }*/


    private void generateMaintList() {
        ArrayList<MaintenanceInterface> dbList = maintService.getMaintList(vehicleID);
        HashMap<String, ArrayList<MaintenanceInterface>> recMap = new HashMap<String, ArrayList<MaintenanceInterface>>();
        list = new ArrayList<MaintenanceInterface>();
        //ArrayList<MaintenanceInterface> cList = new ArrayList<MaintenanceInterface>();
        String[] types = {"oil change", "brakes", "tires", "air filter"};
        for(String s : types) {
            recMap.put(s, new ArrayList<MaintenanceInterface>());
        }
        for(MaintenanceInterface m : dbList) {
            recMap.get(m.getType()).add(m);
        }
        for(String st : types) {
            if(!recMap.get(st).isEmpty()){
                list.add(recMap.get(st).get(recMap.get(st).size() - 1));
            }
        }

    }

}
