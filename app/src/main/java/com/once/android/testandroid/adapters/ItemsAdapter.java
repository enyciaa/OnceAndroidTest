package com.once.android.testandroid.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter containing items.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private final Context mContext;
    private List<String> mItems;

    public ItemsAdapter(Context context) {
        mContext = context.getApplicationContext();
        mItems = new ArrayList<>();
        mItems.add("Test 1");
        mItems.add("Test 2");
        mItems.add("Test 3");
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((TextView) holder.mItemView).setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
        }

    }

}
