package com.infotech4it.cibo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ItemListCartBinding;
import com.infotech4it.cibo.models.CartModel;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<CartModel> data;
    private Context context;

    public CartAdapter(Context context) {
        this.data = new ArrayList<>();
        this.context = context;
    }

    public void setData(ArrayList<CartModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListCartBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_cart, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListCartBinding binding;

        public ViewHolder(@NonNull ItemListCartBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}