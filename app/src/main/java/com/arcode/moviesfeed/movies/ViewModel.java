package com.arcode.moviesfeed.movies;

public class ViewModel {
    private String title;
    private String country;

    public ViewModel(String title, String country) {
        this.setTitle(title);
        this.setCountry(country);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
