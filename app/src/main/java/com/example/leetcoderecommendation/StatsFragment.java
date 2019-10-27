package com.example.leetcoderecommendation;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.leetcoderecommendation.ui.dashboard.DashboardFragment;

public class StatsFragment extends Fragment {

    private StatsViewModel mViewModel;

    public static StatsFragment newInstance() {
        return new StatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel =
                ViewModelProviders.of(this).get(StatsViewModel.class);
        View root = inflater.inflate(R.layout.stats_fragment, container, false);
//        final TextView textView = root.findViewById(R.id.text_stats);
//        mViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        if (root instanceof CardView){
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.ft_stats, new DashboardFragment());
            ft.commit();
        }
        return root;
        //return inflater.inflate(R.layout.stats_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StatsViewModel.class);
        // TODO: Use the ViewModel
    }

}
