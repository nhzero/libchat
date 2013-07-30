package com.example.libchat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.*;
import com.google.android.maps.GeoPoint;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.gesture.GesturePoint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;

public class MapActivity extends Activity {

	static final LatLng BOSTON = new LatLng(42.354,-71.0665);

	private GoogleMap mMap;
	private OnMapClickListener listener;
	
	@SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        if( getFragmentManager() != null){
        	mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        }
        if( mMap != null) {
        	Marker kiel = mMap.addMarker(new MarkerOptions().position(BOSTON) .title("boston").snippet("hometown"));
        	Drawable draw = this.getResources().getDrawable(R.drawable.ic_launcher);
        	MapOverlay mapOverlay = new MapOverlay(draw);
        	listener = new MapClickListener(mMap,mapOverlay);
       		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BOSTON, 15));
       		mMap.setOnMapClickListener(listener);
        }
    }
	


}
