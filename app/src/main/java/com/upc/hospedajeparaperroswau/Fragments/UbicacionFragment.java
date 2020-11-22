package com.upc.hospedajeparaperroswau.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upc.hospedajeparaperroswau.R;


public class UbicacionFragment extends Fragment  implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;


    public UbicacionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_ubicacion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment=(SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;


        LatLng local1 = new LatLng(-11.964063990021419,-76.98621103540063);
        LatLng local2 = new LatLng(-11.967587111538776,-76.99199203401804);
        LatLng local3 = new LatLng(-11.95602525488702,-76.99207417666912);
        float zoom = 15;

        Marker mlocal1;
        Marker mlocal2;
        Marker mlocal3;

        mlocal1 = mGoogleMap.addMarker(new MarkerOptions()
                .position(local1)
                .title("Hotel Wau").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_dog_32)));

        mlocal1.setTag(0);

        mlocal2 = mGoogleMap.addMarker(new MarkerOptions()
                .position(local2)
                .title("Hotel Wau 2").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_dog_32)));
        mlocal2.setTag(0);

        mlocal3 = mGoogleMap.addMarker(new MarkerOptions()
                .position(local3)
                .title("Hotel Wau 3").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_dog_32)));

        mlocal3.setTag(0);

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local3,zoom));




    }
}