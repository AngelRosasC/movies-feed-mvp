package com.arcode.moviesfeed.http;

import com.arcode.moviesfeed.http.apimodel.TopMoviesRated;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {
    @GET("top_rated")
    Observable<TopMoviesRated> getTopMoviesRated(@Query("page") int page);
}
