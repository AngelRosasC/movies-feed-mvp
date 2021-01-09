package com.arcode.moviesfeed.http;

import com.arcode.moviesfeed.http.apimodel.OmdbApi;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiInfoService {
    @GET("/")
    Observable<OmdbApi> getOmdbApi(@Query("t") String title);
}
