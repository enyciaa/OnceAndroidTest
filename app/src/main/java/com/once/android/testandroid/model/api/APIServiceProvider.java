package com.once.android.testandroid.model.api;

import android.util.Log;

import com.once.android.testandroid.utils.NetworkUtils;

/**
 * API service singleton
 */
public enum APIServiceProvider {
    INSTANCE;

    private APIInterface service = null;


    /**
     * Set service
     */
    public void setService(String token) {
        service = NetworkUtils.createRetrofitService(APIInterface.class, APIInterface.TARGET_URL, token);
    }


    /**
     * Get service
     */
    public APIInterface getService() {
        if (service == null) {
            throw new RuntimeException("API service has not been initilised");
        }
        return service;
    }

}
