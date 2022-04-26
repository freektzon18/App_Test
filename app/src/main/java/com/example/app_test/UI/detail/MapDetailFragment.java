package com.example.app_test.UI.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app_test.R;
import com.example.app_test.data.response.Businesses;
import com.example.app_test.data.utils.AppContext;
import com.example.app_test.data.viewmodel.ViewModel;
import com.example.app_test.databinding.FragmentListToBusinessBinding;
import com.example.app_test.databinding.FragmentMapDetailBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;


public class MapDetailFragment extends Fragment implements OnMapReadyCallback {

    private FragmentMapDetailBinding binding;
    private ViewModel viewModel;
    private Businesses itemBusinesses;
    private GoogleMap map;
    public MapDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().setTitle(getString(R.string.detalle));
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
        itemBusinesses = MapDetailFragmentArgs.fromBundle(getArguments()).getBusinesses();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("imprimimos","businesses"+itemBusinesses);
        binding.setBusinesses(itemBusinesses);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Log.e("entra","aqui");
        map = googleMap;
        LatLng myPos = new LatLng(itemBusinesses.getLatitud(),itemBusinesses.getLongitud());
        LatLng pos= new LatLng(itemBusinesses.getCoordinates().getLatitude(),itemBusinesses.getCoordinates().getLongitude());
        map.addMarker(new MarkerOptions().position(pos).title(itemBusinesses.getName()));
        map.addMarker(new MarkerOptions().position(myPos).title(AppContext.getMyApplicationContext().getString(R.string.miubicacion)));
        map.moveCamera(CameraUpdateFactory.newLatLng(pos));
    }
}