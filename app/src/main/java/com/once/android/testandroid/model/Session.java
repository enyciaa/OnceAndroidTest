package com.once.android.testandroid.model;

/**
 * Holds all the models
 * This ensures they are kept in memory even if the activity that uses them is finished
 * Which network calls can continue to return responses
 * And network calls don't need re-made each time an activity is re-created
 */
public enum Session {
    INSTANCE;

    // Models
    private ItemModel itemModel;


    public ItemModel getItemModel() {
        if (itemModel == null) {
            itemModel = new ItemModel();
        }
        return itemModel;
    }

}
