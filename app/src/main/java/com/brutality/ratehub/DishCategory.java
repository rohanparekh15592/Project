package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rohan on 10-04-2016.
 */
public class DishCategory extends Activity implements View.OnClickListener {
    ImageView back_button;
    TextView user_Detail;

    public static final String JSON_URL = "http://simplifiedcoding.16mb.com/UserRegistration/json.php";

    ImageView landing_page_mainCourse_imageView;
    ImageView landing_page_drinks_imageView;
    ImageView landing_page_desserts_imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.dish_category);

        landing_page_mainCourse_imageView =  (ImageView) findViewById(R.id.landing_page_mainCourse_imageView);
        landing_page_drinks_imageView =  (ImageView) findViewById(R.id.landing_page_drinks_imageView);
        landing_page_desserts_imageView =  (ImageView) findViewById(R.id.landing_page_desserts_imageView);

        landing_page_mainCourse_imageView.setOnClickListener(this);
        landing_page_drinks_imageView.setOnClickListener(this);
        landing_page_desserts_imageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==landing_page_mainCourse_imageView){
            Intent i= new Intent(DishCategory.this,DishList.class);
            startActivity(i);
        }
        if(v==landing_page_drinks_imageView){
            Intent i= new Intent(DishCategory.this,DishList.class);
            startActivity(i);
        }
        if(v==landing_page_desserts_imageView){
            Intent i= new Intent(DishCategory.this,DishList.class);
            startActivity(i);
        }
    }
}
