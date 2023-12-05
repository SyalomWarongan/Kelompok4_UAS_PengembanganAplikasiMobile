package com.example.breakingnews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView Ttitle, Tsource;
    ImageView img_news;
    CardView cardView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        Ttitle = itemView.findViewById(R.id.Ttitle);
        Tsource = itemView.findViewById(R.id.Tsource);
        img_news = itemView.findViewById(R.id.img_news);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
