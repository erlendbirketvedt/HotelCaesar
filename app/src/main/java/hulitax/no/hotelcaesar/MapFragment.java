package hulitax.no.hotelcaesar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class MapFragment extends android.support.v4.app.Fragment implements OnMapReadyCallback {

    private GoogleMap map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_map_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        super.onCreate(savedInstance);
        SupportMapFragment smf = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        smf.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng Skotbu = new LatLng(59.6641, 10.9474);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Skotbu, 10));
    }
}