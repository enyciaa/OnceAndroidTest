package com.once.android.testandroid.model.api;

import android.util.Log;

import com.once.android.testandroid.model.pojo.Item;
import com.once.android.testandroid.model.pojo.ItemsListResult;
import com.once.android.testandroid.utils.ExceptionUtils;
import com.once.android.testandroid.bus.BusProvider;
import com.once.android.testandroid.bus.GotListDataEvent;
import com.once.android.testandroid.model.pojo.Person;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Makes calls to the api
 * Receives the responses from the api calls and dispatches them throughout the application
 * <p/>
 * NOTES:
 * Call retrofit service with:
 * Execute for synchronous
 * Enqueue for ASync
 */
public class API {

    // Event bus to dispatch response results throughout the application
    private EventBus bus = BusProvider.INSTANCE.getBus();


    /**
     * Constructor
     */
    public API() {
    }


    /**
     * Get list data
     */
    public void getListData() {
        Call<ItemsListResult> call = getService().getListData();
        call.enqueue(new Callback<ItemsListResult>() {
            @Override
            public void onResponse(Call<ItemsListResult> call, Response<ItemsListResult> response) {
                if (response.isSuccessful()) {
                    bus.post(new GotListDataEvent.OnCompleted(response.body().getArray()));
                } else {
                    int statusCode = response.code();
                    ResponseBody errorBody = response.errorBody();
                    Log.v("test", "error = " + errorBody.toString());
                    Log.v("test", "status = " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<ItemsListResult> call, Throwable t) {

            }
        });
    }


    /**
     * Get api service
     */
    private APIInterface getService() {
        return APIServiceProvider.INSTANCE.getService();
    }
}
