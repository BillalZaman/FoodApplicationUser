package com.infotech4it.cibo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.infotech4it.cibo.R;
import com.infotech4it.cibo.adapters.NotificationAdapter;
import com.infotech4it.cibo.databinding.FragmentNotificaitonBinding;
import com.infotech4it.cibo.models.NotificationModel;

import java.util.ArrayList;


public class NotificaitonFragment extends Fragment {
    private FragmentNotificaitonBinding binding;
    private NotificationAdapter adapter;
    private ArrayList<NotificationModel> data = new ArrayList<>();

    public NotificaitonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notificaiton, container, false);
        init();
        return binding.getRoot();
    }

    private void init() {
        adapter = new NotificationAdapter(getContext());
        for (int i = 0; i <= 10; i++) {
            data.add(new NotificationModel("Heading",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."));
        }
        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }
}