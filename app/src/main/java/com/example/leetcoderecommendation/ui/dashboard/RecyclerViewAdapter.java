package com.example.leetcoderecommendation.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leetcoderecommendation.R;

import java.util.List;

import Networking.Modals.QuestionDetailsModal;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    List<QuestionDetailsModal> questions;
    Context mContext;

    public RecyclerViewAdapter(List<QuestionDetailsModal> questions, Context context) {
        super();
        this.questions = questions;
        this.mContext = context;
    }


    public void update(List<QuestionDetailsModal> questions) {
        this.questions = questions;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, difficulty;
        public MyViewHolder(View v, TextView title, TextView difficulty) {
            super(v);
            this.title = title;
            this.difficulty = difficulty;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_list_item,
                parent, false);
        return new MyViewHolder(root, (TextView)root.findViewById(R.id.title_tv), (TextView)root.findViewById(R.id.difficulty));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (null != questions) {
            final QuestionDetailsModal question = this.questions.get(position);
            MyViewHolder viewHolder = (MyViewHolder) holder;
            TextView title = viewHolder.title;
            TextView difficulty = viewHolder.difficulty;
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(question.getUrl()));
                    mContext.startActivity(browserIntent);
                }
            });
            if (question != null) {
                title.setText(question.getTitle());
                difficulty.setText(question.getDifficulty());
            }
        }
    }

    @Override
    public int getItemCount() {
        if (null == this.questions){
            return 0;
        }
        return this.questions.size();
    }
}
