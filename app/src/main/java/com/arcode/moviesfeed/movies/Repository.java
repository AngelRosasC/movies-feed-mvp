package com.arcode.moviesfeed.movies;

import com.arcode.moviesfeed.http.apimodel.Result;

import io.reactivex.rxjava3.core.Observable;

public interface Repository {

    Observable<Result> getResultFromNetwork();

    Observable<Result> getResultFromCache();

    Observable<Result> getResultData();

    Observable<String> getCountryFromNetwork();

    Observable<String> getCountryFromCache();

    Observable<String> getCountryData();
}
