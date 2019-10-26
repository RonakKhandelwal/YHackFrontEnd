package com.example.leetcoderecommendation.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.leetcoderecommendation.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        homeViewModel.getFirstFragment().observe(this, new Observer<Fragment>() {

            @Override
            public void onChanged(Fragment fragment) {
                final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.add(R.id.fl1, fragment);
                ft1.commit();
            }
        });

        homeViewModel.getSecondFragment().observe(this, new Observer<Fragment>() {

            @Override
            public void onChanged(Fragment fragment) {
                final FragmentTransaction ft1 = getFragmentManager().beginTransaction();
                ft1.add(R.id.fl2, fragment);
                ft1.commit();
            }
        });
        return root;
    }
}