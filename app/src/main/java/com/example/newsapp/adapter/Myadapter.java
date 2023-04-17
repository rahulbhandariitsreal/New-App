package com.example.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.R;
import com.example.newsapp.databinding.ContentItemNewsBinding;
import com.example.newsapp.model.News;
import com.example.newsapp.view.NewsDetailsActivity;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.viewHolder> {

    private ArrayList<News> newsArrayList;
    private Context context;

    public Myadapter(ArrayList<News> newsArrayList, Context context) {
        this.newsArrayList = newsArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContentItemNewsBinding contentItemNewsBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.content_item_news,parent,false);
        return new viewHolder(contentItemNewsBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.viewHolder holder, int position) {
News currentnew= newsArrayList.get(position);
holder.contentItemNewsBinding.setNews(currentnew);

    }

    @Override
    public int getItemCount() {
        return newsArrayList==null ? 0 : newsArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private ContentItemNewsBinding contentItemNewsBinding;
        public viewHolder(ContentItemNewsBinding contentItemNewsBinding) {
            super(contentItemNewsBinding.getRoot());
            this.contentItemNewsBinding=contentItemNewsBinding;
            contentItemNewsBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                   if(pos!=RecyclerView.NO_POSITION){
                       News selectednews=newsArrayList.get(pos);
                       Intent i =new Intent(context,NewsDetailsActivity.class);
                       i.putExtra("news",selectednews);
                       context.startActivity(i);
                   }
                }
            });
        }
    }
}
