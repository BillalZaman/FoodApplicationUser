package com.infotech4it.cibo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.databinding.FragmentProfileBinding;
import com.infotech4it.cibo.models.UserModel;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private DatabaseReference databaseReference;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        loadUserProfile("User");
    }

    private void loadUserProfile(final String userId) {
        databaseReference = FirebaseDatabase.getInstance().getReference(userId).child(FirebaseAuth.getInstance().getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot restSnapShot : dataSnapshot.getChildren()) {
                    UserModel userModel = restSnapShot.getValue(UserModel.class);
                    binding.setOnUserModel(userModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getActivity(), "Our Server is down, Please try again after some time!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}