package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rohan on 18-04-2016.
 */
public class Description extends Activity implements View.OnClickListener {
    TextView description;
    RatingBar ratingBar;
    private String dishName;


    public static final String KEY_Dish = "dishName";

    public static final String LOGIN_URL = "http://192.168.0.222:8084/RateHub/DishMasterViewController";
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.description);



        back = (ImageView) findViewById(R.id.back_button);
        back.setOnClickListener(this);
        Intent i= getIntent();
        dishName=i.getStringExtra("dish_name");
        description = (TextView) findViewById(R.id.description);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String desc = null;
                        String rat = null;

                        try {
                            JSONObject json = new JSONObject(response);
                            Log.d("log",json.toString());
                            desc = json.getString("desc");

                            rat = json.getString("rating");
                            System.out.println(rat);
                            //System.out.println(s);
                        } catch (Throwable t) {

                        }


                        if (desc != null && rat !=null) {
                            description.setText(desc);
                            ratingBar.setRating(Float.parseFloat(rat));
                        } else {
                            Toast.makeText(Description.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Description.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_Dish, dishName);
                return map;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent(Description.this,DishList.class);
        startActivity(i);

    }
    }
