package com.arcode.moviesfeed.root;

import android.app.Application;

import com.arcode.moviesfeed.http.MoviesCountryModule;
import com.arcode.moviesfeed.http.MoviesTitleModule;
import com.arcode.moviesfeed.movies.MoviesModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .moviesModule(new MoviesModule())
                .moviesTitleModule(new MoviesTitleModule())
                .moviesCountryModule(new MoviesCountryModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
