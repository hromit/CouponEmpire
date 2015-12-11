package com.offers.couponempire.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.offers.couponempire.R;

/**
 * Created by piro on 30/7/15.
 */
public class MapActivity extends BaseActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback{

    GoogleMap googleMap1;
/*
    GeoFencerPolygon geoFencerPolygon;
*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        if (isFinishing()) {
            return;
        }*/
        // Typeface typeface = Typeface.createFromAsset(getAssets(), "Roboto-Regular.ttf");


        setContentView(R.layout.map_activity);

        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.ID);
        mf.getMapAsync(this);
    }
        public void geoFencing()
        {
            Geofence.Builder gf = new Geofence.Builder();

            gf.setCircularRegion(82.22, 23.22,344);
            Geofence newGF = gf.build();

        }


        @Override
        protected void onResume() {
            super.onResume();
            //invalidateOptionsMenu();
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {


            googleMap1=googleMap;
            //   googleMap1.setOnMapLoadedCallback(this);
            setUpMap();
        }


        @Override
    protected int getSelfNavDrawerItem() {
        return NAVDRAWER_ITEM_NATIVE_CARDSLIB;
    }

    @Override
    public void onMapLoaded() {

        googleMap1.setMyLocationEnabled(true);
    }



    private void setUpMap() {
        //  mMap.addMarker(new MarkerOptions().position(new LatLng(26.753768, 75.856819)).title("Marker"));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(28.635308, 77.224960))      // Sets the center of the map to Mountain View
                .zoom(10)                   // Sets the zoom
                .bearing(90)                // Sets the orientation of the camera to east
                .tilt(30)                   // Sets the tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        googleMap1.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        //mMap.animateCamera(CameraUpdateFactory.zoomTo(6), 1000, null);

     /*   geoFencerPolygon = new GeoFencerPolygon();
        geoFencerPolygon.drawPolygonOnMap(googleMap1);

        setClickListen();*/
       BitmapDescriptor marCol = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN) ;

        googleMap1.addMarker(new MarkerOptions().position(new LatLng(28.635308, 77.224960)).title("Sarita Vihar").icon(marCol));
    }

    public void setClickListen()
    {

       /* googleMap1.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Boolean isInside = geoFencerPolygon.isPointInPolygon(latLng);
                String msg = "";
                BitmapDescriptor marCol = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED) ;
                if(isInside)
                {
                    marCol = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN) ;
                    msg = "INSIDE";
                }
                else
                    msg = "OUTSIDE";

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Log.d("MapsPoly", latLng.toString() + " is " + msg);
                googleMap1.addMarker(new MarkerOptions().position(latLng).title(msg).icon(marCol));
            }
        });
*/
       /* googleMap1.setOnMapClickListener(new GoogleMap().OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Boolean isInside = geoFencerPolygon.isPointInPolygon(latLng);
                String msg = "";
                BitmapDescriptor marCol = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED) ;
                if(isInside)
                {
                    marCol = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN) ;
                    msg = "INSIDE";
                }
                else
                    msg = "OUTSIDE";

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                Log.d("MapsPoly", latLng.toString() + " is " + msg);
                googleMap1.addMarker(new MarkerOptions().position(latLng).title(msg).icon(marCol));
            }
        });*/
    }


}
