package com.example.moviewavez;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("Search")
    private List<Movie> searchResults;

    public List<Movie> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Movie> searchResults) {
        this.searchResults = searchResults;
    }
}
