package com.arcode.moviesfeed.movies;

import io.reactivex.rxjava3.core.Observable;

public interface MoviesRepository {
    Observable<Result> getResultData();

    Observable<String> getCountryData();
}
