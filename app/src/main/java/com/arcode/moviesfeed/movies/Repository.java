package com.arcode.moviesfeed.movies;

import com.arcode.moviesfeed.http.apimodel.Result;

import io.reactivex.rxjava3.core.Observable;

public interface Repository {
    Observable<Result> getResultData();

    Observable<String> getCountryData();
}
