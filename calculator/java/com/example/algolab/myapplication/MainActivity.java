package com.example.algolab.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnClickListener {

    EditText etNum1, etNum2;
    Button add, sub, mul, div;
    TextView res;
    String op = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.num1);
        etNum2 = (EditText) findViewById(R.id.num2);

        add = (Button) findViewById(R.id.plusButton);
        sub = (Button) findViewById(R.id.minusButton);
        mul = (Button) findViewById(R.id.multiplyButton);
        div = (Button) findViewById(R.id.divisionButton);
        res = (TextView) findViewById(R.id.result);

        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);
        res.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        float num1, num2, result=0;


        try {
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());

            switch (v.getId()) {
                case R.id.plusButton:
                    op = "+";
                    result = num1 + num2;
                    break;
                case R.id.minusButton:
                    op = "-";
                    result = num1 - num2;
                    break;
                case R.id.multiplyButton:
                    op = "*";
                    result = num1 * num2;
                    break;
                case R.id.divisionButton:
                    op = "/";
                    result = num1 / num2;
                    break;
                default:
                    break;
            }

            res.setText(num1 + " " + op + " " + num2 + "=" + result);
        }
        catch(Exception e){

        }
    }

}
