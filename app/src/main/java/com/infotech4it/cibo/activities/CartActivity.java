package com.infotech4it.cibo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.adapters.CartAdapter;
import com.infotech4it.cibo.databinding.ActivityCartBinding;
import com.infotech4it.cibo.helpers.UIHelper;
import com.infotech4it.cibo.models.CartModel;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding binding;
    private CartAdapter adapter;
    private ArrayList<CartModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        initData();
    }

    private void initData() {
        binding.setOnClick(this);
        data = new ArrayList<>();
        adapter = new CartAdapter(this);
        data.add(new CartModel(R.drawable.home_product_image, "Pizza","100 PKR"));
        data.add(new CartModel(R.drawable.home_product_image, "Pizza","100 PKR"));
        data.add(new CartModel(R.drawable.home_product_image, "Pizza","100 PKR"));
        data.add(new CartModel(R.drawable.home_product_image, "Pizza","100 PKR"));

        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnCheckout:{
                UIHelper.openActivity(this, ConfirmCheckoutActivity.class);
                break;
            }
            case R.id.btnDiscount:{

                break;
            }
        }
    }
}