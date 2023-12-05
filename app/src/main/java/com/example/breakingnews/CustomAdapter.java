package com.example.breakingnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.breakingnews.Models.ApiNews;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<ApiNews> headlines;
    private SeListener listener;

    public CustomAdapter(Context context, List<ApiNews> headlines, SeListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.newlist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.Ttitle.setText(headlines.get(position).getTitle());
        holder.Tsource.setText(headlines.get(position).getSource().getName());

        if(headlines.get(position).getUrlToImage()!=null) {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_news);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked(headlines.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
