package com.once.android.testandroid.model;

import com.once.android.testandroid.bus.BusProvider;
import com.once.android.testandroid.bus.GotListDataEvent;
import com.once.android.testandroid.bus.VariableEvent;
import com.once.android.testandroid.model.api.API;
import com.once.android.testandroid.model.pojo.Item;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by guiguito on 6/6/2016.
 */
public class ItemModel {


    // Event bus to dispatch response results throughout the application		
    private EventBus bus = BusProvider.INSTANCE.getBus();

    // Data
    private List<Item> items;


    /**
     * Constructor
     */
    public ItemModel() {
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
        setItems((List<Item>) onCompleted.getResponse());
    }


    public List<Item> getItems() {
        return items;
    }


    public void setItems(List<Item> items) {
        this.items = items;
        bus.post(new VariableEvent.OnPeopleUpdated());
    }

}
