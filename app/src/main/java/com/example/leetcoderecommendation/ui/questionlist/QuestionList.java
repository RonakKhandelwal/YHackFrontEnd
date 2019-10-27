package com.example.leetcoderecommendation.ui.questionlist;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import Networking.Callback;
import Networking.Modals.QuestionDetailsModal;
import Utils.NetworkTask;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.leetcoderecommendation.R;
import com.example.leetcoderecommendation.ui.dashboard.RecyclerViewAdapter;

import java.util.List;

public class QuestionList extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_question_list, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recycler_view_question_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(null, getContext());
        recyclerView.setAdapter(adapter);
        final ProgressBar pb = root.findViewById(R.id.progress_bar);
        NetworkTask.getQuestions(new Callback<List<QuestionDetailsModal>>() {
            @Override
            public void returnResult(List<QuestionDetailsModal> questionDetailsModals) {
                RecyclerViewAdapter adapter = ((RecyclerViewAdapter) recyclerView.getAdapter());
                pb.setVisibility(View.GONE);
                if (null != adapter) {
                    adapter.update(questionDetailsModals);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void returnError(String message) {
                pb.setVisibility(View.GONE);
                Log.e("QuestionList", message);
            }
        });

        return root;

    }
}
