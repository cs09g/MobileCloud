package com.example.root.citytour;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by root on 3/19/15.
 */
public class MainActivity extends ActionBarActivity implements OnClickListener{
    Button item1, item2, item3, item4;

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
    public void onClick(View v){
        Intent intent =new Intent (MainActivity.this, MapsActivity.class) ;
        Double x=0.0, y=0.0;
        switch(v.getId()){
            case R.id.shinchon:
                intent.putExtra("place", "shinchon");
                x = 37.555161; y = 126.936929;
                break;
            case R.id.namdaemun:
                intent.putExtra("place", "namdaemun");
                x = 37.559438; y = 126.977310;
                break;
            case R.id.dongdaemun:
                intent.putExtra("place", "dongdaemun");
                x = 37.570988; y = 127.009676;
                break;
            case R.id.insadong:
                intent.putExtra("place", "insadong");
                x = 37.572961; y = 126.986247;
                break;
            default:
                break;
        }
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        startActivity(intent);
    }
}
