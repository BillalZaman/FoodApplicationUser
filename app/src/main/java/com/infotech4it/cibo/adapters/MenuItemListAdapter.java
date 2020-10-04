package com.infotech4it.cibo.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.activities.MenuAddItemActivity;
import com.infotech4it.cibo.databinding.ItemListMenuListBinding;
import com.infotech4it.cibo.helpers.UIHelper;
import com.infotech4it.cibo.models.MenuListModel;

import java.util.ArrayList;

public class MenuItemListAdapter extends RecyclerView.Adapter<MenuItemListAdapter.ViewHolder> {

    private ArrayList<MenuListModel> data;
    private Context context;

    public MenuItemListAdapter(Context context) {
        this.data = new ArrayList<>();
        this.context = context;
    }

    public void setData(ArrayList<MenuListModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMenuListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_menu_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setOnMenuitem(data.get(position));
        Glide.with(context).load(data.get(position).getItemImage()).into(holder.binding.imageView5);
        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity((Activity) context, MenuAddItemActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListMenuListBinding binding;

        public ViewHolder(@NonNull ItemListMenuListBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}


