package com.once.android.testandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.once.android.testandroid.adapters.ItemsAdapter;

/**
 * Main screen with the ui for the test.
 * <p/>
 * Fill in the recycler view with data coming from:
 * https://api.myjson.com/bins/2hjg2
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewToFill;
    ItemsAdapter mItemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mItemsAdapter = new ItemsAdapter(this);
        mRecyclerViewToFill = (RecyclerView) findViewById(R.id.mRecyclerViewToFill);
        mRecyclerViewToFill.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewToFill.setAdapter(mItemsAdapter);
    }

}
