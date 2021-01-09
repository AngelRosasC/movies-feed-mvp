package com.arcode.moviesfeed.http;

import com.arcode.moviesfeed.http.apimodel.TopMoviesRated;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MoviesApiService {
    @GET("top_rated")
    Call<TopMoviesRated> getTopMoviesRated(@Query("api_key") String api_key, @Query("page") int page);
}
