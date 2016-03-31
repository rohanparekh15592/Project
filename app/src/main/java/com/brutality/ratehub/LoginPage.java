package com.brutality.ratehub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

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

        welcomePage_register_textView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, RegisterNewUser.class);
        startActivity(intent);
        finish();

    }
}
