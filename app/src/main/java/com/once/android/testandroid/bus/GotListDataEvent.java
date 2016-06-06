package com.once.android.testandroid.bus;

import com.once.android.testandroid.model.pojo.Item;
import com.once.android.testandroid.model.pojo.Person;

import java.util.List;

/**
 * The api call to check whether the user is logged in has returned a response
 */
public class GotListDataEvent extends BaseNetworkEvent {

    public static final Error FAILED = new OnError(UNHANDLED_CODE, UNHANDLED_MSG);


    public static class OnCompleted extends Completed<List<Item>> {
        public OnCompleted(List<Item> result) {
            super(result);
        }
    }


    public static class OnError extends Error {
        public OnError(int code, String errorMessage) {
            super(code, errorMessage);
        }
    }

}
