package com.infotech4it.cibo.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.activities.ChangePasswordActivity;
import com.infotech4it.cibo.activities.LoginActivity;
import com.infotech4it.cibo.activities.OrderTrackingActivity;
import com.infotech4it.cibo.databinding.FragmentMoreBinding;
import com.infotech4it.cibo.databinding.FragmentMoreBindingImpl;
import com.infotech4it.cibo.helpers.UIHelper;

public class MoreFragment extends Fragment {
    private FragmentMoreBinding binding;

    public MoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_more, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        binding.setOnMoreClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.txtOrderTracking:{
                UIHelper.openActivity((Activity) getContext(), OrderTrackingActivity.class);
                break;
            }
            case R.id.txtChangePassword:{
                UIHelper.openActivity((Activity) getContext(), ChangePasswordActivity.class);
                break;
            }
            case R.id.txtFavMenu:{
                UIHelper.showLongToastInCenter(getActivity(), "In Progress");
                break;
            }
            case R.id.txtLogout:{
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getContext(), "Logout Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                break;
            }
            case R.id.txtAboutus:{
                UIHelper.showLongToastInCenter(getActivity(), "In Progress");
                break;
            }
            case R.id.txtWho:{
                UIHelper.showLongToastInCenter(getActivity(), "In Progress");
                break;
            }
            case R.id.txtPrivacy:{
                UIHelper.showLongToastInCenter(getActivity(), "In Progress");
                break;
            }
        }
    }
}