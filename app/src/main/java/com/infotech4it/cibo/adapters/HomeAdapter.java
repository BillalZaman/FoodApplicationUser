package com.infotech4it.cibo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ItemListMenuBinding;
import com.infotech4it.cibo.interfaces.HomeInterface;
import com.infotech4it.cibo.models.HomeModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<HomeModel> data;
    private Context context;

    public HomeAdapter(Context context) {
        this.data = new ArrayList<>();
        this.context = context;
    }

    public void setData(ArrayList<HomeModel> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListMenuBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item_list_menu, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binding.setOnHomeModel(data.get(position));

        Glide.with(context).load(data.get(position).getImage()).into(holder.binding.imageView3);

        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeInterface homeInterface = (HomeInterface) context;
                homeInterface.dashboardClick(position);
//                UIHelper.openActivity((Activity) context, MenuListActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemListMenuBinding binding;

        public ViewHolder(@NonNull ItemListMenuBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
