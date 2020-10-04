package com.infotech4it.cibo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.adapters.OrderTrackingAdapter;
import com.infotech4it.cibo.databinding.ActivityOrderTrackingBinding;
import com.infotech4it.cibo.models.OrderTrackingModel;

import java.util.ArrayList;

public class OrderTrackingActivity extends AppCompatActivity {
    private ActivityOrderTrackingBinding binding;
    private OrderTrackingAdapter adapter;
    private ArrayList<OrderTrackingModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_tracking);

        init();
    }

    private void init() {
        adapter = new OrderTrackingAdapter(this);
        for (int i=0;i<=10;i++) {
            data.add(new OrderTrackingModel("Grill Burger", "1000 PKR", "Deal 3",
                    "22-20-2020", "Pending"));
        }
        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }
}