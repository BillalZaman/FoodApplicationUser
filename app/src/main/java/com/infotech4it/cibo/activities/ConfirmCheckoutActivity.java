package com.infotech4it.cibo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ActivityConfirmCheckoutBinding;
import com.infotech4it.cibo.helpers.UIHelper;

public class ConfirmCheckoutActivity extends AppCompatActivity {
    private ActivityConfirmCheckoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_confirm_checkout);

        init();
    }

    private void init() {
        binding.setOnClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.imgBack:{
                finish();
                break;
            }
            case R.id.btnCheckout:{
                UIHelper.openActivity(this, ThankyouActivity.class);
                break;
            }
        }
    }
}