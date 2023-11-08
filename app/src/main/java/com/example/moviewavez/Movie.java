package com.example.moviewavez;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("Title")

    String Title;
    @SerializedName("Year")

    String Year;
    @SerializedName("Type")
    String Type;
    @SerializedName("Poster")

    String Poster;

    public Movie(String title, String year, String genre,String poster) {
        this.Title = title;
        this.Year = year;
        this.Type = genre;
        this.Poster =poster;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }
}
