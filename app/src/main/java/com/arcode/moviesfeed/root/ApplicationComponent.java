package com.arcode.moviesfeed.root;

import com.arcode.moviesfeed.MainActivity;
import com.arcode.moviesfeed.http.MoviesCountryModule;
import com.arcode.moviesfeed.http.MoviesTitleModule;
import com.arcode.moviesfeed.movies.MoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, MoviesModule.class, MoviesTitleModule.class, MoviesCountryModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
