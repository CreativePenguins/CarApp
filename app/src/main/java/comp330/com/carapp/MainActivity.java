package comp330.com.carapp;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import comp330.com.carapp.fragments.dashboard.DashboardFragment;
import comp330.com.carapp.fragments.maintenancelog.MaintenanceLogFragment;
import comp330.com.carapp.fragments.mileagelog.AddMileageDialog;
import comp330.com.carapp.fragments.mileagelog.MileageLogFragment;
import comp330.com.carapp.fragments.reminders.RemindersFragment;
import comp330.com.carapp.fragments.vehicleinfo.VehicleInfoFragment;
import comp330.com.carapp.model.Vehicle;
import comp330.com.carapp.model.VehicleInterface;
import comp330.com.carapp.service.VehicleService;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, VehicleInfoFragment.OnFragmentInteractionListener,
        MileageLogFragment.OnFragmentInteractionListener, MaintenanceLogFragment.OnFragmentInteractionListener,
        DashboardFragment.OnFragmentInteractionListener, RemindersFragment.OnFragmentInteractionListener{

    VehicleInterface selectedVehicle = null;
    VehicleService vehicleService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // by default, shows 1st vehicle.
        // TODO add drop down selection to select vehicle
        vehicleService = new VehicleService(this.getBaseContext());
        setSelectedVehicle(1);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = getFragmentManager().findFragmentById(R.id.container);
                if(f instanceof MileageLogFragment) {
                    showAddMileageDialog(1);
                } else {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //sets Dashboard as initial fragment instead of blank container
        try {
            Fragment fragment = DashboardFragment.class.newInstance();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        Class fragmentClass;
        int id = item.getItemId();
        switch(id) {
            case R.id.nav_dashboard:
                fragmentClass = DashboardFragment.class;
                break;
            case R.id.nav_vehicleinfo:
                fragmentClass = VehicleInfoFragment.class;
                break;
            case R.id.nav_mileagelog:
                fragmentClass = MileageLogFragment.class;
                break;
            case R.id.nav_maintenancelog:
                fragmentClass = MaintenanceLogFragment.class;
                break;
            case R.id.nav_reminders:
                fragmentClass = RemindersFragment.class;
                break;
            case R.id.nav_github:
                Uri url = Uri.parse("https://github.com/TAP1994/CarApp");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, url);
                startActivity(launchBrowser);
            default:
                fragmentClass = DashboardFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Replace whatever is in the container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


        /*if (id == R.id.nav_dashboard) {
            fragment = DashboardFragment.;
            // Handle the camera action
        } else if (id == R.id.nav_vehicleinfo) {
            fragmentClass = VehicleInfoFragment.class;
        } else if (id == R.id.nav_mileagelog) {
            fragmentClass = MileageLogFragment.class;
        } else if (id == R.id.nav_maintenancelog) {
            fragmentClass = MaintenanceLogFragment.class;
        } else if (id == R.id.nav_reminders) {
            fragmentClass = RemindersFragment.class;
        } *//*else if (id == R.id.nav_share) {

        }*//*
        fragment = (Fragment) fragmentClass.newInstance();*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {    }

    public void showAddMileageDialog(int vehicleID) {
        DialogFragment newFragment = AddMileageDialog.newInstance(vehicleID);
        newFragment.show(getFragmentManager(), "add mileage dialog");
    }

    public void setSelectedVehicle(int vehicleID) {
        this.selectedVehicle = vehicleService.getVehicle(vehicleID);
        TextView headerTitle = (TextView) (findViewById(R.id.nav_view)).findViewById(R.id.navHeaderTitle);
        headerTitle.setText(selectedVehicle.getName());
        TextView headerSubtitle = (TextView) (findViewById(R.id.nav_view)).findViewById(R.id.navHeaderSubtitle);
        headerSubtitle.setText(selectedVehicle.getMake() + ' ' + selectedVehicle.getModel());
    }

    public VehicleInterface getSelectedVehicle() {
        return this.selectedVehicle;
    }
}
