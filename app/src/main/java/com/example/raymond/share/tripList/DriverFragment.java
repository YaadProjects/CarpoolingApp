package com.example.raymond.share.tripList;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.raymond.share.R;
import com.example.raymond.share.RegTrip;
import com.example.raymond.share.jsonparser.ShareApi;
import com.example.raymond.share.jsonparser.ShareJSON;
import com.example.raymond.share.model.Trip;
import com.example.raymond.share.model.User;
import com.example.raymond.share.tripList.verifyLicense.LicenseVerification;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DriverFragment extends Fragment {

    private FloatingActionButton fab;
    private RecyclerView driverList;
    private TripAdapter driverAdapter;
    ProgressDialog mProgressDialog;

    public DriverFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_driver, container, false);

        driverList = (RecyclerView) v.findViewById(R.id.driverList);
        driverList.setLayoutManager(new LinearLayoutManager(getActivity()));
        driverAdapter = new TripAdapter();
        driverList.setAdapter(driverAdapter);

        loadData();

        fab = (FloatingActionButton) v.findViewById(R.id.addTrip);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User().getUserAccount(getActivity());

                if (user.getRole().equals("driver")){
                    Intent intent = new Intent(getActivity(), RegTrip.class);
                    intent.putExtra("role", "driver");
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getActivity(), LicenseVerification.class);
                    startActivity(intent);
                }
            }
        });

        //hide floating button when srcoll the list
        driverList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx,int dy){
                super.onScrolled(recyclerView, dx, dy);

                if (dy >0) {
                    // Scroll Down
                    if (fab.isShown()) {
                        fab.hide();
                    }
                }
                else if (dy <0) {
                    // Scroll Up
                    if (!fab.isShown()) {
                        fab.show();
                    }
                }
            }
        });

        return v;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getActivity().getMenuInflater().inflate(R.menu.menu_card_demo, menu);
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

    public void loadData() {

        mProgressDialog = ShareApi.init(getActivity())
                .setProgressDialog(mProgressDialog)
                .getTrips("driver")
                .call(new ShareApi.CustomJsonResponseHandler() {

                    @Override
                    public void onSuccess(JSONObject response, ShareJSON meta) {

                        List<Trip> drive = new ArrayList<>();

                        try {

                            for (int i = 0; i < meta.getResults().length(); i++) {

                                drive.add(new Trip(meta.getResults().getJSONObject(i)));

                            }

                            driverAdapter.addData(drive);
                            driverAdapter.getFrom("fragment");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Throwable e, JSONObject response, ShareJSON meta) {

                    }

                })
        .keepProgressDialog()
        .getProgressDialog();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }
}
