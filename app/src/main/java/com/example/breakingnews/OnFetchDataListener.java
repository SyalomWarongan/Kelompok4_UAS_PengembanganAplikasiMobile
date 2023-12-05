package com.example.breakingnews;

import com.example.breakingnews.Models.ApiNews;

import java.util.List;

public interface OnFetchDataListener<ApiResponse> {
    void onFetchData(List<ApiNews> list, String message);
    void onError(String message);
}
