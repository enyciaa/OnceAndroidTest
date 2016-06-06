package com.once.android.testandroid.bus;

import org.greenrobot.eventbus.EventBus;

/**
 * This provides access to the EventBus
 */
public enum BusProvider {
    INSTANCE;

    private final EventBus bus = EventBus.getDefault();


    public EventBus getBus() {
        return bus;
    }
}
