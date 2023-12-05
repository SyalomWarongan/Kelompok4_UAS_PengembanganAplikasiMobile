package com.example.breakingnews.Models;

import java.io.Serializable;
import java.util.List;

public class ApiResponse implements Serializable {
    String status;
    int totalResults;
    List<ApiNews> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ApiNews> getArticles() {
        return articles;
    }

    public void setArticles(List<ApiNews> articles) {
        this.articles = articles;
    }
}