package com.arcode.moviesfeed.movies;

import com.arcode.moviesfeed.http.MoviesApiInfoService;
import com.arcode.moviesfeed.http.MoviesApiService;
import com.arcode.moviesfeed.http.apimodel.Result;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class MoviesRepository implements Repository {

    private MoviesApiService moviesApiService;
    private MoviesApiInfoService moviesApiInfoService;

    private List<String> lsCountries;
    private List<Result> lsResults;
    private long lastTimestamp;

    private static final long CACHE_LIFETIME = 20 * 1000; // Tiempo de vida de la cache

    public MoviesRepository(MoviesApiService moviesApiService, MoviesApiInfoService moviesApiInfoService) {
        this.moviesApiService = moviesApiService;
        this.moviesApiInfoService = moviesApiInfoService;

        this.lsCountries = new ArrayList<>();
        this.lsResults = new ArrayList<>();

        this.lastTimestamp = System.currentTimeMillis();
    }

    private boolean isUpdate() {
        return (System.currentTimeMillis() - lastTimestamp) < CACHE_LIFETIME;
    }

    @Override
    public Observable<Result> getResultFromNetwork() {
        return null;
    }

    @Override
    public Observable<Result> getResultFromCache() {
        if (!isUpdate()) return Observable.fromIterable(lsResults);

        lastTimestamp = System.currentTimeMillis();
        lsResults.clear();
        return Observable.empty();
    }

    @Override
    public Observable<Result> getResultData() {
        return null;
    }

    @Override
    public Observable<String> getCountryFromNetwork() {
        return null;
    }

    @Override
    public Observable<String> getCountryFromCache() {
        if (isUpdate()) return Observable.fromIterable(lsCountries);

        lastTimestamp = System.currentTimeMillis();
        lsCountries.clear();
        return Observable.empty();
    }

    @Override
    public Observable<String> getCountryData() {
        return null;
    }
}
