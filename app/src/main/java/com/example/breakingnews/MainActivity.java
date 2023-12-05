package com.example.breakingnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.breakingnews.Models.ApiNews;
import com.example.breakingnews.Models.ApiResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SeListener, View.OnClickListener {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    ProgressDialog dialog;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searching);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Loading news about " + query);
                dialog.show();
                ReqManager manager = new ReqManager(MainActivity.this);
                manager.getApiNews(listener, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading news...");
        dialog.show();

        btn_1 = findViewById(R.id.btn1);
        btn_1.setOnClickListener(this);
        btn_2 = findViewById(R.id.btn2);
        btn_2.setOnClickListener(this);
        btn_3 = findViewById(R.id.btn3);
        btn_3.setOnClickListener(this);
        btn_4 = findViewById(R.id.btn4);
        btn_4.setOnClickListener(this);
        btn_5 = findViewById(R.id.btn5);
        btn_5.setOnClickListener(this);
        btn_6 = findViewById(R.id.btn6);
        btn_6.setOnClickListener(this);
        btn_7 = findViewById(R.id.btn7);
        btn_7.setOnClickListener(this);

        ReqManager manager = new ReqManager(this);
        manager.getApiNews(listener, "general", null);

    }

    private final OnFetchDataListener<ApiResponse> listener = new OnFetchDataListener<ApiResponse>() {
        @Override
        public void onFetchData(List<ApiNews> list, String message)
        {
            if (list.isEmpty()) {
                Toast.makeText(MainActivity.this, "Nothing here..", Toast.LENGTH_SHORT).show();
            } else {

                showNews(list);
                dialog.dismiss();

            }
        }

        @Override
        public void onError(String message)
        {
            Toast.makeText(MainActivity.this, "Error.", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<ApiNews> list) {
        recyclerView = findViewById(R.id.recy_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnNewsClicked(ApiNews headlines) {
        startActivity(new Intent(MainActivity.this, Details.class)
                .putExtra("data", headlines));

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        String category = button.getText().toString();
        dialog.setTitle("Loading news about " + category);
        dialog.show();
        ReqManager manager = new ReqManager(this);
        manager.getApiNews(listener, category, null);
    }
}