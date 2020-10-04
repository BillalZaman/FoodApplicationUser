package com.infotech4it.cibo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ActivityMenuAddItemBinding;
import com.infotech4it.cibo.helpers.UIHelper;

public class MenuAddItemActivity extends AppCompatActivity {
    private ActivityMenuAddItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu_add_item);

        init();
    }

    private void init() {
        binding.setOnMenuDetailClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnAddCart:{
                UIHelper.openActivity(this, CartActivity.class);
                break;
            }

            case R.id.imgCart:{
                UIHelper.openActivity(this, CartActivity.class);
                break;
            }
        }
    }
}