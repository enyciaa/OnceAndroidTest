package com.once.android.testandroid;

import android.app.Application;

import com.once.android.testandroid.model.api.APIServiceProvider;

/**
 * Created by Ian on 06/06/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Setup api service
        APIServiceProvider.INSTANCE.setService(null);
    }

}

