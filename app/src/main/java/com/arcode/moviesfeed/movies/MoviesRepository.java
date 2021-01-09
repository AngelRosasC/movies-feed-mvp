package com.arcode.moviesfeed.movies;

import com.arcode.moviesfeed.http.MoviesApiInfoService;
import com.arcode.moviesfeed.http.MoviesApiService;
import com.arcode.moviesfeed.http.apimodel.Result;

import io.reactivex.rxjava3.core.Observable;

public class MoviesRepository implements Repository {

    private MoviesApiService moviesApiService;
    private MoviesApiInfoService moviesApiInfoService;

    public MoviesRepository(MoviesApiService moviesApiService, MoviesApiInfoService moviesApiInfoService) {
        this.moviesApiService = moviesApiService;
        this.moviesApiInfoService = moviesApiInfoService;
    }

    @Override
    public Observable<Result> getResultData() {
        return null;
    }

    @Override
    public Observable<String> getCountryData() {
        return null;
    }
}
