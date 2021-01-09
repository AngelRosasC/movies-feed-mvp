package com.arcode.moviesfeed.movies;

import com.arcode.moviesfeed.http.MoviesApiInfoService;
import com.arcode.moviesfeed.http.MoviesApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MoviesModule {
    @Provides
    public MoviesMVP.Presenter provideMoviesPresenter(MoviesMVP.Model model) {
        return new MoviesPresenter(model);
    }

    @Provides
    public MoviesMVP.Model provideMoviesModel(Repository repository) {
        return new MoviesModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideMoviesRepository(MoviesApiService moviesApiService, MoviesApiInfoService moviesApiInfoService) {
        return new MoviesRepository(moviesApiService, moviesApiInfoService);
    }

}
