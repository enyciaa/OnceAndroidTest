package com.once.android.testandroid.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.once.android.testandroid.R;
import com.once.android.testandroid.model.ItemModel;
import com.once.android.testandroid.model.Session;
import com.once.android.testandroid.model.pojo.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter containing items.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.RecyclerViewHolder> {

    // Context
    private Context context;

    // Data set
    private List<Item> items;

    /**
     * Constructor
     */
    public ItemsAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Item item = items.get(position);
        if (item.getName() != null) {
            return R.layout.person_item;
        } else {
            return R.layout.device_item;
        }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(viewType, parent, false);
        return new RecyclerViewHolder(mView);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        Item item = items.get(position);
        if (item.getName() != null) {
            // You are a person
            // Add text
            ((TextView) holder.mView.findViewById(R.id.person_name)).setText(item.getName());
            String age = context.getString(R.string.main_age_label) + " " + String.valueOf(item.getAge());
            ((TextView) holder.mView.findViewById(R.id.person_age)).setText(age);

            // Load image
            Picasso.with(context)
                    .load(item.getPicture_url())
                    .placeholder(R.color.accent)
                    .into(((ImageView) holder.mView.findViewById(R.id.person_image)));

            // Click listener
            ((ImageButton) holder.mView.findViewById(R.id.person_delete_btn)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteItem(position);
                }
            });

        } else {
            //you are a device
            ((TextView) holder.mView.findViewById(R.id.device_heading)).setText(item.getDevice_name());
            ((TextView) holder.mView.findViewById(R.id.device_awesome_heading)).setText(item.getBrand());
            ((TextView) holder.mView.findViewById(R.id.device_awesome_rating)).setText("" + item.getAwesomeness());
        }
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    /**
     * Update data
     */
    public void updateDataSet(List<Item> mDataSet) {
        if (mDataSet == null)
            return;

        this.items = mDataSet;
        notifyDataSetChanged();
    }


    /**
     * Delete item
     */
    public void deleteItem(int position) {
        this.items.remove(position);

        // Save data
        ItemModel itemModel = Session.INSTANCE.getItemModel();
        itemModel.saveItemsLocally(items);

        notifyItemRemoved(position);
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        protected View mView;

        public RecyclerViewHolder(View v) {
            super(v);
            this.mView = v;
        }
    }

}
