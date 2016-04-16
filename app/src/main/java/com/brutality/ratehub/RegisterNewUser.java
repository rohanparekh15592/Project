package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
public class RegisterNewUser extends Activity implements View.OnClickListener {

    // all views initialized
    EditText first_name_register_editText;
    EditText last_name_register_editText;
    EditText email_id_register_editText;
    EditText password_register_editText;
    EditText confirm_password_register_editText;
    TextView register_textView;
    ImageView back_button;
    String fName= null;
    private static final String REGISTER_URL = "http://192.168.0.39:8084/RateHub/UserInsertController";

    public static final String KEY_FIRST_NAME = "first_name";
    public static final String KEY_LAST_NAME = "last_name";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registrationform_activity);

        //all views assigned to their respective id
        first_name_register_editText = (EditText) findViewById(R.id.first_name_register_editText);
        last_name_register_editText = (EditText) findViewById(R.id.last_name_register_editText);
        email_id_register_editText = (EditText) findViewById(R.id.email_id_register_editText);
        password_register_editText = (EditText) findViewById(R.id.password_register_editText);
        confirm_password_register_editText = (EditText) findViewById(R.id.confirm_password_register_editText);
        register_textView = (TextView) findViewById(R.id.register_textView);
        back_button = (ImageView) findViewById(R.id.back_button);


        register_textView.setOnClickListener(this);
        back_button.setOnClickListener(this);
    }

        private void registerUser(){
            final String first_name = first_name_register_editText.getText().toString().trim();
            final String last_name = last_name_register_editText.getText().toString().trim();
            final String email = email_id_register_editText.getText().toString().trim();
            final String password = password_register_editText.getText().toString().trim();




            StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            String s = null;


                            try {
                                JSONObject json = new JSONObject(response);
                                s = json.getString("Info");
                                fName = json.getString("First_Name");
                                System.out.println(s);
                            } catch (Throwable t) {

                            }


                            if (s.equals("Success")) {
                                openProfile();
                            } else {
                                Toast.makeText(RegisterNewUser.this, response, Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(RegisterNewUser.this,error.toString(),Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                    params.put(KEY_FIRST_NAME,first_name);
                    params.put(KEY_LAST_NAME,last_name);
                    params.put(KEY_EMAIL,email);
                    params.put(KEY_PASSWORD, password);
                    return params;
                }

            };

            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }

    @Override
    public void onClick(View v) {
        if(v==register_textView){
            if (first_name_register_editText.getText().toString().length() == 0) {
                first_name_register_editText.setError("First Name id is required!");
            } else if (last_name_register_editText.getText().toString().length() == 0) {
                last_name_register_editText.setError("Last Name is required!");
            }else if( email_id_register_editText.getText().toString().length() == 0 ) {
                email_id_register_editText.setError("Email id is required");
            }else if( password_register_editText.getText().toString().length() == 0 ) {
                password_register_editText.setError("Password id is required");
            }else if( confirm_password_register_editText.getText().toString().length() == 0 ) {
                confirm_password_register_editText.setError("Password id is required");
            }else {
                registerUser();
            }
        }
        if(v==back_button){
            Intent intent = new Intent(this, RestaurantType.class);
            startActivity(intent);
        }
}
    private void openProfile(){
        Intent intent = new Intent(this, RestaurantType.class);
        intent.putExtra("first_name",fName);
        startActivity(intent);
    }
}
