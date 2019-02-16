package marmiss.aleksejs.hochschuleapp;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class CampusActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private GoogleApiClient googleApiClient;

    private double latitude;
    private double longitude;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView5);
        imageView3 = findViewById(R.id.imageView4);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + latitude + "," + longitude + "&daddr=" + "48.4089826,9.9981483"));
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + latitude + "," + longitude + "&daddr=" + "48.422293,10.006292"));
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=" + latitude + "," + longitude + "&daddr=" + "48.418354,9.939439"));
                startActivity(intent);
            }
        });

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    protected void onPause(){
        super.onPause();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d("WhereAmI", "Connection estabileshed");
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if(lastLocation!=null){
            latitude = lastLocation.getLatitude();
            longitude =  lastLocation.getLongitude();
        }else{
            Log.d("WhereAmI", "No last location");
        }

    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d("WhereAmI", "Connection Suspended" );
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d("WhereAmI", "Connection Failed" );
    }

}
