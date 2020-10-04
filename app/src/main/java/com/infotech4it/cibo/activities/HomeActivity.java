package com.infotech4it.cibo.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.ActivityHomeBinding;
import com.infotech4it.cibo.fragments.HomeFragment;
import com.infotech4it.cibo.fragments.MoreFragment;
import com.infotech4it.cibo.fragments.NotificaitonFragment;
import com.infotech4it.cibo.fragments.ProfileFragment;
import com.infotech4it.cibo.helpers.UIHelper;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private NotificaitonFragment notificaitonFragment;
    private MoreFragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        init();

    }

    private void init() {
        binding.setOnMenuClick(this);
        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        notificaitonFragment = new NotificaitonFragment();
        moreFragment = new MoreFragment();
        UIHelper.replaceFragment(this, R.id.parent, homeFragment);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.dashboard_btn:{
                UIHelper.replaceFragment(this, R.id.parent, homeFragment);
                break;
            }
            case R.id.profile_btn:{
                UIHelper.replaceFragment(this, R.id.parent, profileFragment);
                break;
            }
            case R.id.notification_btn:{
                UIHelper.replaceFragment(this, R.id.parent, notificaitonFragment);
                break;
            }
            case R.id.more_btn:{
                UIHelper.replaceFragment(this, R.id.parent, moreFragment);
                break;
            }
        }
    }

}
