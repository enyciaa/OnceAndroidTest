package com.once.android.testandroid.model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.once.android.testandroid.bus.BusProvider;
import com.once.android.testandroid.bus.GotListDataEvent;
import com.once.android.testandroid.bus.VariableEvent;
import com.once.android.testandroid.model.api.API;
import com.once.android.testandroid.model.pojo.Item;
import com.pixplicity.easyprefs.library.Prefs;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Created by guiguito on 6/6/2016.
 */
public class ItemModel {

    private static final String ARG_SP_ITEMS = "shared_preference_items_key";

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


    public void getListData() {
        String json = Prefs.getString(ARG_SP_ITEMS, null);
        if (json == null) {
            refreshListDataFromNetwork();
        }
        else {
            loadItemsLocally();
        }
    }


    public void refreshListDataFromNetwork() {
        API api = new API();
        api.getListData();
    }


    public void loadItemsLocally() {
        String json = Prefs.getString(ARG_SP_ITEMS, null);
        if (json != null) {
            Gson gson = new Gson();
            Type collectionType = new TypeToken<Collection<Item>>() {
            }.getType();
            List<Item> items = gson.fromJson(json, collectionType);
            setItems(items);
        }
    }


    public void saveItemsLocally(List<Item> items) {
        Gson gson = new Gson();
        String json = gson.toJson(items);
        Prefs.putString(ARG_SP_ITEMS, json);
    }


    @Subscribe
    public void onItemsReturned(GotListDataEvent.OnCompleted onCompleted) {
        List<Item> items = onCompleted.getResponse();
        saveItemsLocally(items);
        setItems(items);
    }


    public List<Item> getItems() {
        return items;
    }


    public void setItems(List<Item> items) {
        this.items = items;
        bus.post(new VariableEvent.OnPeopleUpdated());
    }

}
