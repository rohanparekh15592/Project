package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rohan on 18-04-2016.
 */
public class DishList extends Activity implements View.OnClickListener {
    ImageView back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);

        back_button = (ImageView) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        ListView listview = (ListView) findViewById(R.id.list_view);
        String[] values = new String[]{"Salmon", "California Hand Roll", "Beef Gyoza",
                "Dynamite Roll", "Spicy White Tuna", "Fried Chicken Cutlet", "Philadelphia roll", "Butterfly Coconut Shrimp",
                "Escargot", "Fillet Mignon"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.restaurant_row, values);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                //Toast.makeText(DishList.this, "List View row Clicked at" + position, Toast.LENGTH_SHORT).show();
                //final TextView dish_name= (TextView) view.findViewById(R.id.dish_name);
                String dishName = parent.getItemAtPosition(position).toString().trim();
                Log.i( "hi","" + dishName);
                Intent i = new Intent(DishList.this,Description.class);
                //String dish_name= ((TextView) view.findViewById(R.id.dish_name)).getText.getString();
                i.putExtra("dish_name", dishName);
                startActivity(i);

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(DishList.this,DishCategory.class);
        startActivity(i);
    }
}
