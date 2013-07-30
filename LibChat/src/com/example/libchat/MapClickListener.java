package com.example.libchat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.GeoPoint;

public class MapClickListener implements OnMapClickListener {

	private GoogleMap mMap;
	private MapOverlay mapOverlay;
	
	public MapClickListener(GoogleMap map, MapOverlay mapOverlay) {
		mMap = map;
		
		this.mapOverlay = mapOverlay;
	}
	
	@Override
	public void onMapClick(LatLng point) {
	
        if( mMap != null) {
        	Marker kiel = mMap.addMarker(new MarkerOptions().position(point) .title("clicked"));
		
        }
		
	}

}
