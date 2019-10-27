package com.example.leetcoderecommendation.ui.leaderboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import Networking.Callback;
import Networking.Modals.QuestionDetailsModal;
import Utils.NetworkTask;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.leetcoderecommendation.R;
import com.example.leetcoderecommendation.ui.dashboard.RecyclerViewAdapter;

import java.util.List;


public class Leaderboard extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_leaderboard, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        ProgressBar pb = root.findViewById(R.id.progress_bar);
//        pb.setVisibility(View.GONE);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
