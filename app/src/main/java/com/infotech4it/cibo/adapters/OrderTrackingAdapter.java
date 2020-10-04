package com.infotech4it.cibo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ItemListOrderTrackingBinding;
import com.infotech4it.cibo.models.OrderTrackingModel;

import java.util.ArrayList;

public class OrderTrackingAdapter extends RecyclerView.Adapter<OrderTrackingAdapter.ViewHolder> {

    private ArrayList<OrderTrackingModel> data;
    private Context context;

    public OrderTrackingAdapter(Context context) {
        this.data = new ArrayList<>();
        this.context = context;
    }

    public void setData(ArrayList<OrderTrackingModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListOrderTrackingBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_order_tracking, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnOrderTrackingMode(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListOrderTrackingBinding binding;

        public ViewHolder(@NonNull ItemListOrderTrackingBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}


