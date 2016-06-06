package com.once.android.testandroid.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.once.android.testandroid.R;
import com.once.android.testandroid.bus.BusProvider;
import com.once.android.testandroid.bus.VariableEvent;
import com.once.android.testandroid.model.ItemModel;
import com.once.android.testandroid.model.Session;
import com.once.android.testandroid.model.pojo.Item;
import com.once.android.testandroid.model.pojo.Person;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Main screen with the ui for the test.
 * <p/>
 * Fill in the recycler view with data coming from:
 * https://api.myjson.com/bins/2hjg2
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Views
     */
    @Bind(R.id.list_people_recycler) RecyclerView recyclerView;

    /**
     * Data model
     */
    private ItemModel peopleAndDevicesModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Get models
        peopleAndDevicesModel = Session.INSTANCE.getPeopleAndDevicesModel();

        // Build list
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        // Get data
        peopleAndDevicesModel.getListData();
    }


    @Override
    public void onResume() {
        super.onResume();
        BusProvider.INSTANCE.getBus().register(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        BusProvider.INSTANCE.getBus().unregister(this);
    }


    /**
     * Set data for the list
     */
    private void setListData(List<Item> items) {
        if (recyclerView.getAdapter() == null) {
            // Add adapter
            ItemsAdapter adapter = new ItemsAdapter(this, items);
            recyclerView.setAdapter(adapter);
        }
        else {
            // Update adapter
            ItemsAdapter adapter = (ItemsAdapter) recyclerView.getAdapter();
            adapter.updateDataSet(items);
        }
    }


    /**
     * List data updated event
     */
    @Subscribe
    public void listDataUpdated(VariableEvent.OnPeopleUpdated onVariableChanged) {
        setListData(peopleAndDevicesModel.getItems());
    }

}
