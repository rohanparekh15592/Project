package com.brutality.ratehub;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rohan on 30-03-2016.
 */
public class RegisterNewUser extends Activity {

    // all views initialized
    EditText first_name_register_editText;
    EditText last_name_register_editText;
    EditText email_id_register_editText;
    EditText password_register_editText;
    EditText confirm_password_register_editText;
    TextView register_textView;
    ImageView back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registrationform_activity);

        //all views asigned to their respective id
        first_name_register_editText = (EditText) findViewById(R.id.first_name_register_editText);
        last_name_register_editText = (EditText) findViewById(R.id.last_name_register_editText);
        email_id_register_editText = (EditText) findViewById(R.id.email_id_register_editText);
        password_register_editText = (EditText) findViewById(R.id.password_register_editText);
        confirm_password_register_editText = (EditText) findViewById(R.id.confirm_password_register_editText);
        register_textView = (TextView) findViewById(R.id.register_textView);
        back_button = (ImageView) findViewById(R.id.back_button);
    }
}
