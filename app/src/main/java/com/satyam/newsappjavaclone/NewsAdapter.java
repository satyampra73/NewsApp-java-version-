package com.satyam.newsappjavaclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<Articles> list;
    Context context;

    public NewsAdapter(List<Articles> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.newsitem,parent,false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( NewsAdapter.NewsViewHolder holder, int position) {
holder.title_text.setText(list.get(position).getTitle());
holder.descText.setText(list.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView title_text,descText;
        ImageView imageview;

        public NewsViewHolder(View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.title_text);
            descText = itemView.findViewById(R.id.descText);
            imageview = itemView.findViewById(R.id.imageview);
        }
    }

    }




