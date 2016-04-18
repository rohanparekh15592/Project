package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rohan on 14-04-2016.
 */
public class UserChanges extends Activity implements View.OnClickListener {

    TextView user_change_password;
    TextView user_delete_account;
    ImageView back_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.user_changes);

        user_change_password = (TextView) findViewById(R.id.user_change_password);
        user_delete_account = (TextView) findViewById(R.id.user_delete_account);
        back_button = (ImageView) findViewById(R.id.back_button);

        back_button.setOnClickListener(this);
        user_change_password.setOnClickListener(this);
        user_delete_account.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==user_change_password){
            Intent i= new Intent(this,ChangePassword.class);
            startActivity(i);
        }
        if(v==user_delete_account){
            Intent i= new Intent(this,DeleteAccount.class);
            startActivity(i);
        }
        if (v == back_button) {
            Intent intent = new Intent(this, RestaurantType.class);
            startActivity(intent);

        }
    }
}
