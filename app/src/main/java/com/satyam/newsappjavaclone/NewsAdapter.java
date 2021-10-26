package com.satyam.newsappjavaclone;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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
        Glide.with(context).load(list.get(position).urlToImage).into(holder.imageview);

//        holder.itemView.setOnClickListener {
//            val intent= Intent(context,ArticleActivity::class.java)
//            intent.putExtra("image",list[position].urlToImage)
//            intent.putExtra("title",list[position].title)
//            intent.putExtra("author",list[position].author)
//            intent.putExtra("description",list[position].description)
//            intent.putExtra("url",list[position].url)
//            //can do above lines val bundle= bundleOf("image" to list[position].urlToImage,"title" to list[position].title,-----)
//            //intent.extras?.putAll(bundle)
//            context.startActivity(intent)
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,activity_artical.class);
                intent.putExtra("image",list.get(position).urlToImage);
                intent.putExtra("title",list.get(position).title);
                intent.putExtra("author",list.get(position).author);
                intent.putExtra("description",list.get(position).description);
                intent.putExtra("url",list.get(position).url);
                context.startActivity(intent);

            }
        });

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




