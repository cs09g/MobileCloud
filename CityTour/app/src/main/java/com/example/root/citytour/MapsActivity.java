package com.example.root.citytour;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    TextView placename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        setUpMapIfNeeded();
        mMap.setMyLocationEnabled(true);

        Button inform = (Button) findViewById(R.id.inform);
        Button mapit = (Button) findViewById(R.id.mapit);

        placename = (TextView) findViewById(R.id.placename);

        String place = getIntent().getStringExtra("place");

        if(place.equals("shinchon")){
            placename.setText("shinchon");
        }
        else if(place.equals("namdaemun")){
            placename.setText("namdaemun");
        }
        else if(place.equals("dongdaemun")){
            placename.setText("dongdaemun");
        }
        else if(place.equals("insadong")){
            placename.setText("shinchon");
        }
        mapit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mMap.clear();
                String place = getIntent().getStringExtra("place");
                Double x = getIntent().getDoubleExtra("x", 0);
                Double y = getIntent().getDoubleExtra("y", 0);
                mMap.addMarker(new MarkerOptions().position(new LatLng(x, y)).title(place));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(x, y), 17));
            }
        });
        inform.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String place = getIntent().getStringExtra("place");
                String Url="";
                if(place.equals("shinchon")){
                    Url = "http://english.visitkorea.or.kr/enu/SI/SI_EN_3_6.jsp?cid=256043";
                }
                else if(place.equals("namdaemun")){
                    Url = "http://www.namdaemunmarket.co.kr/english/";
                }
                else if(place.equals("dongdaemun")){
                    Url = "http://english.visitkorea.or.kr/enu/SH/whereToShop/whereToShop.jsp?action=about&cid=995824";
                }
                else if(place.equals("insadong")){
                    Url = "https://english.visitkorea.or.kr:1001/enu/SI/SI_EN_3_1_1_1.jsp?cid=264354";
                }
                Uri uriUrl = Uri.parse(Url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        CameraUpdate point = CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 14);
        mMap.animateCamera(point);
    }
}
