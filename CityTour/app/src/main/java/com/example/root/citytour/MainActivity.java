package com.example.root.citytour;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 3/19/15.
 */
public class MainActivity extends ActionBarActivity implements OnClickListener{
    Button item1, item2, item3, item4;
    String place = new String();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Intent intent =new Intent (MainActivity.this, MainActivity.class) ;
        intent.putExtra ("id", id) ;
        startActivity(intent);
        */

        item1 = (Button) findViewById(R.id.shinchon);
        item2 = (Button) findViewById(R.id.namdaemun);
        item3 = (Button) findViewById(R.id.dongdaemun);
        item4 = (Button) findViewById(R.id.insadong);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        Double x = 0.0, y = 0.0;
        switch (v.getId()) {
            case R.id.shinchon:
                place = "shinchon";
                intent.putExtra("place", place);
                x = 37.555161;
                y = 126.936929;
                break;
            case R.id.namdaemun:
                place = "namdaemun";
                intent.putExtra("place", place);
                x = 37.559438;
                y = 126.977310;
                break;
            case R.id.dongdaemun:
                place = "dongdaemun";
                intent.putExtra("place", place);
                x = 37.570988;
                y = 127.009676;
                break;
            case R.id.insadong:
                place = "insadong";
                intent.putExtra("place", place);
                x = 37.572961;
                y = 126.986247;
                break;
            default:
                break;
        }
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        startActivity(intent);
    }
}
