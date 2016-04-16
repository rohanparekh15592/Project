package com.brutality.ratehub;

import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by Belal on 9/22/2015.
 */

public class CustomList extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Restaurant> movieItems;
    public CustomList(Activity activity, List<Restaurant> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }


    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int position) {
        return movieItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.restaurant_row, null);


        TextView rating = (TextView) convertView.findViewById(R.id.restaurant_name);


        // getting movie data for the row
        Restaurant m = movieItems.get(position);


        // rating
        rating.setText(String.valueOf(m.getRest()));

        return convertView;
    }

}