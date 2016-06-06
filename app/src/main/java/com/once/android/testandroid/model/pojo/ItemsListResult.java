package com.once.android.testandroid.model.pojo;

import java.util.List;

/**
 * Created by guiguito on 6/6/2016.
 */
public class ItemsListResult {

    List<Item> array;

    public List<Item> getArray() {
        return array;
    }

    public void setArray(List<Item> array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ItemsListResult{" +
                "array=" + array +
                '}';
    }

}
