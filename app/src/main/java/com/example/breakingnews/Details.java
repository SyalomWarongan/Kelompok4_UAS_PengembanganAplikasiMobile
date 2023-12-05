package com.example.breakingnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.breakingnews.Models.ApiNews;
import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
    ApiNews headlines;
    TextView TheTitle, TheContent, TheAuthor, TheDetail, TheDate;
    ImageView imgForNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imgForNews = findViewById(R.id.img_detail);
        TheTitle = findViewById(R.id.title_detail);
        TheContent = findViewById(R.id.detail_content);
        TheDate = findViewById(R.id.detail_date);
        TheAuthor = findViewById(R.id.detail_author);
        TheDetail = findViewById(R.id.details);

        headlines = (ApiNews) getIntent().getSerializableExtra("data");

        TheTitle.setText(headlines.getTitle());
        TheContent.setText(headlines.getContent());
        TheAuthor.setText(headlines.getAuthor());
        TheDetail.setText(headlines.getDescription());
        TheDate.setText(headlines.getPublishedAt());
        Picasso.get().load(headlines.getUrlToImage()).into(imgForNews);
    }
}