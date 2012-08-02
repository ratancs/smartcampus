package cc.co.ratan.www;

import java.text.DecimalFormat;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class Collegemap extends MapActivity implements LocationListener{
	private String provider;
	GeoPoint myLocation;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//String provider;
		
		setContentView(R.layout.collegemap);
		MapView mview =(MapView) findViewById(R.id.themap);
		
		mview.setBuiltInZoomControls(true); 
		Criteria criteria = new Criteria();
		
		final MapController control = mview.getController();
		
		
		LocationManager manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		Location location = manager.getLastKnownLocation(manager.NETWORK_PROVIDER);
		 if (location != null)
		        plotLocation(location);
		    else
		        manager.requestLocationUpdates(
		                manager.NETWORK_PROVIDER, 500L, 250.0f, (LocationListener) this);
			
		provider = manager.getBestProvider(criteria, false);
		
		LocationListener listner = new LocationListener() {
			
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Collegemap.this, "Enabled new provider " + provider,
						Toast.LENGTH_SHORT).show();
				
			}
			
			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(Collegemap.this, "Disabled provider " + provider,
						Toast.LENGTH_SHORT).show();
				
			}
			
			public void onLocationChanged(Location arg0) {
				// TODO Auto-generated method stub
				control.setCenter(new GeoPoint((int)arg0.getLatitude(), (int)arg0.getLongitude()));
			}
		};
				manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listner);
		
		;
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}
	double roundTwoDecimals(double d){
	    DecimalFormat twoDForm = new DecimalFormat("#.######");
	    return Double.valueOf(twoDForm.format(d));
}
	
public void plotLocation(Location location) {
		GeoPoint point = new GeoPoint(
				(int) (roundTwoDecimals(location.getLatitude()) * 1E6),
				(int) (roundTwoDecimals(location.getLongitude()) * 1E6));
		myLocation = point;
		MapView mview =(MapView) findViewById(R.id.themap);
		mview.getController().animateTo(point);
		mview.getController().setCenter(point);
		zoomToMyLocation();
}
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	private void zoomToMyLocation() {
		if (myLocation != null) {
			MapView mview =(MapView) findViewById(R.id.themap);
			mview.getController().setZoom(18);
			mview.getController().animateTo(myLocation);
		} 
	}
	
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}
