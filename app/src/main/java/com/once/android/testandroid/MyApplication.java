package com.once.android.testandroid;

import android.app.Application;
import android.content.ContextWrapper;

import com.once.android.testandroid.model.api.APIServiceProvider;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by Ian on 06/06/2016.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Setup api service
        APIServiceProvider.INSTANCE.setService(null);

        // Set up shared preference helper
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName("once_test")
                .setUseDefaultSharedPreference(true)
                .build();
    }

}

