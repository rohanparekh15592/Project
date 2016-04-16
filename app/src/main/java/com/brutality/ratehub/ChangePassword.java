package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
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
 * Created by rohan on 14-04-2016.
 */
public class ChangePassword extends Activity implements View.OnClickListener {

    TextView user_email;
    TextView user_password;
    TextView user_reenter_password;
    TextView user_change_password;
    ImageView back_button;
    String email, password,confirmPassword;
    private static final String PASSWORD_URL = "http://192.168.0.39:8084/RateHub/UserInsertController";
    public static final String KEY_EMAIL = "email_id";
    public static final String KEY_PASSWORD = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.change_password);

        user_change_password = (TextView) findViewById(R.id.user_change_password);
        user_email = (TextView) findViewById(R.id.user_email);
        user_password = (TextView) findViewById(R.id.user_password);
        user_reenter_password = (TextView) findViewById(R.id.user_reenter_password);
        back_button = (ImageView) findViewById(R.id.back_button);

        back_button.setOnClickListener(this);
        user_change_password.setOnClickListener(this);


}

    @Override
    public void onClick(View v) {
        if (v == user_change_password) {
            if( user_email.getText().toString().length() == 0 ) {
                user_email.setError("Email id is required");
            }else if( user_password.getText().toString().length() == 0 ) {
                user_password.setError("Email id is required");}else
            changePassword();
        }
        if (v == back_button) {
            Intent intent = new Intent(this, UserChanges.class);
            startActivity(intent);

        }
    }
    private void changePassword() {
        email = user_email.getText().toString().trim();
        password = user_password.getText().toString().trim();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, PASSWORD_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        String s = null;

                        try {
                            JSONObject json = new JSONObject(response);
                            s = json.getString("Info");
                            System.out.println(s);
                        } catch (Throwable t) {

                        }


                        if (s.equals("Success")) {
                            openProfile();
                        } else {
                            Toast.makeText(ChangePassword.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ChangePassword.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_EMAIL, email);
                map.put(KEY_PASSWORD, password);
                return map;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile() {
        Intent intent = new Intent(this, RestaurantType.class);
        startActivity(intent);
    }
}
