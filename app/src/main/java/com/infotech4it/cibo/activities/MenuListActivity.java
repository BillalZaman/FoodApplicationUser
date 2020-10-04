package com.infotech4it.cibo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.infotech4it.cibo.R;
import com.infotech4it.cibo.adapters.MenuItemListAdapter;
import com.infotech4it.cibo.databinding.ActivityMenuListBinding;
import com.infotech4it.cibo.models.MenuListModel;

import java.util.ArrayList;

public class MenuListActivity extends AppCompatActivity {
    private ActivityMenuListBinding binding;
    private ArrayList<MenuListModel> data = new ArrayList<>();
    private MenuItemListAdapter adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_menu_list);

        init();
    }

    private void init() {
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter = new MenuItemListAdapter(this);
        loadData("pizzaList");
    }

    private void loadData(String listName) {
        databaseReference = FirebaseDatabase.getInstance().getReference().child(listName);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot restSnapShot : dataSnapshot.getChildren()) {
                    MenuListModel menuListModel = restSnapShot.getValue(MenuListModel.class);
                    data.add(menuListModel);
                }
                adapter.setData(data);
                binding.recyclerview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MenuListActivity.this, "Our Server is down, Please try again after some time!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}