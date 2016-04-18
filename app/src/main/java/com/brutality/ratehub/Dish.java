package com.brutality.ratehub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by rohan on 18-04-2016.
 */
public class Dish extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public Dish(Context context, String[] values) {
        super(context, R.layout.restaurant_row, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.restaurant_row, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.restaurant_name);
        textView.setText(values[position]);

        return rowView;
    }
}
