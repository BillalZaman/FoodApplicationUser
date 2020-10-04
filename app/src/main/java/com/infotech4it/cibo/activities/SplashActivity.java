package com.infotech4it.cibo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ActivitySplashBinding;
import com.infotech4it.cibo.helpers.UIHelper;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash);

        init();
    }

    private void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UIHelper.openActivity(SplashActivity.this, LoginActivity.class);
            }
        },2000);
    }
}