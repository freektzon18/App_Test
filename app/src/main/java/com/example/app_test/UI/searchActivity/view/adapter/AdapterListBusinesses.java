package com.example.app_test.UI.searchActivity.view.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_test.R;
import com.example.app_test.UI.searchActivity.view.MainActivity;
import com.example.app_test.data.response.Businesses;
import com.example.app_test.databinding.ItemBusinessListBinding;

import java.util.List;

public class AdapterListBusinesses extends RecyclerView.Adapter<AdapterListBusinesses.ViewHolder> {

    private List<Businesses> businessesList;
    private LayoutInflater layoutInflater;
    public Listener listener;

    public AdapterListBusinesses(List<Businesses> businesses, Listener listener) {
        this.businessesList = businesses;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemBusinessListBinding item = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_business_list,parent,false
        );
        return new AdapterListBusinesses.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.bindingBusiness(businessesList.get(position));

    }

    @Override
    public int getItemCount() {
        return businessesList.size();
    }

      class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemBusinessListBinding binding;

        public ViewHolder(ItemBusinessListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindingBusiness(Businesses businesses){
            binding.setBusinesses(businesses);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(view -> listener.onTVShowCLicked(businesses));
        }

    }

}
