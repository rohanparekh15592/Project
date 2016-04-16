package com.brutality.ratehub;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by rohan on 10-04-2016.
 */
public class DishCategory extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.dish_category);
    }
}
