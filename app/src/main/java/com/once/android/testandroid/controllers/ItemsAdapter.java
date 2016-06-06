package com.once.android.testandroid.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.once.android.testandroid.R;
import com.once.android.testandroid.model.pojo.Person;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Adapter containing items.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.RecyclerViewHolder> {

    // Context
    private Context context;

    // Data set
    private List<Person> people;

    // Item layout
    private int itemLayout;


    /**
     * Constructor
     */
    public ItemsAdapter(Context context, List<Person> people, int itemLayout) {
        this.context = context;
        this.people = people;
        this.itemLayout = itemLayout;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(itemLayout, parent, false);

        return new RecyclerViewHolder(mView);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Person person = people.get(position);

        // Add text
        holder.personName.setText(person.getNames());
        String age = context.getString(R.string.main_age_label) + " " + String.valueOf(person.getAge());
        holder.personAge.setText(age);

        // Load image
        Picasso.with(context)
                .load(person.getPicture_url())
                .placeholder(R.color.accent)
                .into(holder.personImage);

    }


    @Override
    public int getItemCount() {
        return people.size();
    }


    /**
     * Update data
     */
    public void updateDataSet(List<Person> mDataSet) {
        if (mDataSet == null)
            return;

        this.people = mDataSet;
        notifyDataSetChanged();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        protected View mView;
        @Bind(R.id.person_image) ImageView personImage;
        @Bind(R.id.person_name) TextView personName;
        @Bind(R.id.person_age) TextView personAge;

        public RecyclerViewHolder(View v) {
            super(v);
            this.mView = v;
            ButterKnife.bind(this, v);
        }
    }

}
