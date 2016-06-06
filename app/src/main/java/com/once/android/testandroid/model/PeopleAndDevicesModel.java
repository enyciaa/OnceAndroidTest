package com.once.android.testandroid.model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import com.once.android.testandroid.bus.BusProvider;
import com.once.android.testandroid.bus.GotListDataEvent;
import com.once.android.testandroid.bus.VariableEvent;
import com.once.android.testandroid.model.api.API;
import com.once.android.testandroid.model.pojo.Device;
import com.once.android.testandroid.model.pojo.Person;

import java.util.List;

/**
 * Places model
 */
public class PeopleAndDevicesModel {

    // Event bus to dispatch response results throughout the application
    private EventBus bus = BusProvider.INSTANCE.getBus();

    // Data
    private List<Person> people;
    private List<Device> devices;


    /**
     * Constructor
     */
    public PeopleAndDevicesModel() {
        bus.register(this);
    }


    /**
     * Get list of recommended places from Foursquare
     */
    public void getListData() {
        API api = new API();
        api.getListData();
    }


    @Subscribe
    public void onListDataReturned(GotListDataEvent.OnCompleted onCompleted) {
        setPeople((List<Person>) onCompleted.getResponse());
    }


    public List<Person> getPeople()    {
        return people;
    }


    public void setPeople(List<Person> people) {
        this.people = people;
        bus.post(new VariableEvent.OnPeopleUpdated());
    }

}
