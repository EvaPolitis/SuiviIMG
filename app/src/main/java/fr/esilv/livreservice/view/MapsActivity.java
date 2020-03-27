package fr.esilv.livreservice.view;

import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Connection;

import fr.esilv.livreservice.R;
import fr.esilv.livreservice.controller.getNearPlaces;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    private static final int ERROR_DIALOG_REQUEST=9001;
    private int PROXIMITY_RADIUS=10000;
    double lat,lng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_maps);

        if(isServiceOK()){
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            /*
            mMap.clear();
            String uRL= getUrl(48.9190286,2.1380955,"gym");
            Object dataTransfert[]= new Object[2];
            dataTransfert[0]=mMap;
            dataTransfert[1]=uRL;

            getNearPlaces getNearPlaces =new getNearPlaces();
            getNearPlaces.execute(dataTransfert);*/



        }
/*
        private String getUrl(double lat, double lng, String p){
            StringBuilder googlePlaceUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json/");
            googlePlaceUrl.append("location"+lat+","+lng);
            googlePlaceUrl.append("&radius=",PROXIMITY_RADIUS);
            googlePlaceUrl.append("&types="+p );
            googlePlaceUrl.append("&sensor=true");
            googlePlaceUrl.append("&key=true");

        }*/
        /*
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        */
    }

    public boolean isServiceOK(){
        int avalaible = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MapsActivity.this);
        if(avalaible== ConnectionResult.SUCCESS){
            System.out.println("ok");
            return true;
        }
        else{
            System.out.println("error");
            Dialog d=GoogleApiAvailability.getInstance().getErrorDialog(MapsActivity.this,avalaible,ERROR_DIALOG_REQUEST);
            d.show();

        }
        return false;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng montesson = new LatLng(48.9190286,2.1380955);
        mMap.addMarker(new MarkerOptions().position(montesson).title("Marker in Montesson"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(montesson));
    }
}
