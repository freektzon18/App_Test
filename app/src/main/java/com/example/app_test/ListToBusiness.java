package com.example.app_test;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.app_test.UI.searchActivity.view.MainActivity;
import com.example.app_test.UI.searchActivity.view.adapter.AdapterListBusinesses;
import com.example.app_test.UI.searchActivity.view.adapter.Listener;
import com.example.app_test.data.response.Businesses;
import com.example.app_test.data.utils.AppContext;
import com.example.app_test.data.viewmodel.ViewModel;
import com.example.app_test.databinding.FragmentListToBusinessBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListToBusiness extends Fragment implements SearchView.OnQueryTextListener, Listener {

    public static final int PERMISSION_REQUEST_UBICACION = 2;

    private FragmentListToBusinessBinding binding;
    ViewModel viewModel;
    private String search;
    private String latitude;
    private String longitude;
    private List<Businesses> businessesArrayList;
    private AdapterListBusinesses adapter;
    private NavController navController ;
    private MutableLiveData<Businesses> itemBusinesses;

    public ListToBusiness() {
        this.itemBusinesses = new MutableLiveData<>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().setTitle(getString(R.string.businesses));
        viewModel = new ViewModelProvider(this).get(ViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentListToBusinessBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        setUpEvents();
    }

    private void setUpEvents() {
        binding.searchView.setOnQueryTextListener(this);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                InputMethodManager keyboard = (InputMethodManager) getActivity().getSystemService
                        (Context.INPUT_METHOD_SERVICE); keyboard.hideSoftInputFromWindow(binding.searchView.getWindowToken(), 0);
                businessesArrayList = new ArrayList<>();
                if (ActivityCompat.checkSelfPermission(AppContext.getMyApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getUbicacion();
                    if (search == null || search.isEmpty()){
                        Toast.makeText(AppContext.getMyApplicationContext(),"no hay nada que buscar",Toast.LENGTH_SHORT).show();
                    }else {
                        viewModel.searchBusinesses(search,latitude,longitude);
                        binding.progressCircular.setVisibility(View.VISIBLE);
                    }
                }else{
                    requestUbicacionPermission();
                }
            }
        });
        setListAdapter();
    }

    private void requestUbicacionPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
            Snackbar.make(binding.constraint, "Se necesitan permisos de ubicacion, para continuar con el flujo", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_UBICACION);
                }
            }).show();
        }else{
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_UBICACION);
        }
    }

    private void getUbicacion(){
        LocationManager lm = (LocationManager)requireActivity().getSystemService(Context.LOCATION_SERVICE);
        @SuppressLint("MissingPermission") Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        longitude = String.valueOf(location.getLongitude());
        latitude = String.valueOf(location.getLatitude());
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        search = s;
        return true;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onTVShowCLicked(Businesses businesses) {
        businesses.setLatitud(Double.parseDouble(latitude));
        businesses.setLongitud(Double.parseDouble(longitude));
        ListToBusinessDirections.ActionListToBusinessToMapDetailFragment action =
                ListToBusinessDirections.actionListToBusinessToMapDetailFragment(businesses);
        action.setBusinesses(businesses);
        Navigation.findNavController(requireView()).navigate(action);
    }

    private void setListAdapter(){
        viewModel.getBussines().observe(getViewLifecycleOwner(), new Observer<List<Businesses>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<Businesses> businesses) {
                if (businesses != null && !businesses.isEmpty() ){
                    businessesArrayList.addAll(businesses);
                    adapter = new AdapterListBusinesses(businessesArrayList,ListToBusiness.this);
                    adapter.notifyDataSetChanged();
                    binding.progressCircular.setVisibility(View.GONE);
                    binding.list.setAdapter(adapter);
                    Log.e("imprimir","Log : "+businesses);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("Busqueda de negocios");
                    builder.setMessage(R.string.dialog_message);
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}