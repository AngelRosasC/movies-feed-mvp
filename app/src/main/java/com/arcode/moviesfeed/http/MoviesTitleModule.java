package com.arcode.moviesfeed.http;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Module
public class MoviesTitleModule {
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public final String API_KEY = "741c19f2cf73563189df25eefbf0c247";

    @Provides
    public OkHttpClient provideOkHttpClient() {
        return null;
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return null;
    }

    @Provides
    public MoviesApiService provideMoviesApiService() {
        return provideRetrofit(BASE_URL, provideOkHttpClient()).create(MoviesApiService.class);
    }

}
