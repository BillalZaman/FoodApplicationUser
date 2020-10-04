package com.infotech4it.cibo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.adapters.HomeAdapter;
import com.infotech4it.cibo.databinding.FragmentHomeBinding;
import com.infotech4it.cibo.models.HomeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private ArrayList<HomeModel> data = new ArrayList<>();
    private HomeAdapter adapter;
    private DatabaseReference databaseReference;
    private List<SlideModel> slideModels = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.download, "image"));
        slideModels.add(new SlideModel(R.drawable.download, "image"));
        slideModels.add(new SlideModel(R.drawable.download, "image"));

//        loadSliderData();
        binding.slider.setImageList(slideModels, true);

        adapter = new HomeAdapter(getContext());
        loadData();
//        data.add(new HomeModel(R.drawable.image, "Pizza"));
//        data.add(new HomeModel(R.drawable.image, "Burgers"));
//        data.add(new HomeModel(R.drawable.image, "Sandwich"));
//        data.add(new HomeModel(R.drawable.image, "Wraps"));
//        data.add(new HomeModel(R.drawable.image, "Pasta"));
//        data.add(new HomeModel(R.drawable.image, "Shawarma"));
//        data.add(new HomeModel(R.drawable.image, "Fries"));

//        binding.recyclerview.setAdapter(adapter);
    }

    private void loadData() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("MenuList");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot restSnapShot : dataSnapshot.getChildren()) {
                    HomeModel homeModel = restSnapShot.getValue(HomeModel.class);
                    data.add(homeModel);
                }
                adapter.setData(data);
                binding.recyclerview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Our Server is down, Please try again after some time!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadSliderData() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("MainSlider");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot restSnapShot : dataSnapshot.getChildren()) {
                    SlideModel slideModelll = restSnapShot.getValue(SlideModel.class);
                    slideModels.add(new SlideModel(slideModelll.getImageUrl(), slideModelll.getTitle()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), "Our Server is down, Please try again after some time!",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}