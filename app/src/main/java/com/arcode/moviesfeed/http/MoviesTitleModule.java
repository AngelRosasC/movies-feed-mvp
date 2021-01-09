package com.arcode.moviesfeed.http;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MoviesTitleModule {
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    public final String API_KEY = "741c19f2cf73563189df25eefbf0c247";

    @Provides
    public OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor((chain -> {
                    Request request = chain.request();
                    HttpUrl url = request.url().newBuilder().addQueryParameter("api_key", API_KEY).build();
                    request = request.newBuilder().url(url).build();
                    return chain.proceed(request);
                }))
                .build();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Provides
    public MoviesApiService provideMoviesApiService() {
        return provideRetrofit(BASE_URL, provideOkHttpClient()).create(MoviesApiService.class);
    }

}
