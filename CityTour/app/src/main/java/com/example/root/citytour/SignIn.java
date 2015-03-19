package com.example.root.citytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by root on 3/19/15.
 */
public class SignIn extends ActionBarActivity implements View.OnClickListener {
    Button confirm;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        confirm = (Button) findViewById(R.id.signin);

        confirm.setOnClickListener(this);
        /* practice */
        /*
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
    }

    @Override
    public void onClick(View v) {
        EditText id, pw;

        id = (EditText) findViewById(R.id.userId);
        pw = (EditText) findViewById(R.id.password);

        if(id.getText().toString().trim().length() != 0 && pw.getText().toString().trim().length() != 0){
            /* need to check if it's valid account *
             * add here
             *
             *
             ***************************************/

            Intent intent = new Intent(SignIn.this, MainActivity.class);
            intent.putExtra("id", id.getText().toString());
            intent.putExtra("pw", pw.getText().toString());
            startActivity(intent);
        }
    }
}
