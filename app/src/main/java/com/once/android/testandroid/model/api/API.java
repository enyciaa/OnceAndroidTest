package com.once.android.testandroid.model.api;

import android.util.Log;

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
 *
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
        Call<ResponseBody> call = getService().getListData();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    List<Person> people = new ArrayList<Person>();
                    Person person = new Person();
                    person.setAge(25);
                    person.setNames("Super Mario");
                    person.setPicture_url("https://s3.amazonaws.com/spoke-profiles-prod-assets/avatars/210x210h/c7fe1fb2460dd145a6a367654cafde42bdbd5874.png");
                    people.add(person);
                    bus.post(new GotListDataEvent.OnCompleted(people));
                } else {
                    int statusCode = response.code();
                    ResponseBody errorBody = response.errorBody();
                    Log.v("test", "error = " + errorBody.toString());
                    Log.v("test", "status = " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if (t != null && t.getMessage() != null) {
                    Log.v("test", "call failed " + ExceptionUtils.throwableStackTraceToString(t));
                } else {
                    Log.v("test", "failed no message");
                }
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
