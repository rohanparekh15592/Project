package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by rohan on 10-04-2016.
 */
public class RestaurantType extends Activity implements View.OnClickListener {

    ImageView back_button;
    TextView user_Detail;

    public static final String JSON_URL = "http://simplifiedcoding.16mb.com/UserRegistration/json.php";

    ImageView landing_page_lunch_imageView;
    ImageView landing_page_brunch_imageView;
    ImageView landing_page_dinner_imageView;


    private ListView listView;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.restaurant_type_landing_page);

        landing_page_brunch_imageView =  (ImageView) findViewById(R.id.landing_page_brunch_imageView);
        landing_page_lunch_imageView =  (ImageView) findViewById(R.id.landing_page_lunch_imageView);
        landing_page_dinner_imageView =  (ImageView) findViewById(R.id.landing_page_dinner_imageView);
        user_Detail = (TextView) findViewById(R.id.user_Detail);

        user_Detail.setOnClickListener(this);
        landing_page_brunch_imageView.setOnClickListener(this);
        landing_page_dinner_imageView.setOnClickListener(this);
        landing_page_lunch_imageView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v==user_Detail){
            Intent intent = new Intent(this, UserChanges.class);
            startActivity(intent);
        }
        if(v==landing_page_dinner_imageView){
            Intent i= new Intent(RestaurantType.this,RestaurantList.class);
            startActivity(i);
        }

    }
}
