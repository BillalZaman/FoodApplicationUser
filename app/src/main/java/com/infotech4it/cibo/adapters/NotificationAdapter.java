package com.infotech4it.cibo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ItemListNotificationBinding;
import com.infotech4it.cibo.models.NotificationModel;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private ArrayList<NotificationModel> data;
    private Context context;

    public NotificationAdapter(Context context) {
        this.data = new ArrayList<>();
        this.context = context;
    }

    public void setData(ArrayList<NotificationModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListNotificationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_notification, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnNotificationModel(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListNotificationBinding binding;

        public ViewHolder(@NonNull ItemListNotificationBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}

