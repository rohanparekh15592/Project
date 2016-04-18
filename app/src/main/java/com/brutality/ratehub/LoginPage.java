package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
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
 * Created by rohan on 30-03-2016.
 */
public class LoginPage extends Activity implements View.OnClickListener {

    // all views initialized
    EditText welcomePage_email_editText;
    EditText welcomePage_password_editText;
    TextView welcomePage_signIn_textView;
    TextView welcomePage_cancel_textView;
    TextView welcomePage_register_textView;
    TextView welcomePage_skip_textView;

    public static final String LOGIN_URL = "http://192.168.0.222:8084/RateHub/LogInServlet";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);

        //all views asigned to their respective id
        welcomePage_email_editText = (EditText) findViewById(R.id.welcomePage_email_editText);
        welcomePage_password_editText = (EditText) findViewById(R.id.welcomePage_password_editText);
        welcomePage_signIn_textView = (TextView) findViewById(R.id.welcomePage_signIn_textView);
        welcomePage_cancel_textView = (TextView) findViewById(R.id.welcomePage_cancel_textView);
        welcomePage_register_textView = (TextView) findViewById(R.id.welcomePage_register_textView);
        welcomePage_skip_textView = (TextView) findViewById(R.id.welcomePage_skip_textView);

        welcomePage_signIn_textView.setOnClickListener(this);

        welcomePage_skip_textView.setOnClickListener(this);
        welcomePage_register_textView.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if (v == welcomePage_register_textView) {

                Intent intent = new Intent(this, RegisterNewUser.class);
                startActivity(intent);
                finish();

        }

        if (v == welcomePage_signIn_textView) {
            if (welcomePage_email_editText.getText().toString().length() == 0) {
                welcomePage_email_editText.setError("Email id is required!");
            } else if (welcomePage_password_editText.getText().toString().length() == 0) {
                welcomePage_password_editText.setError("Password is required!");
            }else if( welcomePage_email_editText.getText().toString().length() == 0 && welcomePage_password_editText.getText().toString().length()==0 ) {
                welcomePage_email_editText.setError("Email id is required & password required");
            }else {
                userLogin();
            }
        }

        if (v == welcomePage_skip_textView) {
            Intent intent = new Intent(this, RestaurantType.class);
            startActivity(intent);

        }


    }

    private void userLogin() {
        username = welcomePage_email_editText.getText().toString().trim();
        password = welcomePage_password_editText.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
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
                            Toast.makeText(LoginPage.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginPage.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(KEY_USERNAME, username);
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
